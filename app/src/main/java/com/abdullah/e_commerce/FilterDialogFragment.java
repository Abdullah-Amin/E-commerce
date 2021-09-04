package com.abdullah.e_commerce;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class FilterDialogFragment extends DialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().getWindow().setGravity(Gravity.END|Gravity.BOTTOM);
        return inflater.inflate(R.layout.fragment_filter_dialog, container, false);




    }
}