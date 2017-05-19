package com.example.ilyab.section_4_my_profie_main_menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.models.User;

/**
 * Created by ilyab on 21.02.2017.
 */

public class CustomUserInfoList extends BaseAdapter {

    private final Activity context;
//    private final String[] users_params;
    private final Integer[] imageId;
    private User user;



    public CustomUserInfoList(Activity context,User user, Integer[] imageId) {
        this.context = context;
        this.user = user;
        this.imageId = imageId;

    }

    public void updateUser(User user){
        this.user = user;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return user.getUsers_params().length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.exercise_txt);

        TextView txtInput= (TextView) rowView.findViewById(R.id.input_value);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(user.getUsers_params()[position]);
        if (position == 1)
            txtInput.setText(String.valueOf(user.getUserParam(position)) + " kg");
        else
            txtInput.setText(String.valueOf(user.getUserParam(position)) + " cm");
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
