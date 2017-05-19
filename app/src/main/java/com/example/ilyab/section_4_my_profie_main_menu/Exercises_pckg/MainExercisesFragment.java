package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilyab.section_4_my_profie_main_menu.R;

public class MainExercisesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main_menu_exercises,null);
    }
}

