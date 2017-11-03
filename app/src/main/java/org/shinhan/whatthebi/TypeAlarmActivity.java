package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by 60029509 on 2017-09-16.
 */

public class TypeAlarmActivity extends AppCompatActivity {
    private CheckBox checkBox_hot;
    private CheckBox checkBox_cold;
    private CheckBox checkBox_raing;
    private CheckBox checkBox_dust;
    private Button button_next;
    private String isHot="false";
    private String isCold="false";
    private String isRain="false";
    private String isDust="false";
    private Intent    intent;

    public String isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = "true";
    }

    public String isCold() {
        return isCold;
    }

    public void setCold(boolean cold) {
        isCold = "true";
    }

    public String isRain() {
        return isRain;
    }

    public void setRain(boolean rain) {
        isRain = "true";
    }

    public String isDust() {
        return isDust;
    }

    public void setDust(boolean dust) {
        isDust = "true";
    }



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_alarm);
        intent=getIntent();
        checkBox_hot =(CheckBox)findViewById(R.id.checkBox_type_alarm_hot);
        checkBox_cold= (CheckBox)findViewById(R.id.checkBox_type_alarm_cold);
        checkBox_raing=(CheckBox)findViewById(R.id.checkBox_type_alarm_rain);
        checkBox_dust=(CheckBox)findViewById(R.id.checkBox_type_alarm_dust);
        button_next=(Button) findViewById(R.id.button_type_alarm_cold_submit);
        setButton();
        }
    public void setButton(){
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox_hot.isChecked())
                {
                    intent.setClass(getApplicationContext(),HotActivity.class);


                }else if(checkBox_cold.isChecked())
                {
                    intent.setClass(getApplicationContext(),ColdActivity.class);
                }else
                {
                    intent.setClass(getApplicationContext(),TimeActivity.class);
                }
                intent=setCheckBox(intent);
                startActivity(intent);
            }
        });

    }
    public Intent setCheckBox (Intent intent){

                if(checkBox_cold.isChecked())
                {
                    setCold(true);
                }else
                {
                    setCold(false);
                }



                if(checkBox_hot.isChecked())
                {
                    setHot(true);
                }
                else{
                    setHot(false);
                }


                if(checkBox_dust.isChecked())
                {
                    setDust(true);
                }else
                {
                    setDust(false);
                }

                if(checkBox_raing.isChecked())
                {
                    setRain(true);
                }
                else
                {
                    setRain(false);
                }

                intent.putExtra("isHot",isHot);
                intent.putExtra("isCold",isCold);
                intent.putExtra("isRain",isRain);
                intent.putExtra("isDust",isDust);
                return intent;
            }




    }

