package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class CompleteActivity extends AppCompatActivity {

    Button button_next;
    Intent intent;
    String coldTemp;
    String         hotTemp;
    String phoneNumber;
    String        id;
    String password;
    String         isSendMessage;
    String isSendApp;
    String        time;
    String isHot;
    String         isCold;
    String isRain;
    String         isDust;
    String jsonData;
    Gson gson= new Gson();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        intent = getIntent();
        intent.setClass(getApplicationContext(),EndActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
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
        Data data = new Data();
        data.setColdTemp(coldTemp);
        data.setHotTemp(hotTemp);
        data.setPhoneNumber(phoneNumber);
        data.setId(id);
        data.setPassword(password);
        data.setIsSendApp(isSendApp);
        data.setTime(time);
        data.setIsHot(isHot);
        data.setIsCold(isCold);
        data.setIsRain(isRain);
        data.setIsDust(isDust);
        String sendData=gson.toJson(data);

        Toast.makeText(getApplication(),
                sendData
                ,Toast.LENGTH_LONG).show();
        button_next=(Button)findViewById(R.id.button_activityComplete_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
    }

    public class Data{
        String coldTemp;
        String hotTemp;
        String phoneNumber;
        String id;
        String password;
        String isSendMessage;
        String isSendApp;
        String  time;
        String isHot;
        String  isCold;
        String isRain;
        String  isDust;
        public String getColdTemp() {
            return coldTemp;
        }

        public void setColdTemp(String coldTemp) {
            this.coldTemp = coldTemp;
        }

        public String getHotTemp() {
            return hotTemp;
        }

        public void setHotTemp(String hotTemp) {
            this.hotTemp = hotTemp;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getIsSendMessage() {
            return isSendMessage;
        }

        public void setIsSendMessage(String isSendMessage) {
            this.isSendMessage = isSendMessage;
        }

        public String getIsSendApp() {
            return isSendApp;
        }

        public void setIsSendApp(String isSendApp) {
            this.isSendApp = isSendApp;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getIsHot() {
            return isHot;
        }

        public void setIsHot(String isHot) {
            this.isHot = isHot;
        }

        public String getIsCold() {
            return isCold;
        }

        public void setIsCold(String isCold) {
            this.isCold = isCold;
        }

        public String getIsRain() {
            return isRain;
        }

        public void setIsRain(String isRain) {
            this.isRain = isRain;
        }

        public String getIsDust() {
            return isDust;
        }

        public void setIsDust(String isDust) {
            this.isDust = isDust;
        }


    }


}
