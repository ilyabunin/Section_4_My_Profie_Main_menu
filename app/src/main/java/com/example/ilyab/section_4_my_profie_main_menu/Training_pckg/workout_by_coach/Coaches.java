package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach;

/**
 * Created by ilyab on 12.03.2017.
 */

public class Coaches {


    public Coaches(int imageId, String name, String degree, String specialization, String personal_info) {
        this.setImageId(imageId);
        this.setName(name);
        this.setDegree(degree);
        this.setSpecialization(specialization);
        this.setPersonal_info(personal_info);
    }

    private int imageId;
    private String name, degree,specialization,personal_info;
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPersonal_info() {
        return personal_info;
    }

    public void setPersonal_info(String personal_info) {
        this.personal_info = personal_info;
    }
}
