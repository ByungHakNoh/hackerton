package org.personal.hackerton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.personal.hackerton.DialogFragment.PedometerSettingDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PedometerSettingDialog.DialogListener {

    private String TAG = "MainActivity";
    private ProgressBar joyPercentagePB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitView();
    }

    private void setInitView() {
        joyPercentagePB = findViewById(R.id.joyProgressBarPB);
        Button selfPedometerBtn = findViewById(R.id.selfPedometerBtn);
        Button togetherPedometerBtn = findViewById(R.id.togetherPedometerBtn);

        selfPedometerBtn.setOnClickListener(this);
        togetherPedometerBtn.setOnClickListener(this);

        joyPercentagePB.setProgress(20);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.selfPedometerBtn:
//                showSettingDialog("self");
                Intent intent = new Intent(this, FriendListActivity.class);
                startActivity(intent);
                break;

            case R.id.togetherPedometerBtn:
                showSettingDialog("together");
                break;
        }
    }

    // 만보기 세팅하는 다이얼로그 : 셀프인지 함께인지 변수값을 보냄
    private void showSettingDialog(String isSelfSetting) {
        PedometerSettingDialog pedometerSettingDialog = new PedometerSettingDialog();
        Bundle arguments = new Bundle();

        arguments.putString("whichSetting", isSelfSetting);
        pedometerSettingDialog.setArguments(arguments);

        pedometerSettingDialog.show(getSupportFragmentManager(), "PedometerSettingDialog");
    }

    //---------------------------------------------- 다이얼로그 리스너 ----------------------------------------------
    @Override
    public void applyDialogChoice(String whichSetting, int pedometerCount) {
        switch (whichSetting) {
            case "self":
                Log.i(TAG, "self");
                break;

            case "together":
                Log.i(TAG, "together");
                break;
        }
    }
}