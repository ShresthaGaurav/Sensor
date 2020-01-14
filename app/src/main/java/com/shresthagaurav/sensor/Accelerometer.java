package com.shresthagaurav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Accelerometer extends AppCompatActivity {
TextView textView;
SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_accelerometer );
        textView=findViewById( R.id.Accele);
        sensorManager=(SensorManager)getSystemService( SENSOR_SERVICE );
        Sensor sensor = sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );
        SensorEventListener listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float [] value =event.values;
                String x="X :"+value[0];
                String y="Y :"+value[1];
                String z="Z :"+value[2];
                textView.setText( x+" "+y+" "+z );
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if(sensor!=null){
            sensorManager.registerListener( listener,sensor,sensorManager.SENSOR_DELAY_NORMAL );
            
        }else{
            Toast.makeText( this, "no Sensor found", Toast.LENGTH_SHORT ).show();
        }
        
    }
}
