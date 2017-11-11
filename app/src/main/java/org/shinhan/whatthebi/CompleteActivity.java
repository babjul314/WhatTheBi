package org.shinhan.whatthebi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Calendar;

import cz.msebera.android.httpclient.Header;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class CompleteActivity extends AppCompatActivity {


    Intent intent;
    String         coldTemp;
    String         hotTemp;
    String          phoneNumber;
    String        id;
    String         password;
    String         isSendMessage;
    String          isSendApp;
    String        time;
    String          isHot;
    String         isCold;
    String          isRain;
    String         isDust;
    RequestParams params  ;
    String Base_url="https://watdabi-project-babjul814.c9users.io/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        Log.e("1","1 시작");
        intent = getIntent();
        intent.setClass(getApplicationContext(),EndActivity.class);
        coldTemp=intent.getExtras().getString("coldTemp","");
        hotTemp=intent.getExtras().getString("hotTemp","");
        phoneNumber=intent.getExtras().getString("phoneNumber","");
        id=intent.getExtras().getString("id","");
        password=intent.getExtras().getString("password","");
        isSendMessage=intent.getExtras().getString("isSendMessage","");
        isSendApp=intent.getExtras().getString("isSendApp","");
        time=intent.getExtras().getString("time","");
        isHot=intent.getExtras().getString("isHot","");
        isCold=intent.getExtras().getString("isCold","");
        isRain=intent.getExtras().getString("isRain","");
        isDust=intent.getExtras().getString("isDust","");
        params = new RequestParams();
        params.put("coldTemp", coldTemp);
        params.put("hotTemp", hotTemp);
        params.put("phoneNumber", phoneNumber);
        params.put("id", id);
        params.put("coldTemp", coldTemp);
        params.put("password", password);
        params.put("isSendMessage", isSendMessage);
        params.put("isSendApp", isSendApp);
        params.put("time", time);
        params.put("isHot", isHot);
        params.put("isCold", isCold);
        params.put("isCold", isCold);
        params.put("isRain", isRain);
        params.put("isDust", isDust);

        ClientHttp.get("/regWeaInf", params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    String result =new String(responseBody);
                    if("true".equals(result))
                    {
                         SharedPreferences pref = getSharedPreferences("watdabi", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("id", id);
                        editor.commit();
                        int hour=intent.getExtras().getInt("setUphour");
                        int minute=intent.getExtras().getInt("setUpminute");
                        Calendar calendar = Calendar.getInstance();

                        int nowyear = calendar.get(Calendar.YEAR);//올해
                        int nowmonth = calendar.get(Calendar.MONTH);//이번달(10월이면 9를 리턴받는다. calendar는 0월부터 11월까지로 12개의월을 사용)
                        int nowday = calendar.get(Calendar.DAY_OF_MONTH);//오늘날짜
                        int nowhour = calendar.get(Calendar.HOUR_OF_DAY);//현재시간
                        int nowminute = calendar.get(Calendar.MINUTE);//현재분

                        if((nowhour*60+nowminute)>hour*60+minute)  //이미시간이 지났을때
                        {
                            calendar.set(nowyear, nowmonth ,nowday+1 ,hour, minute,00);//내일울린다

                        }else{
                            calendar.set(nowyear, nowmonth ,nowday ,hour, minute,00);//오늘울린다
                        }



                        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        Intent intent2 = new Intent(getApplicationContext(),AlarmBroadCastReciever.class);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        PendingIntent sender = PendingIntent.getBroadcast(getApplication(), 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

                        Log.e("알람시간:",""+calendar.getTime());
                        alarm.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, sender );
                        Intent intent = new Intent(getApplicationContext(),EndActivity.class);
                        startActivity(intent);

                    }else
                    {
                        Toast.makeText(getApplicationContext(),"등록에 실패하였습니다.",Toast.LENGTH_LONG).show();
                        finishAffinity();
                    }

                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    String Text =new String(responseBody);
                    Log.e("받은데이터" ,Text);
                }
            });




    }



}




