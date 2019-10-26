package trabalhocompmovel.ui.main.reconhecimentoActivity;

import android.hardware.SensorEvent;
import android.util.Log;

import trabalhocompmovel.WekaAtividade;
import trabalhocompmovel.WekaIntensidadeAndando;
import trabalhocompmovel.WekaIntensidadeDeitado;
import trabalhocompmovel.WekaIntensidadeSentado;

import trabalhocompmovel.data.DataManager;
import trabalhocompmovel.ui.base.BasePresenter;
import trabalhocompmovel.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

import static trabalhocompmovel.utils.AppConstants.PARAMS_SIZE;

public class ReconhecimentoPresenter <V extends ReconhecimentoMvpView> extends BasePresenter<V>
        implements ReconhecimentoMvpPresenter<V>  {

    private static Object[] parametros = new Object[7];
    ReconhecimentoActivity reconhecimentoActivity = new ReconhecimentoActivity();

    // Recebe o retorno da atividade/intensidade d Object[7];
    //    ReconhecimentoActivity reconhecimentoActivity = new ReconhecimentoActivity();o weka
    private static double respostaAtividade = -1;

    // ArrayList para armazenar os valores durante o tempo da janela
    private ArrayList<Float> arrayX = new ArrayList<>();
    private ArrayList<Float> arrayY = new ArrayList<>();
    private ArrayList<Float> arrayZ = new ArrayList<>();

    @Inject
    public ReconhecimentoPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void sensorChanged(SensorEvent sensorEvent, boolean timeFrame) {

        //Se o tempo for >= a janela definida
        if(timeFrame){

            //Calculo das médias/variancias dos dados que estão nos arrays
            // Os numeros são a posição de cada elemento no vetor parametro[]
            double mediaX = CalculaMedia(arrayX,1);
            double mediaY = CalculaMedia(arrayY,3);
            double mediaZ = CalculaMedia(arrayZ,5);
            CalculaVariancia(arrayX,0, mediaX);
            CalculaVariancia(arrayY,2, mediaY);
            CalculaVariancia(arrayZ,4, mediaZ);
            CalculaRMS(mediaX,mediaY,mediaZ,6);

            // Envio para a classe do Weka o Object[]
            try {
                respostaAtividade = WekaAtividade.classify(parametros);
                Log.d("mylog respostaAtividade", Double.toString(respostaAtividade));
                // Toast.makeText(this, ""+ resposta, Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                reconhecimentoActivity.onError(e);
            }

            // Verifica a resposta retornada pelo Weka e exibe na tela
            VerificaResposta(respostaAtividade);


        }else{
            // Se o tempo for menor que a janela, salvo no array
            arrayX.add(sensorEvent.values[0]);
            arrayY.add((sensorEvent.values[1] * -1));
            arrayZ.add(sensorEvent.values[2]);
        }
    }

    private double CalculaMedia(ArrayList<Float> array, int pos){
        int i = array.size();
        float total = 0;

        for(Float f : array){
            total += f;
        }

        String r = ""+total/i;
        parametros[pos] =  Double.parseDouble(r);
        return total/i;
    }

    private void CalculaVariancia(ArrayList<Float> array, int pos, double media){
        int i = array.size();
        float sum = 0;
        float n = 0;
        float media2 = (float) media;
        /*
            x = Valor atual
            X = Media
            n = nº de elementos
            S² = ( Sum(x - X)² ) / (n - 1)
        */
        for(Float f : array){
            n = ((f-media2) * (f-media2));
            sum += n;
        }


        String r = ""+sum/(i);

        parametros[pos] = Double.parseDouble(r);
    }

    private void EsvaziarArray(){
        arrayX.clear();
        arrayY.clear();
        arrayZ.clear();

        for(int i=0 ; i < PARAMS_SIZE ; i++) {
            parametros[i] = null;
        }
    }

    private void VerificaResposta(double p){
        double intensidade = -1;

        // Andando
        if(p == 0 || p == 1 || p == 2){
            try{
                intensidade = WekaIntensidadeAndando.classify(parametros);
            }catch (Exception e){
                reconhecimentoActivity.onError(e);
            }

            if(intensidade == 0){ // Andando Leve
                reconhecimentoActivity.setAndandoLeve();

            }else if(intensidade == 1){ // Andando Moderado
                reconhecimentoActivity.setAndandoModerado();

            }else if(intensidade == 2){ // Correndo
                reconhecimentoActivity.setCorrendo();
            }

            // Sentado
        }else if(p == 3 || p == 4 || p == 5){
            try{
                intensidade = WekaIntensidadeSentado.classify(parametros);
            }catch (Exception e){
                reconhecimentoActivity.onError(e);
            }

            if(intensidade == 0){   // Sentado Leve
                reconhecimentoActivity.setSentadoLeve();

            }else if(intensidade == 1){ //Sentado Moderado
                reconhecimentoActivity.setSentadoModerado();

            }else if(intensidade == 2){ //Sentado Vigoroso
                reconhecimentoActivity.setSentadoMovimentando();
            }

        }else if(p == 6 || p == 7 || p == 8){   //Deitado
            try{
                intensidade = WekaIntensidadeDeitado.classify(parametros);
            }catch (Exception e){
                reconhecimentoActivity.onError(e);
            }
            if(intensidade == 0){   //Deitado Leve
                reconhecimentoActivity.setDeitadoLeve();

            }else if(intensidade == 1){ // Deitado Moderado
                reconhecimentoActivity.setDeitadoModerado();


            }else  if(intensidade == 2) {    // Deitado Vigoroso
                reconhecimentoActivity.setDeitadoMovimentando();
            }
        }

        EsvaziarArray();
    }

    private void CalculaRMS(double x, double y, double z, int pos){
        //rms = raiz(x² + y² + z²)
        double x1 = x*x;
        double y1 = y*y;
        double z1 = z*z;
        double soma = x1+y1+z1;

        parametros[pos] =  Math.sqrt(soma);
    }

}
