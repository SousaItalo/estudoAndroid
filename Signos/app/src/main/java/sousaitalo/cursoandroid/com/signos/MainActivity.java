package sousaitalo.cursoandroid.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaDeSignos;
    private String[] signos = {
            "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
            "Libra", "Escorpião", "Sargitário", "Capricórnio", "Aquário",
            "Peixes"
    };

    private String[] perfis = {
            "Árianos são animados", "Taurinos são positivos", "Geminianos são mutáveis",
            "Cânceriános blablabla", "Leoninos blablabla", "Virginianos blablabla",
            "Librianos blablabla", "Escorpianos blablabla", "Sargitarianos blablabla",
            "Capricornianos blabalbla", "Aquarianos blablabla",
            "Piscianos lbalbalablabl"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeSignos = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos
        );

        listaDeSignos.setAdapter(adapter);

        listaDeSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), perfis[i], Toast.LENGTH_SHORT).show();cd
            }
        });
    }
}
