package org.personal.hackerton.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.personal.hackerton.R;

public class PedometerSettingDialog extends DialogFragment {

    private static final String TAG = "BoardPillSettingDialog";

    private DialogListener dialogListener;
    private NumberPicker pedometerCountNP;
    private String whichSetting;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // 셀프인지 함께하기인지 확인하는 변수
        if (getArguments() != null) whichSetting = getArguments().getString("whichSetting");

        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.dialog_pedometer_setting, null);

        pedometerCountNP = dialogView.findViewById(R.id.pedometerCountNP);
        // TODO : 나중에 간격 5 정도로 설정하기
        pedometerCountNP.setMaxValue(200);
        pedometerCountNP.setValue(100);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("만보기 횟수 선택")
                .setView(dialogView)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialogListener.applyDialogChoice(whichSetting, pedometerCountNP.getValue());
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dismiss();
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {

            dialogListener = (DialogListener) context;

        } catch (ClassCastException e) {
            e.printStackTrace();
            Log.i(TAG, "onAttach: 액티비티에서 인터페이스 구현하기");
        }
    }

    public interface DialogListener {

        void applyDialogChoice(String whichSetting, int pedometerCount);
    }
}