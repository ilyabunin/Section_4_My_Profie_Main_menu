package com.example.ilyab.section_4_my_profie_main_menu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.example.ilyab.section_4_my_profie_main_menu.models.MainImages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 02.04.2017.
 */

public class ExerciseListAdapter extends BaseAdapter  {
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private Context context;
    private CheckBox mCheckBox;
    int VISIBILITY;

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    List<MainImages> mImages = new ArrayList<>();
    private ArrayList<Exercise> exe = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);

        notifyDataSetChanged();
    }

    public List<MainImages> getMainImages() {
        return mImages;
    }

    public void setMainImages(MainImages main_image) {
        mImages.add(main_image);
    }

    public ExerciseListAdapter(Context context,int visibility) {
        this.context = context;
        this.VISIBILITY=visibility;
    }


    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return exercises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.exercise6_1_row, parent, false);
        TextView nameTxt = (TextView) view.findViewById(R.id.exercise_title_txt);

        mCheckBox = (CheckBox) view.findViewById(R.id.checked_exercises_in_categoryies);
        mCheckBox.setTag(exercises.indexOf((Exercise)getItem(position)));

        Exercise exercise = exercises.get(position);

        nameTxt.setText(exercise.getData());
        ImageView mainImg = (ImageView) view.findViewById(R.id.main_exercise_img_in_list);
        for (Integer mainImg1 : exercise.getImagesexercises()) {
            mainImg.setImageResource(mainImg1);
        }
        if(VISIBILITY == 12)
        mCheckBox.setVisibility(View.VISIBLE);
        else mCheckBox.setVisibility(view.GONE);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int getPosition = (int) buttonView.getTag();
                exercises.get(getPosition).setBox(isChecked);
            }
        });

        return view;
    }



}