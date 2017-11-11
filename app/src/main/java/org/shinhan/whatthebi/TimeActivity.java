package org.shinhan.whatthebi;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class TimeActivity extends AppCompatActivity {
    String time;
    int setUphour;
    int setUpminute;
    public String hour;
    public String minute;
    EditText editText_time;
    Button button_submit;
    Intent intent;
    TimePickerDialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        editText_time = (EditText) findViewById(R.id.editText_time_time);
        editText_time.setFocusable(false);
        intent = getIntent();
        setView();

        dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour1, int minute2) {
                setUphour=hour1;
                hour=String.valueOf(hour1);
                setUpminute=minute2;
                minute=String.valueOf(minute2);
                if(hour1>=12)
                {
                    editText_time.setText("오후"+(hour1-12)+"시 "+minute2 +"분");
                }else{
                    editText_time.setText("오전"+hour1+"시 "+minute2 +"분");
                }

            }
        }, 6, 24, false);



    }

    public void setView() {

        editText_time = (EditText) findViewById(R.id.editText_time_time);
        editText_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        button_submit= (Button)findViewById(R.id.button_activitytime_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time =hour+""+minute;
                intent.setClass(getApplicationContext(),CompleteActivity.class);
                intent.putExtra("time",time);
                intent.putExtra("setUphour",setUphour);
                intent.putExtra("setUpminute",setUpminute);
                startActivity(intent);
            }
        });

    }
}
