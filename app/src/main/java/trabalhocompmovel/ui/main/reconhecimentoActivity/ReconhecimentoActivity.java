package trabalhocompmovel.ui.main.reconhecimentoActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import trabalhocompmovel.R;

import trabalhocompmovel.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static trabalhocompmovel.utils.AppConstants.FRAME_TIME;


public class ReconhecimentoActivity extends BaseActivity implements ReconhecimentoMvpView, SensorEventListener{

    private long startTime = 0;

    // Layout
    @BindView(R.id.txtAtividade2)
    TextView atividade;

    @BindView(R.id.imgAtividade)
    ImageView imgAtividade;

    @BindView(R.id.switch2)
    Switch switchSom;

    private MediaPlayer mediaPlayer;
    private int flagAudio = 10;

    // Sensores
    private Sensor mySensor;
    private SensorManager SM;

    @Inject
    ReconhecimentoMvpPresenter <ReconhecimentoMvpView> mPresenter;

    private static double respostaIntensidade = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconhecimento);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        // Criar o Sensor Manager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        startTime = System.currentTimeMillis();

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

         //mPresenter.sensorChanged(sensorEvent, VerificaJanela());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private boolean VerificaJanela(){
        double t =(double) ((System.currentTimeMillis() - startTime)/1000);

        if(t >= FRAME_TIME ){
            startTime = System.currentTimeMillis();
            return true;
        }
        return false;
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
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Liberar os recusos utilizados pelo mediaPlayer ao fechar o aplicativo
        if ((mediaPlayer != null)) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        SM.unregisterListener(this, mySensor);

    }

    public void onError(Exception e){
        Toast.makeText(this, ""+ e, Toast.LENGTH_SHORT).show();
    }

    public void setAndandoLeve() {
        atividade.setText(getResources().getString(R.string.walk0));
        imgAtividade.setImageResource(R.drawable.andandoleve);
        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.andandoleve);
        }
    }


    public void setAndandoModerado() {
        atividade.setText(getResources().getString(R.string.walk1));
        imgAtividade.setImageResource(R.drawable.andandomoderado);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.andandomoderado);
        }
    }

    public void setCorrendo() {
        atividade.setText(getResources().getString(R.string.walk2));
        imgAtividade.setImageResource(R.drawable.andandovigoroso);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.andandovigoroso);
        }
    }

    public void setSentadoLeve() {
        atividade.setText(getResources().getString(R.string.sit0));
        imgAtividade.setImageResource(R.drawable.sentadoleve);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.sentadoleve);
        }
    }

    public void setSentadoModerado() {
        atividade.setText(getResources().getString(R.string.sit1));
        imgAtividade.setImageResource(R.drawable.sentadomoderado);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.sentadomoderado);
        }
    }

    public void setSentadoMovimentando() {
        atividade.setText(getResources().getString(R.string.sit2));
        imgAtividade.setImageResource(R.drawable.sentadovigoroso);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.sentadovigoroso);
        }
    }
    public void setDeitadoLeve() {
        atividade.setText(getResources().getString(R.string.lyingDonw0));
        imgAtividade.setImageResource(R.drawable.deitadoleve);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.deitadoleve);
        }
    }

    public void setDeitadoModerado() {
        atividade.setText(getResources().getString(R.string.lyingDonw1));
        imgAtividade.setImageResource(R.drawable.deitadoleve);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.deitadomoderado);
        }
    }

    public void setDeitadoMovimentando() {
        atividade.setText(getResources().getString(R.string.lyingDonw2));
        imgAtividade.setImageResource(R.drawable.deitadoleve);

        if(switchSom.isChecked()){
            ExecutarAudio(R.raw.deitadovigoroso);
        }
    }
}
    