package org.personal.hackerton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "MainActivity";
    private ProgressBar contestProgressBarPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitView();
    }

    private void setInitView() {
        contestProgressBarPB = findViewById(R.id.contestProgressBarPB);
        Button viewStatusBtn = findViewById(R.id.viewStatusBtn);
        Button joinContestBtn = findViewById(R.id.joinContestBtn);

        viewStatusBtn.setOnClickListener(this);
        joinContestBtn.setOnClickListener(this);

        contestProgressBarPB.setProgress(20); // TODO : 자기 자신의 참여율
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.viewStatusBtn:

                break;

            case R.id.joinContestBtn:
                Intent  toPedometerActivity = new Intent(this, PedometerActivity.class);
                startActivity(toPedometerActivity);
                break;
        }
    }
}