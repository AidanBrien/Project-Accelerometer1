package com.example.Android_Tutorial_Accelerometer;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends Activity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        acceleration = (TextView) findViewById(R.id.acceleration);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        acceleration.setText("X: " + event.values[0] +
                "\nY: " + event.values[1] +
                "\nZ: " + event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
