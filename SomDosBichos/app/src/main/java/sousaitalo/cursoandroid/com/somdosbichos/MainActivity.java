package sousaitalo.cursoandroid.com.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer;

    private ImageView botaoCao;
    private ImageView botaoGato;
    private ImageView botaoLeao;
    private ImageView botaoMacaco;
    private ImageView botaoOvelha;
    private ImageView botaoVaca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoCao = (ImageView) findViewById(R.id.botaoCaoId);
        botaoGato = (ImageView) findViewById(R.id.botaoGatoId);
        botaoLeao = (ImageView) findViewById(R.id.botaoLeaoId);
        botaoMacaco = (ImageView) findViewById(R.id.botaoMacacoId);
        botaoOvelha = (ImageView) findViewById(R.id.botaoOvelhaId);
        botaoVaca = (ImageView) findViewById(R.id.botaoVacaId);

        botaoCao.setOnClickListener(this);
        botaoGato.setOnClickListener(this);
        botaoOvelha.setOnClickListener(this);
        botaoLeao.setOnClickListener(this);
        botaoMacaco.setOnClickListener(this);
        botaoVaca.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botaoCaoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                play();
                break;
            case R.id.botaoGatoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                play();
                break;
            case R.id.botaoLeaoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                play();
                break;
            case R.id.botaoMacacoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                play();
                break;
            case R.id.botaoOvelhaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                play();
                break;
            case R.id.botaoVacaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                play();
                break;
            default:
                break;
        }
    }

    private void play() {
        if(!mediaPlayer.equals(null)) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if(!mediaPlayer.equals(null)){
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
