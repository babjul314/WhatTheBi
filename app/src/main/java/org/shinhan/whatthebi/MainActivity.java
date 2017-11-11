package org.shinhan.whatthebi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private EditText editText_id;
    private EditText editText_password;
    private Button button_login;
    private Button button_sign_in;
    private String id;
    private String password;
    private RequestParams params  ;
    private ProgressBar progressBar;
    //public GpsInfo gpsInfo;
    LocationManager locationManager;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        setContentView(R.layout.activity_main);
//        gpsInfo = new GpsInfo(getApplicationContext());
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getSystemService(context);
        final String provider = LocationManager.GPS_PROVIDER;
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        editText_id = (EditText) findViewById(R.id.editText_main_id);
        editText_password = (EditText) findViewById(R.id.editText_main_password);
        button_login = (Button) findViewById(R.id.button_main_login);
        button_sign_in = (Button) findViewById(R.id.button_main_sinpgu);
        params = new RequestParams();


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                id = editText_id.getText().toString();
                password = editText_password.getText().toString();
                //todo 화면이동
                intent = new Intent(getApplicationContext(), TypeAlarmActivity.class); // 다음 넘어갈 클래스 지정
                intent.putExtra("id", id);
                intent.putExtra("password", password);
                params.put("id", id);
                params.put("password", password);


                ClientHttp.get("/login", params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        String response = new String(responseBody);
                        if ("true".equals(response)) {
                            Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        String Text = new String(responseBody);
                        Log.e("받은데이터", Text);
                        Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onProgress(long bytesWritten, long totalSize) {
                        super.onProgress(bytesWritten, totalSize);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                });

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
