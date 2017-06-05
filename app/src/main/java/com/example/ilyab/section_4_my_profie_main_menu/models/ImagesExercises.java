package com.example.ilyab.section_4_my_profie_main_menu.models;

import java.util.HashMap;

/**
 * Created by ilyab on 21.05.2017.
 */

public class ImagesExercises extends HashMap<String, Integer> {
    private String data;
    private Integer img;

    public ImagesExercises(String data, Integer img) {
        this.data = data;
        this.img = img;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
