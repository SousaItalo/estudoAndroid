package sousaitalo.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView botaoJogar;
    private String[] opcao = {"cara", "coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (ImageView) findViewById(R.id.botaoJogarId);

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Gerando numero aleatorio
                Random random = new Random();

                //gera um numero aleatório no intervalo entre 0 e 1;
                int randomNumber = random.nextInt(2);

                //colocando opcao gerada dentro da intent
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
                intent.putExtra("opcao", opcao[randomNumber]);

                //Transicao entre activities
                startActivity(intent);
            }
        });
    }
}
