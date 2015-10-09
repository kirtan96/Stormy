package com.kirtan.stormy.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.kirtan.stormy.R;

/**
 * Created by Kirtan on 8/3/15.
 */
public class AlertDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Context context = getActivity();
        AlertDialog.Builder builer = new AlertDialog.Builder(context);
        builer.setTitle(R.string.error_title).setMessage(R.string.error_message).setPositiveButton(R.string.error_ok_button_text, null);
        AlertDialog dialog = builer.create();
        return dialog;
    }
}
