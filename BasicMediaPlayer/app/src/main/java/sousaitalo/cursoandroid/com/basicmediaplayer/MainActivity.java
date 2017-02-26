package sousaitalo.cursoandroid.com.basicmediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.botaoTocarId);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checa se o media pĺayer foi instanciado corretamente
                if(!mediaPlayer.equals(null)) {
                    //checa se o media player está tocando
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        botaoTocar.setText("Tocar");
                    } else {
                        mediaPlayer.start();
                        botaoTocar.setText("Pausar");
                    }
                }
            }
        });
    }
}
