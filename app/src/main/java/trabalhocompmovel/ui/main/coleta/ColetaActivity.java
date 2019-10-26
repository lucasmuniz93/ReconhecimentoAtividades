package trabalhocompmovel.ui.main.coleta;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import trabalhocompmovel.R;
import trabalhocompmovel.ui.base.BaseActivity;
import trabalhocompmovel.ui.main.MainMvpView;

import javax.inject.Inject;

/*
*   Melhorar o sistema de criar pastas e atualizar o numero do aluno.
*
 */

public class ColetaActivity extends BaseActivity implements SensorEventListener, MainMvpView {
    // Apenas para identificar os aparelhos que foram utilizados no treinamento
    private final int ID_APARELHO = 4;

    // ---------------- Interface -------------------
    // Imagens para marcar as atividades completas
    private ImageView imgAndandoLeve, imgAndandoModerado, imgAndandoVigoroso;
    private ImageView imgDeitadoLeve, imgDeitadoModerado, imgDeitadoVigoroso;
    private ImageView imgSentadoLeve, imgSentadoModerado, imgSentadoVigoroso;
    private TextView txtNome;
    private Button Gravar, Resetar, Andando, Deitado, Sentado, Leve, Moderado, Vigoroso;

    // --------------    Flags ---------------------
    private boolean flagGravar = false;
    private boolean flagLeve, flagModerado, flagVigoroso;
    private boolean flagAndando, flagDeitado, flagSentado;
    private boolean flagCriarPasta;
    private boolean flagGyro;
    private boolean flagStart;
    private int numeroRegistros = ID_APARELHO;

    // Sensores
    private Sensor mySensor;
    private SensorManager SM;

    //Arquivo
    private File file;
    private File dir;
    private FileOutputStream arquivoSaida;

    // Cronometro
    private long tempoStart;
    private long tempoEspera;
    private TextView Cronometro;

    // Audio
    private MediaPlayer mediaPlayer;

    @Inject
    ColetaPresenter<ColetaMvpView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleta);

        // Cast
        Andando = (Button) findViewById(R.id.btnAndando);
        Deitado = (Button) findViewById(R.id.btnDeitado);
        Sentado = (Button) findViewById(R.id.btnSetado);
        Leve = (Button) findViewById(R.id.btnLeve);
        Moderado = (Button) findViewById(R.id.btnModerado);
        Vigoroso = (Button) findViewById(R.id.btnVigoroso);
        Gravar = (Button) findViewById(R.id.btnGravar);
        Resetar = (Button) findViewById(R.id.btnResetar);

        txtNome = (TextView) findViewById(R.id.txtNome);


        imgAndandoLeve = (ImageView) findViewById(R.id.imgAndandoLeveColeta);
        imgAndandoModerado = (ImageView) findViewById(R.id.imgAndandoModeradoColeta);
        imgAndandoVigoroso = (ImageView) findViewById(R.id.imgAndandoVigorosoColeta);

        imgSentadoLeve = (ImageView) findViewById(R.id.imgSentadoLeveColeta);
        imgSentadoModerado = (ImageView) findViewById(R.id.imgSentadoModeradoColeta);
        imgSentadoVigoroso = (ImageView) findViewById(R.id.imgSentadoVigorosoColeta);

        imgDeitadoLeve = (ImageView) findViewById(R.id.imgDeitadoLeveColeta);
        imgDeitadoModerado = (ImageView) findViewById(R.id.imgDeitadoModeradoColeta);
        imgDeitadoVigoroso = (ImageView) findViewById(R.id.imgDeitadoVigorosoColeta);

        Cronometro = (TextView) findViewById(R.id.txtCronometro);

        ResetarCorBotaoAtividade();
        ResetarCorBotaoIntensidade();
        ResetarAtividadeFinalizada();
        flagCriarPasta = true;
        flagStart = true;
        txtNome.setText("Aluno "+numeroRegistros);


        // Criar o Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_FASTEST);

        // Verifico se o aparelho possui gyroscopio
        if(SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            flagGyro = true;
            mySensor = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
            SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_FASTEST);
        }

        if(SM.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) != null){
            mySensor= SM.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_FASTEST);
        }else{
            Toast.makeText(this, "ROTATION VECTOR NÃO ENCONTRADO", Toast.LENGTH_SHORT).show();
        }

        //OnClick
        Andando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se não estiver coletando os dados
                if(!flagGravar){
                    // Reseto todas as cores e as flags de atividades para os valores padrões false/LTGRAY
                    ResetarCorBotaoAtividade();
                    // Marco como CYAN o botao pressionado
                    Andando.setBackgroundColor(Color.CYAN);
                    // Ativo a flag do botao pressionado
                    flagAndando = true;

                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Deitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    ResetarCorBotaoAtividade();
                    Deitado.setBackgroundColor(Color.CYAN);
                    flagDeitado = true;
                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Sentado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    ResetarCorBotaoAtividade();
                    Sentado.setBackgroundColor(Color.CYAN);
                    flagSentado = true;
                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Leve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    ResetarCorBotaoIntensidade();
                    Leve.setBackgroundColor(Color.CYAN);
                    flagLeve = true;
                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Moderado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    ResetarCorBotaoIntensidade();
                    Moderado.setBackgroundColor(Color.CYAN);
                    flagModerado = true;
                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Vigoroso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    ResetarCorBotaoIntensidade();
                    Vigoroso.setBackgroundColor(Color.CYAN);
                    flagVigoroso = true;
                }else{
                    Toast.makeText(ColetaActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNome.setText("Aluno "+numeroRegistros);
                if(flagAndando || flagDeitado || flagSentado){
                    if(flagLeve || flagModerado || flagVigoroso ){
                        if(txtNome.getText().toString().equals("")){
                            Toast.makeText(ColetaActivity.this, "Nome não pode ficar em branco", Toast.LENGTH_SHORT).show();
                        }else{
                            flagGravar = !flagGravar;

                        }
                    }else {
                        Toast.makeText(ColetaActivity.this, "Selecione uma intensidade", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ColetaActivity.this, "Selecione uma atividade", Toast.LENGTH_SHORT).show();
                }

                if (flagGravar){
                    flagStart = true;
                    Gravar.setText("Gravando");
                    Gravar.setBackgroundColor(Color.GREEN);
                    tempoEspera = System.currentTimeMillis();
                }else{
                    Gravar.setText("Gravar");
                    Gravar.setBackgroundColor(Color.LTGRAY);
                }
            }
        });

        Resetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetarCorBotaoIntensidade();
                ResetarCorBotaoAtividade();
                ResetarParametroIntensidade();
                ResetarParamentroAtividade();
                ResetarAtividadeFinalizada();
                flagCriarPasta = true;
                txtNome.setText("Aluno "+numeroRegistros);
                flagGravar = false;
                Gravar.setText("Gravar");
                Gravar.setBackgroundColor(Color.LTGRAY);
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String x = "";
        String y = "";
        String z = "";

            if (flagGravar) {
                final String atividade = VerificaAtividade();
                final String intensidade = VerificaIntensidade();

                // Aguardo 5 segundos antes de começar gravar
                if(((System.currentTimeMillis()-tempoEspera)/1000)  >= 5) {
                    // Toca um beep ao começar gravar
                    if (flagStart) {
                        ExecutarAudio(R.raw.beep);
                        tempoStart = System.currentTimeMillis();
                        flagStart = false;
                    }
                    // Verifico o tipo de sensor que está sendo utilizado no momento e
                    // passo os dados para serem escritos no arquivos
                    if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                        x = " " + sensorEvent.values[0];
                        y = " " + sensorEvent.values[1];
                        z = " " + sensorEvent.values[2];
                        EscreverArquivo(atividade, intensidade, x, y, z, " a");
                    }
                    if (sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                        x = " " + sensorEvent.values[0];
                        y = " " + sensorEvent.values[1];
                        z = " " + sensorEvent.values[2];
                        EscreverArquivo(atividade, intensidade, x, y, z, " g");
                    }
                    if (sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                        String r = "";

                        x = " " + sensorEvent.values[0];
                        y = " " + sensorEvent.values[1];
                        z = " " + sensorEvent.values[2];
                        r = " " + sensorEvent.values[3];
                        EscreverArquivo(atividade, intensidade, x, y, z, " r");
                    }
                }
            }
    }

   @Override
   public void onAccuracyChanged(Sensor sensor, int i) {

    }

    // Funções para resetar o sistema para os valores padrões
   private void ResetarParamentroAtividade(){
        flagAndando = false;
        flagDeitado = false;
        flagSentado = false;
   }

   private void ResetarParametroIntensidade(){
        flagLeve = false;
        flagModerado = false;
        flagVigoroso = false;
   }

   private void ResetarCorBotaoAtividade(){
       ResetarParamentroAtividade();

       Andando.setBackgroundColor(Color.LTGRAY);
       Deitado.setBackgroundColor(Color.LTGRAY);
       Sentado.setBackgroundColor(Color.LTGRAY);
   }

   private void ResetarCorBotaoIntensidade(){
       ResetarParametroIntensidade();

       Leve.setBackgroundColor(Color.LTGRAY);
       Moderado.setBackgroundColor(Color.LTGRAY);
       Vigoroso.setBackgroundColor(Color.LTGRAY);
   }



   private String VerificaAtividade(){
     if(flagAndando){
         return "Andando";
     }else if(flagSentado){
         return "Sentado";
     }else if(flagDeitado){
         return "Deitaodo";
     }
     return null;
   }

    private String VerificaIntensidade(){
        if(flagLeve){
            return "Leve";
        }else if(flagModerado){
            return "Moderado";
        }else if(flagVigoroso){
            return "Vigoroso";
        }

        return null;
    }
    // Função que é chamada quando o tempo passar dos 60 seg, para marcar a atividade coletada como finalizada
   private void MarcaAtividadeFinalizada(boolean flagAndando, boolean flagDeitado, boolean flagSentado,
                                         boolean flagLeve, boolean flagModerado, boolean flagVigoroso){

       ExecutarAudio(R.raw.beep);

       if(flagAndando){
           if(flagLeve){
               imgAndandoLeve.setImageResource(R.drawable.atividadecompleta);
           }else if(flagModerado){
               imgAndandoModerado.setImageResource(R.drawable.atividadecompleta);
           }else if(flagVigoroso){
               imgAndandoVigoroso.setImageResource(R.drawable.atividadecompleta);
           }
       }else if(flagSentado){
           if(flagLeve){
               imgSentadoLeve.setImageResource(R.drawable.atividadecompleta);
           }else if(flagModerado){
               imgSentadoModerado.setImageResource(R.drawable.atividadecompleta);
           }else if(flagVigoroso){
               imgSentadoVigoroso.setImageResource(R.drawable.atividadecompleta);
           }
       } else if(flagDeitado){
            if(flagLeve){
                imgDeitadoLeve.setImageResource(R.drawable.atividadecompleta);
            }else if(flagModerado){
                imgDeitadoModerado.setImageResource(R.drawable.atividadecompleta);
            }else if(flagVigoroso){
                imgDeitadoVigoroso.setImageResource(R.drawable.atividadecompleta);
            }
        }

       ExecutarAudio(R.raw.beep);
   }

   // Funçao para dar play no audio passado como parametro
    private void ExecutarAudio(int nomeArquivo){

            mediaPlayer = MediaPlayer.create(ColetaActivity.this,nomeArquivo);
            if((mediaPlayer != null) && !(mediaPlayer.isPlaying())){
                mediaPlayer.start();
            }

    }

    private  void  ResetarAtividadeFinalizada(){

        imgAndandoLeve.setImageResource(R.drawable.atividadenaocompleta);
        imgAndandoModerado.setImageResource(R.drawable.atividadenaocompleta);
        imgAndandoVigoroso.setImageResource(R.drawable.atividadenaocompleta);

        imgSentadoLeve.setImageResource(R.drawable.atividadenaocompleta);
        imgSentadoModerado.setImageResource(R.drawable.atividadenaocompleta);
        imgSentadoVigoroso.setImageResource(R.drawable.atividadenaocompleta);

        imgDeitadoLeve.setImageResource(R.drawable.atividadenaocompleta);
        imgDeitadoModerado.setImageResource(R.drawable.atividadenaocompleta);
        imgDeitadoVigoroso.setImageResource(R.drawable.atividadenaocompleta);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SM.unregisterListener(this, mySensor);

    }

    // Funçao que faz a escrita dos dados no arquivo txt
    private void EscreverArquivo(String atividade, String intensidade, String x, String y, String z, String sensor){
        Calendar c =  Calendar.getInstance();
        String nomePasta;

        // Se o tempo passar de 60 segundos é feito um reset nos parametros e finalizada a gravação
        if(((System.currentTimeMillis()-tempoStart)/1000) >= 60){
            flagGravar = false;
            Gravar.setText("Gravar");
            Gravar.setBackgroundColor(Color.LTGRAY);
            MarcaAtividadeFinalizada(flagAndando,flagDeitado,flagSentado,flagLeve,flagModerado,flagVigoroso);
        }

        //Crio o diretorio para salvar o arquivo
        try{
            // Se nesta gravação ainda não tiver criado a pasta, para evidar criar
            // centenas de pastas durante a mesma gravação.
            // É resetada com o botão limpar
            if(flagCriarPasta){
                nomePasta = "//CompMovel//Aluno"+ID_APARELHO;
                dir = new File(Environment.getExternalStorageDirectory()+nomePasta);

                flagCriarPasta = false;

                // Se não existir uma pasta com o nome Aluno x, então ela é criada
                if(!dir.exists()){
                    dir.mkdirs();
                    txtNome.setText("Aluno "+numeroRegistros);
                }else{
                    // Caso existir vai incrimentando i até encontrar um nome válido
                    int i = ID_APARELHO;
                    do{
                        nomePasta = "//CompMovel//Aluno"+i;
                        dir = new File(Environment.getExternalStorageDirectory()+nomePasta);
                        i += 4;
                    }while (!dir.mkdirs());
                    numeroRegistros = i;
                    dir.mkdirs();
                    txtNome.setText("Aluno "+numeroRegistros);
                }

            }

            file = new File(dir,atividade+intensidade+".txt");
            // True escreve no final do arquivo, false cria um novo
            // Como a função é chamada toda hora no OnSensorChanged() tive que usar True
            // se não só salvaria o último dado
            arquivoSaida =  new FileOutputStream(file,true);
            String cronometro;
            file.createNewFile();
            Cronometro.setText((System.currentTimeMillis()-tempoStart)/1000+" de 60");
            cronometro = " "+(System.currentTimeMillis()-tempoStart);
            // Parte que escrevo de fato no arquivo
            arquivoSaida.write(x.getBytes());
            arquivoSaida.write(y.getBytes());
            arquivoSaida.write(z.getBytes());
            arquivoSaida.write(cronometro.getBytes());
            arquivoSaida.write(sensor.getBytes());
            arquivoSaida.write("\n".getBytes());
            arquivoSaida.close();

        }catch (IOException e) {
            Log.i("Erro Arquivo", "Erro IO");
            e.printStackTrace();
        }

    }

}
