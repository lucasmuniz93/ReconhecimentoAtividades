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

import butterknife.ButterKnife;

import static trabalhocompmovel.utils.AppConstants.FRAME_TIME;


public class ReconhecimentoActivity extends BaseActivity implements ReconhecimentoMvpView, SensorEventListener{

    private long startTime = 0;

    // Layout
    TextView atividade;
    ImageView imgAtividade;
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

        this.atividade = findViewById(R.id.txtAtividade2);
        this.imgAtividade = findViewById(R.id.imgAtividade);
        this.switchSom = findViewById(R.id.switch2);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        this.mPresenter.onAttach(this);

        // Criar o Sensor Manager
        this.SM = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Acelerometro Sensor
        this.mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Registrar o listener
        this.SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        this.startTime = System.currentTimeMillis();

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
         mPresenter.sensorChanged(sensorEvent, checkTime());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private boolean checkTime(){
        double time =(double) ((System.currentTimeMillis() - startTime)/1000);

        if(time >= FRAME_TIME ){
            this.startTime = System.currentTimeMillis();
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

    @Override
    public void onError(Exception e){
        Toast.makeText(this, ""+ e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAndandoLeve() {
        setActivity(getResources().getString(R.string.walk0), R.drawable.andandoleve, R.raw.andandoleve);
    }

    @Override
    public void setAndandoModerado() {
        setActivity(getResources().getString(R.string.walk1), R.drawable.andandomoderado, R.raw.andandomoderado);
    }

    @Override
    public void setCorrendo() {
        setActivity(getResources().getString(R.string.walk2), R.drawable.andandovigoroso, R.raw.andandovigoroso);
    }

    @Override
    public void setSentadoLeve() {
        setActivity(getResources().getString(R.string.sit0), R.drawable.sentadoleve, R.raw.sentadoleve);
    }

    @Override
    public void setSentadoModerado() {
        setActivity(getResources().getString(R.string.sit1), R.drawable.sentadomoderado, R.raw.sentadomoderado);
    }

    @Override
    public void setSentadoMovimentando() {
        setActivity(getResources().getString(R.string.sit2), R.drawable.sentadovigoroso, R.raw.sentadovigoroso);
    }

    @Override
    public void setDeitadoLeve() {
        setActivity(getResources().getString(R.string.lyingDonw0), R.drawable.deitadoleve, R.raw.deitadoleve);
    }

    @Override
    public void setDeitadoModerado() {
        setActivity(getResources().getString(R.string.lyingDonw1), R.drawable.deitadomoderado, R.raw.deitadomoderado);
    }

    @Override
    public void setDeitadoMovimentando() {
        setActivity(getResources().getString(R.string.lyingDonw2), R.drawable.deitadovigoroso, R.raw.deitadovigoroso);
    }

    private void setActivity(String activityName, int activityImagge, int activitySound) {
        atividade.setText(activityName);
        imgAtividade.setImageResource(activityImagge);

        if(playSound()){
            ExecutarAudio(activitySound);
        }
    }

    private boolean playSound() {
        return switchSom.isChecked();
    }

}
    