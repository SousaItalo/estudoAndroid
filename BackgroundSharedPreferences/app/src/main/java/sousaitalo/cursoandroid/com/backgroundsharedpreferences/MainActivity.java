package sousaitalo.cursoandroid.com.backgroundsharedpreferences;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RelativeLayout layout;

    private static final String ARQUIVO_PREFERENCIAS = "ArquivoPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoId);
        radioGroup = (RadioGroup) findViewById(R.id.radioCoresId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radioGroup.getCheckedRadioButtonId();

                if(id > 0){
                    radioButton = (RadioButton) findViewById(id);
                    String corEscolhida = radioButton.getText().toString();

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        if(sharedPreferences.contains("corEscolhida")){
            String corEscolhida = sharedPreferences.getString("corEscolhida","Branco");
            setBackground(corEscolhida);
        }
    }

    private void setBackground(String cor){
        switch (cor){
            case "Amarelo":
                layout.setBackgroundColor(Color.parseColor("#FFD700"));
                break;
            case "Azul":
                layout.setBackgroundColor(Color.parseColor("#00008B"));
                break;
            case "Verde":
                layout.setBackgroundColor(Color.parseColor("#006400"));
                break;
            default:
                layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }
}
