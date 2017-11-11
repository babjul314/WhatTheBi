package org.shinhan.whatthebi;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AlramActivity extends AppCompatActivity {
    Location location;
    double latitude;
    double altitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        location= new Location("");


    }

}
