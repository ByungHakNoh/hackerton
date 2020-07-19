package org.personal.hackerton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        setInitView();
    }

    private void setInitView() {
        TextView upHeungTV = findViewById(R.id.upHeungTV);
        TextView downHeungTV = findViewById(R.id.downHeungTV);

        upHeungTV.setOnClickListener(this);
        downHeungTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upHeungTV:
                // 측정 액티비티로 넘어감
                // TODO : 데이터 보내야 할 수도 있음
                Intent toPedometer = new Intent(this, PedometerActivity.class);
                startActivity(toPedometer);
                break;

            case R.id.downHeungTV:
                //TODO : 거절하기 fcm으로 상대에게 보내기 + 흥 컨텐츠 종료
                break;
        }
    }
}