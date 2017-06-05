package com.example.ilyab.section_4_my_profie_main_menu.models;

import java.util.ArrayList;

/**
 * Created by Max on 08.05.2017.
 */

public class ArrayCategory {
    ArrayList<Category> categories;

    public ArrayCategory(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayCategory() {
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
