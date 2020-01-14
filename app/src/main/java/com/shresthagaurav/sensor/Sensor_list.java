package com.shresthagaurav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Sensor_list extends AppCompatActivity {
private SensorManager sensorManager;
private TextView textView;
    String sensors="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );
        textView= findViewById( R.id.sensortv );
        sensorManager =(SensorManager) getSystemService( SENSOR_SERVICE );
        List<Sensor>sensorList=sensorManager.getSensorList( Sensor.TYPE_ALL );
        for(int i=0;i<sensorList.size();i++){
            sensors+=sensorList.get( i ).getName()+"\n";
            textView.setText( i+" :"+sensors );
        }
    }
}
