package com.example.ilyab.section_4_my_profie_main_menu.models;

import java.util.HashMap;

/**
 * Created by ilyab on 01.03.2017.
 */

public class User {
    private String[] users_params = {
            "Your height:",
            "Your weight:",
            "Neck girth:",
            "Chest girth:",
            "Waist girth:",
            "Hip girth:",
            "Left Hip:",
            "Right Hip:",
            "Left biceps:",
            "Right biceps:",
            "Left thigh:",
            "Right thigh:",
            "Left calf:",
            "Right calf:"
    };
    public static final String HEIGHT = "HEIGHT";
    public static final String WEIGHT = "WEIGHT";
    public static final String NECK = "NECK";
    public static final String CHEST = "CHEST";
    public static final String WAIST = "WAIST";
    public static final String HIP_GIRTH = "HIP_GIRTH";
    public static final String LEFT_HIP = "LEFT_HIP";
    public static final String RIGHT_HIP = "RIGHT_HIP";
    public static final String LEFT_BICEPS = "LEFT_BICEPS";
    public static final String RIGHT_BICEPS = "RIGHT_BICEPS";
    public static final String LEFT_THIGH = "LEFT_THIGH";
    public static final String RIGHT_THIGH = "RIGHT_THIGH";
    public static final String LEFT_CALF = "LEFT_CALF";
    public static final String RIGHT_CALF = "RIGHT_CALF";

    private HashMap<String,Integer> userParamData = new HashMap<>();
    public User() {
        userParamData.put(HEIGHT,0);
        userParamData.put(WEIGHT,0);
        userParamData.put(NECK,0);
        userParamData.put(CHEST,0);
        userParamData.put(WAIST,0);
        userParamData.put(HIP_GIRTH,0);
        userParamData.put(LEFT_HIP,0);
        userParamData.put(RIGHT_HIP,0);
        userParamData.put(LEFT_BICEPS,0);
        userParamData.put(RIGHT_BICEPS,0);
        userParamData.put(LEFT_THIGH,0);
        userParamData.put(RIGHT_THIGH,0);
        userParamData.put(LEFT_CALF,0);
        userParamData.put(RIGHT_CALF,0);
    }

    public User(int height, int weight, int neckGirth, int chestGirth, int waistGirth, int hipGirth, int leftHip, int rightHip, int leftBiceps, int rightBiceps, int leftThigh, int rightThigh, int leftCalf, int rightCalf) {
        userParamData.put(HEIGHT,height);
        userParamData.put(WEIGHT,weight);
        userParamData.put(NECK,neckGirth);
        userParamData.put(CHEST,chestGirth);
        userParamData.put(NECK,neckGirth);
        userParamData.put(WAIST,waistGirth);
        userParamData.put(HIP_GIRTH,hipGirth);
        userParamData.put(LEFT_HIP,leftHip);
        userParamData.put(RIGHT_HIP,rightHip);
        userParamData.put(LEFT_BICEPS,leftBiceps);
        userParamData.put(RIGHT_BICEPS,rightBiceps);
        userParamData.put(LEFT_THIGH,leftThigh);
        userParamData.put(RIGHT_THIGH,rightThigh);
        userParamData.put(LEFT_CALF,leftCalf);
        userParamData.put(RIGHT_CALF,rightCalf);
    }

    public String[] getUsers_params() {
        return users_params;
    }

    public HashMap<String, Integer> getUserParamData() {
        return userParamData;
    }

    public void setUserParamData(HashMap<String, Integer> userParamData) {
        this.userParamData = userParamData;
    }

    public int getHeight() {
        return userParamData.get(HEIGHT);
    }

    public void setHeight(int height) {
        userParamData.put(HEIGHT,height);
    }

    public int getWeight() {
        return userParamData.get(WEIGHT);
    }

    public void setWeight(int weight) {
        userParamData.put(WEIGHT,weight);
    }

    public int getNeckGirth() {
        return userParamData.get(NECK);
    }

    public void setNeckGirth(int neckGirth) {
        userParamData.put(NECK,neckGirth);
    }

    public int getChestGirth() {
        return userParamData.get(CHEST);
    }

    public void setChestGirth(int chestGirth) {
        userParamData.put(CHEST,chestGirth);
    }

    public int getWaistGirth() {
        return userParamData.get(WAIST);
    }

    public void setWaistGirth(int waistGirth) {
        userParamData.put(WAIST,waistGirth);
    }

    public int getHipGirth() {
        return userParamData.get(HIP_GIRTH);
    }

    public void setHipGirth(int hipGirth) {
        userParamData.put(HIP_GIRTH,hipGirth);
    }

    public int getLeftHip() {
        return userParamData.get(LEFT_HIP);
    }

    public void setLeftHip(int leftHip) {
        userParamData.put(LEFT_HIP,leftHip);
    }

    public int getRightHip() {
        return userParamData.get(RIGHT_HIP);
    }

    public void setRightHip(int rightHip) {
        userParamData.put(RIGHT_HIP,rightHip);
    }

    public int getLeftBiceps() {
        return userParamData.get(LEFT_BICEPS);
    }

    public void setLeftBiceps(int leftBiceps) {
        userParamData.put(LEFT_BICEPS,leftBiceps);
    }

    public int getRightBiceps() {
        return userParamData.get(RIGHT_BICEPS);
    }

    public void setRightBiceps(int rightBiceps) {
        userParamData.put(RIGHT_BICEPS,rightBiceps);
    }

    public int getLeftThigh() {
        return userParamData.get(LEFT_THIGH);
    }

    public void setLeftThigh(int leftThigh) {
        userParamData.put(LEFT_THIGH,leftThigh);
    }

    public int getRightThigh() {
        return userParamData.get(RIGHT_THIGH);
    }

    public void setRightThigh(int rightThigh) {
        userParamData.put(RIGHT_THIGH,rightThigh);
    }

    public int getLeftCalf() {
        return userParamData.get(LEFT_CALF);
    }

    public void setLeftCalf(int leftCalf) {
        userParamData.put(LEFT_CALF,leftCalf);
    }

    public int getRightCalf() {
        return userParamData.get(RIGHT_CALF);
    }

    public void setRightCalf(int rightCalf) {
        userParamData.put(RIGHT_CALF,rightCalf);
    }

    public int getUserParam(int position){
        switch (position){
            case 0:
                return getHeight();
            case 1:
                return getWeight();
            case 2:
                return getNeckGirth();
            case 3:
                return getChestGirth();
            case 4:
                return getWaistGirth();
            case 5:
                return getHipGirth();
            case 6:
                return getLeftHip();
            case 7:
                return getRightHip();
            case 8:
                return getLeftBiceps();
            case 9:
                return getRightBiceps();
            case 10:
                return getLeftThigh();
            case 11:
                return getRightThigh();
            case 12:
                return getLeftCalf();
            case 13:
                return getRightCalf();
        }
        return -1;
    }

    public void setUserParam(int value, String position){
        switch (position){
            case HEIGHT:
                userParamData.put(HEIGHT,value);
                break;
            case WEIGHT:
                userParamData.put(WEIGHT,value);
                break;
            case NECK:
                userParamData.put(NECK,value);
                break;
            case CHEST:
                userParamData.put(CHEST,value);
                break;
            case WAIST:
                userParamData.put(WAIST,value);
                break;
            case HIP_GIRTH:
                userParamData.put(HIP_GIRTH,value);
                break;
            case LEFT_HIP:
                userParamData.put(LEFT_HIP,value);
                break;
            case RIGHT_HIP:
                userParamData.put(RIGHT_HIP,value);
                break;
            case LEFT_BICEPS:
                userParamData.put(LEFT_BICEPS,value);
                break;
            case RIGHT_BICEPS:
                userParamData.put(RIGHT_BICEPS,value);
                break;
            case LEFT_THIGH:
                userParamData.put(LEFT_THIGH,value);
                break;
            case RIGHT_THIGH:
                userParamData.put(RIGHT_THIGH,value);
                break;
            case LEFT_CALF:
                userParamData.put(LEFT_CALF,value);
                break;
            case RIGHT_CALF:
                userParamData.put(RIGHT_CALF,value);
                break;
        }
    }

    public void setUserParam(int value, int position){
        switch (position){
            case 0:
                userParamData.put(HEIGHT,value);
                break;
            case 1:
                userParamData.put(WEIGHT,value);
                break;
            case 2:
                userParamData.put(NECK,value);
                break;
            case 3:
                userParamData.put(CHEST,value);
                break;
            case 4:
                userParamData.put(WAIST,value);
                break;
            case 5:
                userParamData.put(HIP_GIRTH,value);
                break;
            case 6:
                userParamData.put(LEFT_HIP,value);
                break;
            case 7:
                userParamData.put(RIGHT_HIP,value);
                break;
            case 8:
                userParamData.put(LEFT_BICEPS,value);
                break;
            case 9:
                userParamData.put(RIGHT_BICEPS,value);
                break;
            case 10:
                userParamData.put(LEFT_THIGH,value);
                break;
            case 11:
                userParamData.put(RIGHT_THIGH,value);
                break;
            case 12:
                userParamData.put(LEFT_CALF,value);
                break;
            case 13:
                userParamData.put(RIGHT_CALF,value);
                break;
        }
    }
}
