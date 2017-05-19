package com.example.ilyab.section_4_my_profie_main_menu;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ilyab on 22.02.2017.
 */

public class MyProfileFragment_7_2 extends Fragment implements View.OnClickListener {
    private Button btnPasFrag, btnRefFrag;
    private MenuItem back, info;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Menu in My Profile");
        View view = inflater.inflate(R.layout.myprofile_7_2, container, false);
        btnPasFrag = (Button) view.findViewById(R.id.button_view_change_password);
        btnRefFrag = (Button) view.findViewById(R.id.button_view_references);
        back = (MenuItem) view.findViewById(R.id.action_menu_profile_back);
        info = (MenuItem) view.findViewById(R.id.action_menu_profile);
        btnRefFrag.setOnClickListener(this);
        btnPasFrag.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_view_change_password) {
            ShowMenuBack();
            Fragment newFragment = new MyProfileFragment_7_3();
            FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_main, newFragment);
            fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
            fragmentTransaction.commitAllowingStateLoss();

        }
        if (v.getId() == R.id.button_view_references) {
            ShowMenuBack();
            Fragment newFragment = new MyProfileFragment_7_4();
            FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_main, newFragment);
            fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
            fragmentTransaction.commitAllowingStateLoss();

        }
    }

    public void ShowMenuBack() {


    }


}
