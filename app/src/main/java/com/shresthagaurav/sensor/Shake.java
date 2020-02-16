package com.shresthagaurav.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Shake extends AppCompatActivity  implements ShakeEventManager.ShakeListener{
    private ShakeEventManager sd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_shake );
        sd = new ShakeEventManager();
        sd.setListener(this);
        sd.init(this);
    }

    @Override
    public void onShake() {
        Toast.makeText(this, "Refresh data...", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        sd.register();
    }
    @Override
    protected void onPause() {
        super.onPause();
        sd.deregister();
    }
}
