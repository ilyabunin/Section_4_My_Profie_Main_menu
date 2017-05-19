package com.example.ilyab.section_4_my_profie_main_menu.MyProfile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;

/**
 * Created by ilyab on 21.02.2017.
 */

public class CustomUserInfoList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] users_params;
    private final Integer[] imageId;
    private String[] input_text;



    public CustomUserInfoList(Activity context, String[] input_text, String[] users_params, Integer[] imageId) {
        super(context, R.layout.user_info_list, users_params);
        this.context = context;
        this.users_params = users_params;
        this.imageId = imageId;
        this.input_text = input_text;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.exercise_txt);

        TextView txtInput= (TextView) rowView.findViewById(R.id.input_value);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(users_params[position]);
        txtInput.setText(input_text[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
