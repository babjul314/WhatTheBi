package org.shinhan.whatthebi;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class alamColdActivity extends AppCompatActivity {

    Button button;
    int sound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alam_cold);
        SoundPool pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound1 = pool.load(this, R.raw.cold, 1);
        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {

            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {

                soundPool.play(sound1, 1.0f, 1.0f, 0, 0, 1f);
            }
        });

        button=(Button)findViewById(R.id.button_activity_alam_cold);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

    }

}
