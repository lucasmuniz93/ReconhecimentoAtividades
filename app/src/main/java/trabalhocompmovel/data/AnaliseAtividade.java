package trabalhocompmovel.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import trabalhocompmovel.R;


public class AnaliseAtividade extends AppCompatActivity {
    private int[] TempoAtividade = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise_ativiade);
    }

    public void SetAtividade(int pos){
        TempoAtividade[pos]++;
    }

    public int[] GetAtividade(){
        return TempoAtividade;
    }
}
