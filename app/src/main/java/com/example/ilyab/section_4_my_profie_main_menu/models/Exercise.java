package com.example.ilyab.section_4_my_profie_main_menu.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Max on 01.03.2017.
 */
public class Exercise {
    private String data;
//    public CheckBox mCheckBox;
    public boolean box;
    List<DescriptionExercises> descriptions = new ArrayList<>();
    HashMap<String, Integer> images = new HashMap<>();
    List<Integer> imagesexercises = new ArrayList<>();

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

//    public CheckBox getCheckBox() {
//        return mCheckBox;
//    }

    public Exercise() {
    }

    public Exercise(List<Integer> imagesexercises) {
        this.imagesexercises = imagesexercises;
    }

    public List<Integer> getImagesexercises() {
        return imagesexercises;
    }

    public void setImagesexercises(List<Integer> imagesexercises) {
        this.imagesexercises = imagesexercises;
    }

    public Exercise(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HashMap<String, Integer> getImages() {
        return images;
    }



    public List<DescriptionExercises> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(DescriptionExercises description) {
        descriptions.add(description);
    }

    public void addImage(String key, Integer value) {
        this.images.put(key, value);
    }

    public void addImageExercise(Integer imagesExercises){
        imagesexercises.add(imagesExercises);
    }


}
