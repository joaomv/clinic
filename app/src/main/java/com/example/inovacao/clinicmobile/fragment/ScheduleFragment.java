package com.example.inovacao.clinicmobile.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inovacao.clinicmobile.R;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by inovacao on 29/01/2018.
 */

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        return rootView;
    }

}
