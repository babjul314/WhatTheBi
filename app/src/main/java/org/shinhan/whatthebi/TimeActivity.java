package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class TimeActivity extends AppCompatActivity {
    String time;
    EditText editText_time;
    Button button_submit;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        intent=getIntent();

        setView();

    }
    public void setView(){

        editText_time=(EditText)findViewById(R.id.editText_time_time);
        button_submit= (Button)findViewById(R.id.button_activitytime_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time =editText_time.getText().toString();
                intent.setClass(getApplicationContext(),SendWayActivity.class);
                intent.putExtra("time",time);
                startActivity(intent);
            }
        });

    }
}
