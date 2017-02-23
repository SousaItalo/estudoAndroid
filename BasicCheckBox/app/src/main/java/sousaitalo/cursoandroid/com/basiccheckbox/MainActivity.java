package sousaitalo.cursoandroid.com.basiccheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private TextView resultado;

    private CheckBox checkBoxGato;
    private CheckBox checkBoxCachorro;
    private CheckBox checkBoxPapagaio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoId);
        resultado = (TextView) findViewById(R.id.resultadoId);

        checkBoxCachorro = (CheckBox) findViewById(R.id.checkBoxCachorroId);
        checkBoxGato = (CheckBox) findViewById(R.id.checkBoxGatoId);
        checkBoxPapagaio = (CheckBox) findViewById(R.id.checkBoxPapagaioId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String opcoesMarcadas = "";

                //Checa se a checkBox está marcada
                if(checkBoxGato.isChecked()){
                    //recupera o texto da checkBox
                    opcoesMarcadas += checkBoxGato.getText() + "\n";
                }
                if(checkBoxCachorro.isChecked()){
                    opcoesMarcadas += checkBoxCachorro.getText() + "\n";
                }
                if(checkBoxPapagaio.isChecked()){
                    opcoesMarcadas += checkBoxPapagaio.getText() + "\n";
                }

                if(!opcoesMarcadas.equals("")) {
                    resultado.setText(opcoesMarcadas);
                }else{
                    resultado.setText("Marque alguma opção\n");
                }
            }
        });
    }
}
