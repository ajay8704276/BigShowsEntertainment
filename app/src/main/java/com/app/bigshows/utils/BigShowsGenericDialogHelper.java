package com.app.bigshows.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.app.bigshows.R;

/**
 * Created by Ajay Kumar on 7/17/2016.
 */

public class BigShowsGenericDialogHelper extends ProgressDialog {

    public static ProgressDialog dialog;

    public BigShowsGenericDialogHelper(Context mContext) {
        super(mContext);

    }

    public BigShowsGenericDialogHelper(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
    }


    public static ProgressDialog buildDialog(Context mContext, String msg, boolean isCancelable) {

        dialog = new BigShowsGenericDialogHelper(mContext);
        dialog.setCancelable(isCancelable);
        dialog.setMessage(msg);
        return dialog;
    }

    public static ProgressDialog buildDialog(Context mContext, String msg, boolean isCancelable, boolean isDeterminate) {

        dialog = new BigShowsGenericDialogHelper(mContext, android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
        dialog.setMessage(msg);
        dialog.setCancelable(isCancelable);
        dialog.setIndeterminate(isDeterminate);

        return dialog;
    }

    public static ProgressDialog builddefaultDialog(Context mContext, String msg, boolean isCancelable, boolean isDeterminate) {

        dialog = new ProgressDialog(mContext);
        dialog.setMessage(msg);
        dialog.setCancelable(isCancelable);
        dialog.setIndeterminate(isDeterminate);
        return dialog;
    }
}
