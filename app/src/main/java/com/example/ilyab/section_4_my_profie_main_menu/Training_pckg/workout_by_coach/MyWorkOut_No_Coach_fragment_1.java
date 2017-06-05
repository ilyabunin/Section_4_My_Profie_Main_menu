package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.pckg_vip_advertising.Vip_fragment;

/**
 * Created by ilyab on 05.03.2017.
 */

public class MyWorkOut_No_Coach_fragment_1 extends Fragment {
    private Button btn_get_coach;

        private ImageButton btn_vip;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.workout_no_coach, container, false);
        btn_get_coach = (Button) view.findViewById(R.id.btn_get_coach);
        btn_vip = (ImageButton) view.findViewById(R.id.vip_button_start);
        btn_vip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent vip= new Intent(getActivity().getApplicationContext(),Vip_fragment.class);
                startActivity(vip);
            }
            });
        btn_get_coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment newFragment = new MainChooseCoachFragment();
                FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, newFragment);
                fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
                fragmentTransaction.commit();


            }
        });
        return view;
//    }
    }
}