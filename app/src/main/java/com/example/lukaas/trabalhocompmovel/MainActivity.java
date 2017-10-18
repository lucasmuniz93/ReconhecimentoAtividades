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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    // Botões
    private Button Gravar, Parado, Andando, Correndo, Deitado, Sentado, Leve, Moderado, Vigoroso;
    // TextViews
    private TextView Atividade, Intensidade, ValorX, ValorY, ValorZ;
    //Flags
    private boolean flagGravar = false;
    private boolean flagLeve, flagModerado, flagVigoroso;
    private boolean flagParado, flagAndando, flagDeitado, flagSentado, flagCorrendo;

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
        setContentView(R.layout.activity_main);

        // Cast Botões
        Parado = (Button) findViewById(R.id.btnParado);
        Andando = (Button) findViewById(R.id.btnAndando);
        Correndo = (Button) findViewById(R.id.btnCorrendo);
        Deitado = (Button) findViewById(R.id.btnDeitado);
        Sentado = (Button) findViewById(R.id.btnSetado);
        Leve = (Button) findViewById(R.id.btnLeve);
        Moderado = (Button) findViewById(R.id.btnModerado);
        Vigoroso = (Button) findViewById(R.id.btnVigoroso);
        Gravar = (Button) findViewById(R.id.btnGravar);
        //Cast TextViews
        Atividade = (TextView) findViewById(R.id.txtAtividade2);
        Intensidade = (TextView) findViewById(R.id.txtIntensidade);
        ValorX = (TextView) findViewById(R.id.txtX);
        ValorY = (TextView) findViewById(R.id.txtY);
        ValorZ = (TextView) findViewById(R.id.txtZ);
        Cronometro = (TextView) findViewById(R.id.txtCronometro);

        //Resetar os paramentros para false
        ResetarParamentroAtividade();
        ResetarParametroIntensidade();




        // Criar o Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        //OnClick
        Parado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Atividade.setText("Parado");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Andando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Atividade.setText("Andando");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Correndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Atividade.setText("Correndo");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Deitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Atividade.setText("Deitado");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Sentado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Atividade.setText("Sentado");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Leve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Intensidade.setText("Leve");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Moderado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Intensidade.setText("Moderado");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Vigoroso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flagGravar){
                    Intensidade.setText("Vigoroso");
                }else{
                    Toast.makeText(MainActivity.this, "Pause a gravação para mudar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Atividade.getText().equals("Atividade") && !Intensidade.getText().equals("Intensidade")){
                    flagGravar = !flagGravar;
                }else{
                    Toast.makeText(MainActivity.this, "Selecione uma atividade e intensidade", Toast.LENGTH_SHORT).show();
                }
                if (flagGravar){
                    Gravar.setText("Gravando");
                    Gravar.setBackgroundColor(Color.GREEN);
                    tempoStart = System.currentTimeMillis();
                }else{
                    Gravar.setText("Gravar");
                    Gravar.setBackgroundColor(Color.LTGRAY);
                }
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        ValorX.setText(""+sensorEvent.values[0]);
        ValorY.setText(""+sensorEvent.values[1]);
        ValorZ.setText(""+sensorEvent.values[2]);

        final String x = " "+sensorEvent.values[0];
        final String y = " "+sensorEvent.values[1];
        final String z = " "+sensorEvent.values[2];
        final String atividade = Atividade.getText().toString();
        final String intensidade = " "+ Intensidade.getText().toString();

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
        flagParado = false;
        flagSentado = false;
        flagCorrendo = false;
   }

   private void ResetarParametroIntensidade(){
        flagLeve = false;
        flagModerado = false;
        flagVigoroso = false;
   }

   private void EscreverArquivo(String atividade, String intensidade, String x, String y, String z){
        Calendar c =  Calendar.getInstance();
    if(((System.currentTimeMillis()-tempoStart)/1000) >= 60){
        flagGravar = false;
        Gravar.setText("Gravar");
        Gravar.setBackgroundColor(Color.LTGRAY);
    }
        //Crio o diretorio para salvar o arquivo
        try{
            File dir = new File(Environment.getExternalStorageDirectory().getPath()+"//CompMovel");
            if(!dir.exists())
                dir.mkdirs();

            file = new File(dir,atividade+intensidade+".txt");
            //True escreve no final do arquivo, false cria um novo
            arquivoSaida =  new FileOutputStream(file,true);
            String cronometro;
            file.createNewFile();
            Cronometro.setText(((System.currentTimeMillis()-tempoStart)/1000)+"."+ (System.currentTimeMillis()-tempoStart));
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
