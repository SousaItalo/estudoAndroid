package sousaitalo.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private ImageView resultado;
    private ImageView botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        resultado = (ImageView) findViewById(R.id.resultadoId);
        botaoVoltar = (ImageView) findViewById(R.id.botaoVoltarId);

        //recuperando informação da MainActivity
        Bundle extra = getIntent().getExtras();
        if(!extra.isEmpty()){

            String opcao = extra.getString("opcao");

            //Setando imagem de acordo com opcao
            if(opcao.equals("cara")){
                //recuperando um drawable via codigo
                resultado.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            }else{
                resultado.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_coroa));
            }

        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetalheActivity.this, MainActivity.class));
            }
        });
    }
}
