package trabalhocompmovel.ui.main.reconhecimentoActivity;

import android.hardware.SensorEvent;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import trabalhocompmovel.ui.base.MvpPresenter;

public interface ReconhecimentoMvpPresenter <V extends ReconhecimentoMvpView> extends MvpPresenter<V> {

    void sensorChanged(SensorEvent sensorEvent, boolean verificaJanela);
}