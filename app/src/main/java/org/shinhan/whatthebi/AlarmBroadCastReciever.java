package org.shinhan.whatthebi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

import static android.content.Context.MODE_PRIVATE;

public class AlarmBroadCastReciever extends BroadcastReceiver implements LocationListener {
    GpsInfo gpsInfo;
    String id;
    double lat;
    double lon;
    @Override
    public void onReceive(final Context context, final Intent intent) {

        gpsInfo= new GpsInfo(context);
        final RequestParams params = new RequestParams();
        SharedPreferences pref = context.getSharedPreferences("watdabi", MODE_PRIVATE);
        id=pref.getString("id","");
        params.put("id",id);
        Log.e("id",id);
        ClientHttp.get("/getWeather", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.e("response",response+"");
                Toast.makeText(context,response+"",Toast.LENGTH_LONG).show();
                   String whether=response.split("/")[0];
                    String temp=response.split("/")[1];
                Log.e("whether",whether+"");
                Toast.makeText(context,whether+"",Toast.LENGTH_LONG).show();
                Log.e("temp",temp+"");
                Toast.makeText(context,temp+"",Toast.LENGTH_LONG).show();
                if("cold".equals(whether))
                {
                 Intent intent1 = new Intent(context,alamColdActivity.class);
                    context.startActivity(intent1);
                }else if("hot".equals(whether))
                {
                    Intent intent1 = new Intent(context,alamHotActivity.class);
                    context.startActivity(intent1);
                }else if("rain".equals(whether))
                {
                    Intent intent1 = new Intent(context,alamRainActivity.class);
                    context.startActivity(intent1);
                }



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String Text = new String(responseBody);
                Log.e("받은데이터", Text);
                Toast.makeText(context, "데이터 조회실패.", Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public void onLocationChanged(Location location) {
        location.getAltitude();
        location.getLatitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
