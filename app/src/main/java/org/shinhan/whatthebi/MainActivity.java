package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText_id;
    private EditText editText_password;
    private Button button_login;
    private Button button_sign_in;
    private String id;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_id=(EditText)findViewById(R.id.editText_main_id);
        editText_password=(EditText)findViewById(R.id.editText_main_password);
        button_login=(Button)findViewById(R.id.button_main_login);
        button_sign_in=(Button)findViewById(R.id.button_main_sinpgu);

        editText_id.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                editText_id.setText("");
                return false;
            }
        });

        editText_password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                editText_password.setText("");
                return false;
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=editText_id.getText().toString();
                password=editText_password.getText().toString();
                //todo 화면이동
                Intent intent = new Intent(getApplicationContext(), TypeAlarmActivity.class); // 다음 넘어갈 클래스 지정
                intent.putExtra("id",id);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SingInActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
            }
        });
    }
}
