package com.example.til;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment_11 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedIntanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_11, container, false);

        return rootView;
    }
}