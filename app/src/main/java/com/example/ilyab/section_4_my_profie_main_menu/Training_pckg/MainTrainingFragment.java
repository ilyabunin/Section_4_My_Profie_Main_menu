package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.pckg_vip_advertising.Vip_fragment;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings.MainPersonTrainFragment_recycler_v_edit;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach.MyWorkOut_No_Coach_fragment_1;

public class MainTrainingFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Menu in My Profile");
        View view = inflater.inflate(R.layout.activity_main_menu_training, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton btn_start_vip = (ImageButton) getActivity().findViewById(R.id.vip_button_start);
        Button btn_start_workout_coach = (Button) getActivity().findViewById(R.id.btn_coach_trainings);
        Button btn_start_personal_training = (Button) getActivity().findViewById(R.id.btn_personal_trainings);
        Button btn_start_prepared_training = (Button) getActivity().findViewById(R.id.btn_prepared_trainings);
        btn_start_personal_training.setOnClickListener(this);
        btn_start_vip.setOnClickListener(this);
        btn_start_workout_coach.setOnClickListener(this);
        btn_start_prepared_training.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main);

        switch (v.getId()) {
            case R.id.vip_button_start:
                Intent vip = new Intent(getActivity().getApplicationContext(), Vip_fragment.class);
                startActivity(vip);
                break;
            case R.id.btn_coach_trainings:
                fragment = new MyWorkOut_No_Coach_fragment_1();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();

                break;

            case R.id.btn_personal_trainings:
                fragment = new MainPersonTrainFragment_recycler_v_edit();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();
                break;
            case R.id.btn_prepared_trainings:
                fragment = new MainPreparedTrainingFragment();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();
                break;

        }
    }
}

