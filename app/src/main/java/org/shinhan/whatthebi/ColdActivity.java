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

public class ColdActivity extends AppCompatActivity {

    private EditText editText_cold_temp;
    private Button button_next;
    private String cold_temp="";
    private Intent intent;
    public void setHot_temp(String cold_temp) {
        this.cold_temp = cold_temp;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        setContentView(R.layout.activity_cold);
        setView();
    }
    public void setView(){
        editText_cold_temp=(EditText)findViewById(R.id.editText_time_time);
        button_next= (Button)findViewById(R.id.button_activitytime_submit);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHot_temp(editText_cold_temp.getText().toString());
                intent.setClass(getApplicationContext(),TimeActivity.class);
                intent.putExtra("coldTemp",cold_temp);
                 startActivity(intent);

            }
        });
    }
}
