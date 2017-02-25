package sousaitalo.cursoandroid.com.basicseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemExibicao;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemExibicao = (ImageView) findViewById(R.id.imagemExibicaoId);
        seekBar = (SeekBar) findViewById(R.id.seekBarId);

        //monitora mudanças na seekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //int i recebe o valor do progresso na seekBar
                switch (i){
                    case 1:
                        imagemExibicao.setImageResource(R.drawable.medio);
                        break;
                    case 2:
                        imagemExibicao.setImageResource(R.drawable.muito);
                        break;
                    case 3:
                        imagemExibicao.setImageResource(R.drawable.susto);
                        break;
                    default:
                        imagemExibicao.setImageResource(R.drawable.pouco);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "OnStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "OnStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
