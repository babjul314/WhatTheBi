package org.shinhan.whatthebi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class EndActivity extends AppCompatActivity {
   Button button_fisnish;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_end);
        button_fisnish= (Button)findViewById(R.id.button_end_fisnish);
        button_fisnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }
}
