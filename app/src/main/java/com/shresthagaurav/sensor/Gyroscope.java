package com.shresthagaurav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Gyroscope extends AppCompatActivity {
    TextView textView;
    EditText number1;
    EditText number2;
    Button btn_check;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_gyroscope );
        textView = findViewById( R.id.result );
        number1 = findViewById( R.id.number1 );
        number2 = findViewById( R.id.number2 );
        btn_check = findViewById( R.id.check );

        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );
        final Sensor sensor = sensorManager.getDefaultSensor( Sensor.TYPE_GYROSCOPE );
        btn_check.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SensorEventListener gyo = new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {

                        if (event.values[1] < 0) {
                            Action( "add" );
                            Toast.makeText( Gyroscope.this, "add", Toast.LENGTH_SHORT ).show();


                        } else if (event.values[1] > 0) {
                            Action( "sub" );
                            Toast.makeText( Gyroscope.this, "sub", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }

                };
                if (sensor != null) {
                    sensorManager.registerListener( gyo, sensor, sensorManager.SENSOR_DELAY_NORMAL );

                } else {
                    Toast.makeText( Gyroscope.this, "no Sensor found", Toast.LENGTH_SHORT ).show();
                }
            }

        } );


    }

    void Action(String status) {
        int n1;
        int n2;
        try {
            n1 = Integer.parseInt( number1.getText().toString() );
            n2 = Integer.parseInt( number2.getText().toString() );
            if (status.equalsIgnoreCase( "add" )) {
                textView.setText( " result is :" + n1 + " + " + n2 + " = " + (n1 + n2) );
            } else if (status.equalsIgnoreCase( "sub" )) {
                textView.setText( " result is :" + n1 + " - " + n2 + " = " + (n1 - n2) );

            }
        } catch (Exception i) {
            i.printStackTrace();
        }

    }
}
