package sousaitalo.cursoandroid.com.basicsharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textNome;
    private Button botao;
    private TextView textoExibicao;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNome = (EditText) findViewById(R.id.textoNomeId);
        botao = (Button) findViewById(R.id.botaoSalvarId);
        textoExibicao = (TextView) findViewById(R.id.textoExibicaoId);

        //Salvar dados
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(!textNome.getText().toString().equals("")) {
                    editor.putString("nome", textNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Olá, " + textNome.getText().toString());
                } else{
                    Toast.makeText(MainActivity.this, "Digite Algo", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Recuperar dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("nome")) {
            String nome = sharedPreferences.getString("nome", "Usuário não definido");
            textoExibicao.setText("Olá, " + nome);
        }else {
            textoExibicao.setText("Olá, usuário");
        }

    }
}
