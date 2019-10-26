package trabalhocompmovel.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        // OnClick Chama a Reconhecimento
        btnAnalisarAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ReconhecimentoActivity.class));
            }
        });
        // OnClick Chama a Coleta
        btnColetarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ColetaActivity.class));
            }
        });

    }
}
