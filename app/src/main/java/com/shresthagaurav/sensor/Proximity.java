package com.shresthagaurav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Proximity extends AppCompatActivity {
    TextView textView;
    EditText number1;
    EditText number2;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_proximity );
        textView =findViewById( R.id.result);
        number1 =findViewById( R.id.number11);
        number2 =findViewById( R.id.number22);

        sensorManager=(SensorManager)getSystemService( SENSOR_SERVICE );
        Sensor sensor = sensorManager.getDefaultSensor( Sensor.TYPE_PROXIMITY );
        SensorEventListener gyo = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(event.values[0]<= 4){
                    Action( "add" );
                    textView.setBackgroundColor( Color.RED );
                    textView.setTextColor( Color.WHITE );

                }else {
                    Action( "sub" );
                    textView.setBackgroundColor( Color.BLUE );
                    textView.setTextColor( Color.WHITE );
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if(sensor!=null){
            sensorManager.registerListener( gyo,sensor,sensorManager.SENSOR_DELAY_NORMAL );

        }else{
            Toast.makeText( this, "no Sensor found", Toast.LENGTH_SHORT ).show();
        }
    }
    void Action(String status){
        int n1= 0;
        n1=Integer.parseInt( number1.getText().toString() );
        int n2 = 0;
        n2=Integer.parseInt( number2.getText().toString() );
        if(status.equalsIgnoreCase( "add" )){
            textView.setText( " result is :"+n1+" + "+n2+" = " +(n1+n2) );
        }else if(status.equalsIgnoreCase( "sub" )){
            textView.setText( " result is :"+n1+" - "+n2+" = " +(n1-n2) );
        }

    }
    }

