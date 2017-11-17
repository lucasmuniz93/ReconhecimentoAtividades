package com.example.lukaas.trabalhocompmovel;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class ReconhecimentoActivity extends AppCompatActivity implements SensorEventListener{

    private float[] gravity = new float[3];
    private static Object[] parametros = new Object[7];


    //ArrayList para armazenar os valores durante o tempo da janela
    private ArrayList<Float> arrayX = new ArrayList<>();
    private ArrayList<Float> arrayY = new ArrayList<>();
    private ArrayList<Float> arrayZ = new ArrayList<>();

    //Variaveis relativas ao tempo
    private double TAMANHO_JANELA = 2.5;
    private long tempoStart = 0;

    // Layout
    private TextView atividade;
    private TextView txtMediaX;
    private TextView txtMediaY;
    private TextView txtMediaZ;
    private TextView txtVarX;
    private TextView txtVarY;
    private TextView txtVarZ;
    private TextView txtRms;
    private TextView txtTempoJanela;
    private TextView txtTempo;
    private TextView txtResposta;
    private ImageView imgAtividade;
    private Switch switchSom;
    private MediaPlayer mediaPlayer;
    private int flagAudio = 10;

    // Sensores
    private Sensor mySensor;
    private SensorManager SM;

    // Classe Weka que verifica a identidade e intensidade;
    private WekaAtividade weka = new WekaAtividade();
    private WekaIntensidadeAndando wekaIntensidadeAndando = new WekaIntensidadeAndando();
    private WekaIntensidadeDeitado wekaIntensidadeDeitado = new WekaIntensidadeDeitado();
    private WekaIntensidadeSentado wekaIntensidadeSentado = new WekaIntensidadeSentado();

    // Recebe o retorno da atividade/intensidade do weka
    private static double respostaAtividade = -1;
    private static double respostaIntensidade = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconhecimento);

        //Cast
        atividade = (TextView) findViewById(R.id.txtAtividade2);
        switchSom = (Switch) findViewById(R.id.switch2);
        imgAtividade = (ImageView) findViewById(R.id.imgAtividade);
        txtMediaX = (TextView) findViewById(R.id.txtMediaX);
        txtMediaY = (TextView) findViewById(R.id.txtMediaY);
        txtMediaZ = (TextView) findViewById(R.id.txtMediaZ);
        txtVarX = (TextView) findViewById(R.id.txtVarX);
        txtVarY = (TextView) findViewById(R.id.txtVarY);
        txtVarZ = (TextView) findViewById(R.id.txtVarZ);
        txtRms = (TextView) findViewById(R.id.txtRms);
        txtTempo = (TextView) findViewById(R.id.txtTempo);
        txtTempoJanela = (TextView) findViewById(R.id.txtTempoJanela);
        txtResposta = (TextView) findViewById(R.id.txtResposta);

        // Criar o Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        tempoStart = System.currentTimeMillis();
        txtTempoJanela.setText("" + TAMANHO_JANELA);

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        final String x = " "+sensorEvent.values[0];
        final String y = " "+sensorEvent.values[1];
        final String z = " "+sensorEvent.values[2];

        //Se o tempo for >= a janela definida
        if(VerificaJanela()){

            //Calculo das médias/variancias dos dados que estão nos arrays
            double mediaX = CalculaMedia(arrayX,1);
            double mediaY = CalculaMedia(arrayY,3);
            double mediaZ = CalculaMedia(arrayZ,5);
            CalculaVariancia(arrayX,0, mediaX);
            CalculaVariancia(arrayY,2, mediaY);
            CalculaVariancia(arrayZ,4, mediaZ);
            CalculaRMS(mediaX,mediaY,mediaZ,6);

            txtMediaX.setText(""+parametros[1] );
            txtMediaY.setText(""+parametros[3] );
            txtMediaZ.setText(""+parametros[5] );

            txtVarX.setText(""+parametros[0]);
            txtVarY.setText(""+parametros[2]);
            txtVarZ.setText(""+parametros[4]);

            txtRms.setText(""+parametros[6]);

            // Envio para a classe do Weka o Object[]
            try {
                    respostaAtividade = WekaAtividade.classify(parametros);
                // Toast.makeText(this, ""+ resposta, Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, ""+ e, Toast.LENGTH_SHORT).show();
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

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    private void VerificaResposta(double p){
        double intensidade = -1;

        // Andando
        if(p == 0 || p == 1 || p == 2){
            try{
                intensidade = WekaIntensidadeAndando.classify(parametros);
            }catch (Exception e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }
            // Andando Leve
            if(intensidade == 0){
                atividade.setText("Andando Leve");
                imgAtividade.setImageResource(R.drawable.andandoleve);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.andandoleve);
                }
            // Andando Moderado
            }else if(intensidade == 1){
                atividade.setText("Andando Moderado");
                imgAtividade.setImageResource(R.drawable.andandomoderado);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.andandomoderado);
                }
            // Andando Vigoroso
            }else if(intensidade == 2){
                atividade.setText("Andando Vigoroso");
                imgAtividade.setImageResource(R.drawable.andandovigoroso);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.andandovigoroso);
                }
            }

         // Sentado
        }else if(p == 3 || p == 4 || p == 5){
            try{
                intensidade = WekaIntensidadeSentado.classify(parametros);
            }catch (Exception e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }
            // Sentado Leve
            if(intensidade == 0){
                atividade.setText("Sentado Leve");
                imgAtividade.setImageResource(R.drawable.sentadoleve);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.sentadoleve);
                }

             //Sentado Moderado
            }else if(intensidade == 1){
                atividade.setText("Sentado Moderado");
                imgAtividade.setImageResource(R.drawable.sentadomoderado);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.sentadomoderado);
                }
            //Sentado Vigoroso
            }else if(intensidade == 2){
                atividade.setText("Sentado Vigoroso");
                imgAtividade.setImageResource(R.drawable.sentadovigoroso);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.sentadovigoroso);
                }
            }
        //Deitado
        }else if(p == 6 || p == 7 || p == 8){
            try{
                intensidade = WekaIntensidadeDeitado.classify(parametros);
            }catch (Exception e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }
            //Deitado Leve
            if(intensidade == 0){
                atividade.setText("Deitado Leve");
                imgAtividade.setImageResource(R.drawable.deitadoleve);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.deitadoleve);
                }
            //Deitado Moderado
            }else if(intensidade == 1){
                atividade.setText("Deitado Moderado");
                imgAtividade.setImageResource(R.drawable.deitadomoderado);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.deitadomoderado);
                }

            // Deitado Vigoroso
            }else  if(intensidade == 2){
                atividade.setText("Deitado Vigoroso");
                imgAtividade.setImageResource(R.drawable.deitadovigoroso);

                if(switchSom.isChecked()){
                    ExecutarAudio(R.raw.deitadovigoroso);
                }
            }

        }

       EsvaziarArray();

    }


    private boolean VerificaJanela(){
        double t =(double) ((System.currentTimeMillis() - tempoStart)/1000);

        txtTempo.setText(""+((System.currentTimeMillis() - tempoStart)/1000));

        if(t >= TAMANHO_JANELA ){
            tempoStart = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    private void CalculaRMS(double x, double y, double z, int pos){
        //rms = raiz(x² + y² + z²)
        double x1 = x*x;
        double y1 = y*y;
        double z1 = z*z;
        double soma = x1+y1+z1;

        parametros[pos] =  Math.sqrt(soma);
    }

    private double CalculaMedia(ArrayList<Float> array, int pos){
        int i = array.size();
        txtResposta.setText(""+i);
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

        Log.d("---", "-------------------- ");
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
        parametros[0] = null;
        parametros[1] = null;
        parametros[2] = null;
        parametros[3] = null;
        parametros[4] = null;
        parametros[5] = null;
        parametros[6] = null;

    }

    private void ExecutarAudio(int nomeArquivo){

        if(flagAudio %10 == 0){
            mediaPlayer = MediaPlayer.create(ReconhecimentoActivity.this,nomeArquivo);
            if((mediaPlayer != null) && !(mediaPlayer.isPlaying())){
                mediaPlayer.start();
                flagAudio = 1;
            }
        }else{
            flagAudio++;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "PAUSE", Toast.LENGTH_SHORT).show();
        //Liberar os recusos utilizados pelo mediaPlayer ao fechar o aplicativo
        if ((mediaPlayer != null)) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        SM.unregisterListener(this, mySensor);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "DESTROY", Toast.LENGTH_SHORT).show();
    }
}
    