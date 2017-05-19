package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static void makeToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static void makeToast(Context context, String message, int duration){
        Toast.makeText(context, message, duration).show();
    }
}
