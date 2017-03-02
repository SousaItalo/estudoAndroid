package sousaitalo.cursoandroid.com.todolist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText campoDeEntreda;
    private Button botaoSalvar;
    private ListView listaDeTarefas;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> tarefasId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Recuperar componentes de interface
            campoDeEntreda = (EditText) findViewById(R.id.campoDeEntradaId);
            botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);
            listaDeTarefas = (ListView) findViewById(R.id.listaDeTarefasId);

            //Banco de Dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);
            //tabela tarefas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            botaoSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    salvarTarefa(campoDeEntreda.getText().toString());
                    recuperarTarefas();
                }
            });
            recuperarTarefas();

            listaDeTarefas.setLongClickable(true);
            listaDeTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                    excluirTarefa(tarefasId.get(position));
                    return true;
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void salvarTarefa(String tarefa){
        try {
            if (!tarefa.equals("")) {
                //inserir no banco de dados
                bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + tarefa + "')");
                campoDeEntreda.setText("");
                Toast.makeText(MainActivity.this, "Tarefa salva", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Digite uma tarefa", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuperarTarefas(){
        ArrayList<String> tarefas = new ArrayList<>();
        tarefasId = new ArrayList<>();
        try {
            //percorrer tabela tarefas utilizando um cursor
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            //recuperar id das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");



            //Instanciar adaptador
            adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    tarefas
            );
            //setar adaptador na listView
            listaDeTarefas.setAdapter(adapter);

            //retornando cursos para o primeiro registro
            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Resultado - ", "Tarefa: " + cursor.getString(indiceColunaTarefa));
                tarefas.add(cursor.getString(indiceColunaTarefa));
                tarefasId.add(cursor.getString(indiceColunaId));
                cursor.moveToNext();
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluirTarefa(String id){
        try{
            bancoDados.execSQL("DELETE FROM tarefas WHERE id="+ id);
            recuperarTarefas();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
