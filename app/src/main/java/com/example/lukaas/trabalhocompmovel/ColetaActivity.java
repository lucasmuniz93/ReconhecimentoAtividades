package com.example.lukaas.trabalhocompmovel;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ColetaActivity extends AppCompatActivity implements SensorEventListener{
    // Botões
    private Button Gravar, Andando, Deitado, Sentado, Leve, Moderado, Vigoroso;
    // TextViews
    private EditText txtNome;
    //Imagens
    private ImageView imgAndandoLeve, imgAndandoModerado, imgAndandoVigoroso;
    private ImageView imgDeitadoLeve, imgDeitadoModerado, imgDeitadoVigoroso;
    private ImageView imgSentadoLeve, imgSentadoModerado, imgSentadoVigoroso;

    //Flags
    private boolean flagGravar = false;
    private boolean flagLeve, flagModerado, flagVigoroso;
    private boolean flagAndando, flagDeitado, flagSentado;
    private boolean flagCriarPasta;

    // Sensores
    private Sensor mySensor;
    private SensorManager SM;

    //Arquivo
    private File file;
    private FileOutputStream arquivoSaida;

    // Cronometro
    private long tempoStart;
    private TextView Cronometro;

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

        txtNome = (EditText) findViewById(R.id.txtNome);

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

        // Criar o Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

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
                    Gravar.setText("Gravando");
                    Gravar.setBackgroundColor(Color.GREEN);
                    tempoStart = System.currentTimeMillis();
                    flagCriarPasta = true;
                }else{
                    Gravar.setText("Gravar");
                    Gravar.setBackgroundColor(Color.LTGRAY);
                    flagCriarPasta = false;
                }
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        final String x = " "+sensorEvent.values[0];
        final String y = " "+sensorEvent.values[1];
        final String z = " "+sensorEvent.values[2];

        final String atividade= VerificaAtividade();
        final String intensidade= VerificaIntensidade();

        //Salvar no Arquivo
          if(flagGravar){
              EscreverArquivo(atividade,intensidade,x, y, z);
          }


    }

   @Override
   public void onAccuracyChanged(Sensor sensor, int i) {

    }

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
   private void MarcaAtividadeFinalizada(){

   }

    @Override
    protected void onPause() {
        super.onPause();

        SM.unregisterListener(this, mySensor);

    }
   private void EscreverArquivo(String atividade, String intensidade, String x, String y, String z){
       Calendar c =  Calendar.getInstance();
       String nomePasta;

       if(((System.currentTimeMillis()-tempoStart)/1000) >= 60){
           flagGravar = false;
           Gravar.setText("Gravar");
           Gravar.setBackgroundColor(Color.LTGRAY);
       }
       //Crio o diretorio para salvar o arquivo
       try{
           nomePasta = "//"+txtNome.getText().toString();

           File dir = new File(Environment.getExternalStorageDirectory().getPath()+nomePasta);
           /*
           *    CONSERTAR BUG DE CRIAR PASTAS INFITNITAS!
           * */
           if(!dir.exists() && flagCriarPasta && flagGravar){
              // dir.mkdirs();
               flagCriarPasta = false;
               Toast.makeText(this, "ENTROU IF", Toast.LENGTH_SHORT).show();
           }else{
               int i =0;
               if(flagCriarPasta && flagGravar){
                   do{
                       nomePasta = "//CompMovel//"+txtNome.getText().toString()+i;
                       dir = new File(Environment.getExternalStorageDirectory().getPath()+nomePasta);
                       i++;
                   }while ( dir.mkdirs());

                //   dir.mkdirs();
                   flagCriarPasta = false;
                   Toast.makeText(this, "ENTROU ELSE", Toast.LENGTH_SHORT).show();
               }

           }

           file = new File(dir,atividade+intensidade+".txt");
           //True escreve no final do arquivo, false cria um novo
           arquivoSaida =  new FileOutputStream(file,true);
           String cronometro;
           file.createNewFile();
           Cronometro.setText((System.currentTimeMillis()-tempoStart)/1000+" de 60");
           cronometro = " "+(System.currentTimeMillis()-tempoStart);
           arquivoSaida.write(x.getBytes());
           arquivoSaida.write(y.getBytes());
           arquivoSaida.write(z.getBytes());
           arquivoSaida.write(cronometro.getBytes());
           arquivoSaida.write("\n".getBytes());
           arquivoSaida.close();

       }catch (IOException e) {
           Log.i("Erro Arquivo", "Erro IO");
           e.printStackTrace();
       }

   }
}
