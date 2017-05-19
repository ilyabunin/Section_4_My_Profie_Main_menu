package com.example.ilyab.section_4_my_profie_main_menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ilyab on 25.02.2017.
 */
public class MyProfileFragment_7_3 extends Fragment {
    private Button sbmt;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Change Password");
        View view= inflater.inflate(R.layout.activity_main_password, container,false);
        sbmt= (Button) view.findViewById(R.id.change_password_button);
        return view;
    }

}
