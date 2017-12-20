package com.example.lukaas.trabalhocompmovel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnColetarDados;
    private Button btnAnalisarAtividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_principal);

        btnAnalisarAtividade = (Button) findViewById(R.id.btnAnalisarAtividade);
        btnColetarDados = (Button) findViewById(R.id.btnColetarDados);

        // OnClick Chama a Reconhecimento
        btnAnalisarAtividade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ReconhecimentoActivity.class));
            }
        });
        // OnClick Chama a Coleta
        btnColetarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ColetaActivity.class));
            }
        });

    }
}
