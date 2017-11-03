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

public class PhoneActivity extends AppCompatActivity {
   private String phoneNumber="";
   private Button button_next;
    private EditText editText_phone;
    private Intent intent;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=getIntent();
        setContentView(R.layout.activity_phone);
        setView();

    }

    public void setView(){
        editText_phone=(EditText) findViewById(R.id.editText_activityPhone_num);
        button_next=(Button)findViewById(R.id.button_activityComplete_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=editText_phone.getText().toString();
                intent.setClass(getApplicationContext(),CompleteActivity.class);
                intent.putExtra("phoneNumber",phoneNumber);
                startActivity(intent);
            }
        });
    }
}
