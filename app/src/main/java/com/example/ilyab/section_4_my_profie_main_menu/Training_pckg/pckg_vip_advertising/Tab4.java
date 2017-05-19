package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.pckg_vip_advertising;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ilyab.section_4_my_profie_main_menu.R;


public class Tab4 extends Fragment implements View.OnClickListener {
private ImageButton close_vip;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tab4, container, false);
		close_vip = (ImageButton) view.findViewById(R.id.close_vip_button);
		close_vip.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.close_vip_button:
				getActivity().onBackPressed();
				break;
		}
	}

}
 