package com.example.ilyab.section_4_my_profie_main_menu.models;

import java.util.ArrayList;

/**
 * Created by ilyab on 03.06.2017.
 */

public class ArrayExercises {
    private ArrayList<Exercise> mExercises;

    public ArrayExercises() {
    }

    public ArrayExercises(ArrayList<Exercise> exercises) {
        mExercises = exercises;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        mExercises = exercises;
    }
}
