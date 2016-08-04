package com.app.bigshows.utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Ajay Kumar on 7/29/2016.
 */

public class GenericDetailDialog extends DialogFragment {

    private static GenericDetailDialog newInstance(Bundle args){

        GenericDetailDialog mGenericDetailDialog = new GenericDetailDialog();
        mGenericDetailDialog.setArguments(args);
        return mGenericDetailDialog;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
