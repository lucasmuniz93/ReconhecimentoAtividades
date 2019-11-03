package trabalhocompmovel.ui.main.reconhecimentoActivity;

import trabalhocompmovel.ui.base.MvpView;

public interface ReconhecimentoMvpView extends MvpView {

    void setAndandoLeve();

    void setAndandoModerado();

    void setCorrendo();

    void setSentadoLeve();

    void setSentadoModerado();

    void setSentadoMovimentando();

    void setDeitadoLeve() ;

    void setDeitadoModerado();

    void setDeitadoMovimentando();

    void onError(Exception e);

}
