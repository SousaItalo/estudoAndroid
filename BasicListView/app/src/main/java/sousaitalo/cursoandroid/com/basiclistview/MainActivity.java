package sousaitalo.cursoandroid.com.basiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private String[] itens = {
            "Angra dos Reis", "Caldas novas",
            "Campos do jordão", "Costa do Sauipe",
            "Ilhéus", "Porto Seguro", "Rio de Janeiro",
            "Fortaleza", "Caribe", "Budapest", "Aruba"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listViewId);

        //Responsavel por "adaptar o array de string para ListView
        //Atenção para o construtor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(//Contexto, layout, textView, itens)
                //Contexto
                getApplicationContext(),
                //Layout usado no adaptador
                android.R.layout.simple_list_item_1,
                //Id do TextView dentro do layout definido acima
                android.R.id.text1,
                //Lista de itens
                itens
        );
        //setando adaptador para o ListView na activity
        lista.setAdapter(adapter);

        //click por item na lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //int i no construtor acima guarda o valor da posição clicada pelo usuário na listView
                String valorClicado = (String) lista.getItemAtPosition(i);

                //usando toast para exibir a opcao clicada na forma de uma notificacao
                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
