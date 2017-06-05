package com.example.ilyab.section_4_my_profie_main_menu.models;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 26.02.2017.
 */

public class Category {
    private String data;
    List<Exercise> exercises=new ArrayList<>();
    List<Integer> mExercises = new ArrayList<>();

    public Category() {
    }


    public List<Exercise> getExercises() {
        return exercises;
    }
    public List<Integer> getImageCategory() {
        return mExercises;
    }

    public Category(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }
    public void addImageCategory(Integer imagesExercises){
        mExercises.add(imagesExercises);
    }


}
