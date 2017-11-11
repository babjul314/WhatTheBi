package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * Created by 60029509 on 2017-09-15.
 */

public class SingInActivity extends AppCompatActivity {

    Button button_login;
    EditText editText_id;
    EditText editText_password;
    EditText editText_confirm;
    RequestParams params  ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editText_id= (EditText)findViewById(R.id.editText_signin_id);
        editText_password= (EditText)findViewById(R.id.editText_signin_confirm);
        editText_confirm= (EditText)findViewById(R.id.editText_signin_password);
        button_login=(Button)findViewById(R.id.button_signin_submit);
        params = new RequestParams();
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
        editText_confirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                editText_confirm.setText("");
                return false;
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                params.put("id",editText_id.getText());
                params.put("password",editText_password.getText());
                if(!(editText_password.getText().toString().equals(editText_confirm.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"패스워드가 일치하지 않습니니다.",Toast.LENGTH_LONG).show();
                }else
                {
                    ClientHttp.get("/signin", params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String Text =new String(responseBody);
                            Log.e("받은데이터" ,Text);
                            Toast.makeText(getApplicationContext(),"가입에 성공하였습니다",Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            String Text =new String(responseBody);
                            Log.e("받은데이터" ,Text);
                            Toast.makeText(getApplicationContext(),"가입에 실패하였습니다.",Toast.LENGTH_LONG).show();
                        }
                    });

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

}
