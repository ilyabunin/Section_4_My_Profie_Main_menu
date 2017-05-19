package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;


public class MainPreparedTrainingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout_prepared_trainings, container, false);
        TextView textView = new TextView(getActivity());
        return view;
    }


}
