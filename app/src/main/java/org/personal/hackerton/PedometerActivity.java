package org.personal.hackerton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class PedometerActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    private String TAG = "PedometerActivity";
    private ProgressBar pedometerCountPB;
    private SensorManager sensorManager;
    private Sensor pedometerSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
        setInitView();
        setPedometerSensor();
    }

    private void setInitView() {
        pedometerCountPB = findViewById(R.id.pedometerCountPB);
        Button startPedometerBtn = findViewById(R.id.startPedometerBtn);

        startPedometerBtn.setOnClickListener(this);
    }

    private void setPedometerSensor() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startPedometerBtn:

                break;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}