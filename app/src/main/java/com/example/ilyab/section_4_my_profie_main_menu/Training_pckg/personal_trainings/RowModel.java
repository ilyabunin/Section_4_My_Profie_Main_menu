package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import java.util.Date;

public class RowModel {
    private String mainText, subText, id, description;

    public RowModel(String mainText, String subText, String description) {
        this.mainText = mainText;
        this.subText = subText;
        this.description =description;
        this.id = String.valueOf((new Date()).getTime());
    }

    private RowModel() {
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
        String[] arr = data.split(";");
        rowModel.setMainText(arr[0]);
        rowModel.setSubText(arr.length > 1 ? arr[1] : "");
        rowModel.setDescription(arr.length > 2 ? arr[2] : "");
        return rowModel;
    }
}
