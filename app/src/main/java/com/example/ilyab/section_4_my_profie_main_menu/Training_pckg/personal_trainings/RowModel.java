package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import com.google.gson.Gson;

import java.util.Date;

public class RowModel {
    private String mainText, subText, id, description;

    public RowModel(String mainText, String subText, String description) {
        this.mainText = mainText;
        this.subText = subText;
        this.description =description;
        this.id = String.valueOf((new Date()).getTime());
    }

    public RowModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }


    @Override
    public String toString() {
        return mainText + ";" + subText + ";" +description;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public static RowModel newInstance(String id, String data) {
        RowModel rowModel = new RowModel();
        rowModel.setId(id);
        Gson gson = new Gson();
        RowModel model = gson.fromJson(data,RowModel.class);
//        String[] arr = data.split(";");
        rowModel.setMainText(model.getMainText());
        rowModel.setSubText(model.getSubText());
        rowModel.setDescription(model.getDescription());
        return rowModel;
    }
}
