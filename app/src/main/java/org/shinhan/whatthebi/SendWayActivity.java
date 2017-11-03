package org.shinhan.whatthebi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by 60029509 on 2017-09-22.
 */

public class SendWayActivity extends AppCompatActivity {
    private CheckBox checkBox_sendWay_message;
    private CheckBox checkBox_sendway_app;
    private Button button_Next;
    private String isSendMessage="false";
    private String isSendApp="false";
    private Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_way);
        intent=getIntent();
        checkBox_sendway_app = (CheckBox)findViewById(R.id.checkBox_activitySendWay_app);
        checkBox_sendWay_message= (CheckBox)findViewById(R.id.checkBox_activitySendWay_message);
        button_Next=(Button)findViewById(R.id.button_activityComplete_next);

        setButton();

    }
    public void setButton(){

        button_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheckbox();
                intent.setClass(getApplicationContext(),PhoneActivity.class);
                intent.putExtra("isSendMessage",isSendMessage);
                intent.putExtra("isSendApp",isSendApp);
                startActivity(intent);
            }
        });

    }
    public void setCheckbox(){

                if(checkBox_sendWay_message.isChecked())
                {
                    isSendMessage="true";
                }else {
                    isSendMessage = "false";
                }



                        if(checkBox_sendway_app.isChecked())
                        {
                            isSendApp="true";
                        }else {
                            isSendApp = "false";
                        }



            }


    }


