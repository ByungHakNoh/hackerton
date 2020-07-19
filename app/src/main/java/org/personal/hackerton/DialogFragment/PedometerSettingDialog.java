package org.personal.hackerton.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.personal.hackerton.R;

public class PedometerSettingDialog extends DialogFragment {

    private static final String TAG = "BoardPillSettingDialog";

    private DialogListener dialogListener;
    private int itemPosition;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {

            itemPosition = getArguments().getInt("itemPosition");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("선택 목록 삭제")
                .setMessage("선택하신 목록을 삭제하시겠습니까?")
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialogListener.applyDialogChoice(itemPosition);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
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

        void applyDialogChoice(int itemPosition);
    }
}