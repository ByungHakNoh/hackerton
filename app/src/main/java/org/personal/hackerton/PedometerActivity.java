package org.personal.hackerton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PedometerActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    private String TAG = "PedometerActivity";
    private ProgressBar pedometerCountPB;
    private SensorManager sensorManager;
    private Sensor pedometerSensor;

    private Boolean isInitCount = false;
    private int initCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
        setInitView();
        setPedometerSensor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, pedometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    private void setInitView() {
        pedometerCountPB = findViewById(R.id.pedometerCountPB);
        Button startPedometerBtn = findViewById(R.id.startPedometerBtn);

        startPedometerBtn.setOnClickListener(this);

        pedometerCountPB.setProgress(0);
    }

    private void setPedometerSensor() {
        Log.i(TAG, "setPedometerSensor : yes");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        pedometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (pedometerSensor == null) Toast.makeText(this, "센서 객체 없음", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startPedometerBtn:
                sensorManager.registerListener(this, pedometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
                break;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (!isInitCount) {
                initCount = (int) event.values[0];
                isInitCount = true;
                Log.i(TAG, "초기 값" + initCount);
            }

            int progressCount = (int) event.values[0] - initCount;

            pedometerCountPB.setProgress(progressCount);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}