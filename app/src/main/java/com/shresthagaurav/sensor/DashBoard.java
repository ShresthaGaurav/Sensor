package com.shresthagaurav.sensor;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class DashBoard extends AppCompatActivity {
    Button btn_sen, btnacc, gyo, pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );
        btn_sen = findViewById( R.id.sensor );
        btnacc = findViewById( R.id.acc );
        pro=findViewById( R.id.pro );
        gyo = findViewById( R.id.gyo );
        btn_sen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DashBoard.this, Sensor_list.class );
                startActivity( intent );

            }
        } );
        btnacc.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent( DashBoard.this, Accelerometer.class );
                startActivity( intents );

            }
        } );
        gyo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentss = new Intent( DashBoard.this, Gyroscope.class );
                startActivity( intentss );

            }
        } );
        pro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentsss = new Intent( DashBoard.this, Proximity.class );
                startActivity( intentsss );

            }
        } );
    }
}
