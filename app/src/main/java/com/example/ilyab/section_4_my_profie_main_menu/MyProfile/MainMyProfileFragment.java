package com.example.ilyab.section_4_my_profie_main_menu.MyProfile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ilyab.section_4_my_profie_main_menu.MyProfileFragment7_1;
import com.example.ilyab.section_4_my_profie_main_menu.MyProfileFragment_7_2;
import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.RoundImage;

public class MainMyProfileFragment extends AppCompatActivity  {
    private ImageView boy_avatar, girl_avatar;
   private RadioGroup gender_check;
   private RadioButton boy_checkbox, girl_checkbox;
    final Context context = this;
    final String LOG_TAG = "myLogs";
    private MenuItem infoMenu, backMenu;
    RoundImage roundedImage;

    // это будет именем файла настроек
    public static final String APP_PREFERENCES = "mysettings";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main_menu);
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_main, new MyProfileFragment7_1());
        transaction.commit();

        super.onCreate(savedInstanceState);

    }
    RadioGroup.OnCheckedChangeListener radioGroupOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton checkedRadioButton = (RadioButton) gender_check
                    .findViewById(checkedId);
            int checkedIndex = gender_check.indexOfChild(checkedRadioButton);
            if(checkedId == R.id.boy_radio_btn){
                boy_avatar.setVisibility(View.VISIBLE);
                girl_avatar.setVisibility(View.GONE);
                SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);

            }
            else if(checkedId == R.id.girl_radio_btn){
                boy_avatar.setVisibility(View.GONE);
                girl_avatar.setVisibility(View.VISIBLE);
                SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);

            }
        }
    };

    private void SavePreferences(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) gender_check
                .getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        switch (buttonView.getId()){
//            case R.id.boy_radio_btn:
//                if(isChecked == true) {
//
//                    boy_avatar.setVisibility(View.VISIBLE);
//                    girl_avatar.setVisibility(View.GONE);
//                    saveRadioButtons();
//                }break;
//            case R.id.girl_radio_btn:
//                if(isChecked == true) {
//
//                    boy_avatar.setVisibility(View.GONE);
//                    girl_avatar.setVisibility(View.VISIBLE);
//                    saveRadioButtons();
//                }break;
//
//        }
//    }
    @Override
    protected void onStart() {
        boy_avatar = (ImageView) findViewById(R.id.users_avatar_boy);
        girl_avatar = (ImageView) findViewById(R.id.users_avatar_girl);
        boy_checkbox = (RadioButton) findViewById(R.id.boy_radio_btn);
        girl_checkbox = (RadioButton) findViewById(R.id.girl_radio_btn);
        gender_check = (RadioGroup) findViewById(R.id.checkbox_gender_group);
        gender_check
                .setOnCheckedChangeListener(radioGroupOnCheckedChangeListener);

        LoadPreferences();
        super.onStart();
        Log.d(LOG_TAG, "On start My profile");
    }

    @Override
    protected void onRestart() {
        LoadPreferences();
        super.onRestart();

        Log.d(LOG_TAG, "On restart My profile");
    }

    @Override
    protected void onPause() {
        LoadPreferences();
        super.onPause();
        Log.d(LOG_TAG, "On pause My profile");

    }

    @Override
    protected void onResume() {
        LoadPreferences();
        super.onResume();
        Log.d(LOG_TAG, "On resume My profile");
    }

    @Override
    protected void onDestroy() {

        LoadPreferences();
        Log.d(LOG_TAG, "On destroy");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        LoadPreferences();
        super.onStop();
        Log.d(LOG_TAG, "On stop My profile");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_menu_profile:

                Fragment newFragment = new Fragment();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, new MyProfileFragment_7_2());
                fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
                fragmentTransaction.commit();
                return true;
            case R.id.action_menu_profile_back:

                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


        public void saveRadioButtons(){
            SharedPreferences settings = getSharedPreferences("LEVEL", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("MAN", boy_checkbox.isChecked()); // first argument is a
            editor.putBoolean("GIRL", boy_checkbox.isChecked()); // first argument is a

            editor.commit(); // Commit the changes
        }
    public void loadRadioButtons(){
        SharedPreferences settings = getSharedPreferences("LEVEL", 0);
        boolean isChk= settings.getBoolean("MAN", false);
    }



}






