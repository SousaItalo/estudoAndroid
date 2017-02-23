package sousaitalo.cursoandroid.com.basicdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.botaoId);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instanciando dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                //Configurando Titulo
                dialog.setTitle("Título da Dialog");

                //Configurando Icone
                dialog.setIcon(android.R.drawable.ic_delete);

                //Configurando Mensagem
                dialog.setMessage("Mensagem da dialog");

                //impedindo o usuário de fechar a diolog ao clicar fora dela
                dialog.setCancelable(false);

                //Configurando botões
                //Cada botao recebe dois atribuos onde o primeiro é a mensagem e o segundo a ação

                //Botao Negativo
                dialog.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Botao negativo", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Botao positivo", Toast.LENGTH_SHORT).show();
                            }
                        });
                //criando dialog
                dialog.create();

                //exibindo dialog
                dialog.show();
            }
        });

    }
}
