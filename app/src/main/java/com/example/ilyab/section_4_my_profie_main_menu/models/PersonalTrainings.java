package com.example.ilyab.section_4_my_profie_main_menu.models;

import java.util.ArrayList;

/**
 * Created by ilyab on 03.05.2017.
 */

public class PersonalTrainings {

private String data_name_personal_training;
    ArrayList<PersonalTrainings> perstrainings;

    public PersonalTrainings(String data_name_personal_training, ArrayList<PersonalTrainings> perstrainings) {
        this.data_name_personal_training = data_name_personal_training;
        this.perstrainings = perstrainings;
    }

    public String getData_name_personal_training() {
        return data_name_personal_training;
    }

    public void setData_name_personal_training(String data_name_personal_training) {
        this.data_name_personal_training = data_name_personal_training;
    }

    public ArrayList<PersonalTrainings> getPerstrainings() {
        return perstrainings;
    }

    public void setPerstrainings(ArrayList<PersonalTrainings> perstrainings) {
        this.perstrainings = perstrainings;
    }
}