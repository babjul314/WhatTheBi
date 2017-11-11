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

public class HotActivity extends AppCompatActivity {

    private EditText editText_hot_temp;
    private Button button_next;
    private String hot_temp="";
    private Intent intent;


    public void setHot_temp(String hot_temp) {
        this.hot_temp = hot_temp;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        setContentView(R.layout.activity_hot);
        setView();
    }
    public void setView(){
        editText_hot_temp=(EditText)findViewById(R.id.editText_hot_temp);
        button_next= (Button)findViewById(R.id.button_activitytime_submit);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHot_temp(editText_hot_temp.getText().toString());
                if(intent.getExtras().getString("isCold","").equals("true"))
                {
                    intent.setClass(getApplicationContext(),ColdActivity.class);

                }else
                {
                    intent.setClass(getApplicationContext(),TimeActivity.class);
                }

                startActivity(intent);
            }
        });
    }
}
