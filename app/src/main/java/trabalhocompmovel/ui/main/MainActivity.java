package trabalhocompmovel.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import trabalhocompmovel.R;

import trabalhocompmovel.ui.base.BaseActivity;
import trabalhocompmovel.ui.main.coleta.ColetaActivity;
import trabalhocompmovel.ui.main.reconhecimentoActivity.ReconhecimentoActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    private Button btnColetarDados;
    private Button btnAnalisarAtividade;

    @Inject
    MainPresenter <MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        btnAnalisarAtividade = (Button) findViewById(R.id.btnAnalisarAtividade);
        btnColetarDados = (Button) findViewById(R.id.btnColetarDados);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnAnalisarAtividade)
    public void checkActivity(){
        swipeActivity(new Intent(MainActivity.this, ReconhecimentoActivity.class));
    }
    @OnClick(R.id.btnColetarDados)
    public void getInputData(){
        swipeActivity(new Intent(MainActivity.this, ColetaActivity.class));
    }

    public void swipeActivity(Intent intent){
        startActivity(intent);
    }
}
