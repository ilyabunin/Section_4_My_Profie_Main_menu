package com.example.ilyab.section_4_my_profie_main_menu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.models.User;
import com.example.ilyab.section_4_my_profie_main_menu.styles_and_references.InputFilterMinMax;

import java.util.Map;


public class MyProfileFragment7_1 extends Fragment  {

    RadioGroup radioGroup;

    ListView list;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private ImageView boy_avatar, girl_avatar;
    private RadioGroup gender_check;

    final String LOG_TAG = "myLogs";
    private MenuItem infoMenu, backMenu;
    RoundImage roundedImage;
    public static final String APP_PREFERENCES = "mysettings";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    private ListView saveListView;


    String[] users_params = {
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

    String[] input_text = {
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit",
            "Edit"
    };
    String[] goals = {
            "Weight loss",
            "Muscle Mass",
            "Bodybuilding",
            "Relief",
            "Fitness",
            "Health improvement",
    };
    Integer[] imageId = {
            R.drawable.ic_ruler,
            R.drawable.ic_scale,
            R.drawable.ic_human_neck,
            R.drawable.ic_men_chest,
            R.drawable.ic_female_gymnast_measuring_her_waist,
            R.drawable.ic_women_buttock,
            R.drawable.ic_male_hips_and_quadriceps,
            R.drawable.ic_male_hips_and_quadriceps,
            R.drawable.ic_biceps,
            R.drawable.ic_biceps,
            R.drawable.ic_men_knee,
            R.drawable.ic_men_knee,
            R.drawable.ic_men_leg,
            R.drawable.ic_men_leg

    };

    private User currentUser;


    @Override
    public void onCreate(Bundle savedInstanceState) {

//
//

        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    private User loadUser() {
        SharedPreferences sPref = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
        User user = new User();
        Map<String, ?> userParams = sPref.getAll();
        if (users_params.length > 0) {
            for (Map.Entry<String, ?> entry : userParams.entrySet()) {
                user.setUserParam((Integer) entry.getValue(), entry.getKey());
            }
        }
        return user;
    }

    private void saveUser() {
        SharedPreferences sPref = getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        Map<String, Integer> userParams = currentUser.getUserParamData();
        for (Map.Entry<String, Integer> entry : userParams.entrySet()) {
            editor.putInt(entry.getKey(), entry.getValue());
        }
        editor.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onStart();
        currentUser = loadUser();
        Log.d(LOG_TAG, "On start My profile");
        final SharedPreferences myPrefs = getContext().getSharedPreferences("general", getContext().MODE_PRIVATE);
        final SharedPreferences listPref = getContext().getSharedPreferences("list", getContext().MODE_PRIVATE);

//        Log.d(LOG_TAG, "On create My profile Fragment 7_1 View");
        View view = inflater.inflate(R.layout.myprofile_7_1, container, false);

        final ImageView boy_avatar = (ImageView) view.findViewById(R.id.users_avatar_boy);
        final ImageView girl_avatar = (ImageView) view.findViewById(R.id.users_avatar_girl);
        RadioButton boy_checkbox = (RadioButton) view.findViewById(R.id.boy_radio_btn);
        RadioButton girl_checkbox = (RadioButton) view.findViewById(R.id.girl_radio_btn);
        RadioGroup gender_check = (RadioGroup) view.findViewById(R.id.checkbox_gender_group);

        gender_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                // find which radio button is selected
                if (checkedId == R.id.boy_radio_btn) {
                    boy_avatar.setVisibility(View.VISIBLE);
                    girl_avatar.setVisibility(View.GONE);
                    //save in preferences
                    myPrefs.edit().putInt("selected", 1).commit();

                } else if (checkedId == R.id.girl_radio_btn) {
                    boy_avatar.setVisibility(View.GONE);
                    girl_avatar.setVisibility(View.VISIBLE);

                    myPrefs.edit().putInt("selected", 2).commit();
                }
            }

        });

//check if there is any value in preferences and set accordingly

        int s = myPrefs.getInt("selected", 0);   //will return 0 when nothing is stored
        if (s == 1) {
            boy_checkbox.setChecked(true);
        } else if (s == 2) {
            girl_checkbox.setChecked(true);
        }
        final Spinner goals_spinner = (Spinner) view.findViewById(R.id.users_goal_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, goals);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        goals_spinner.setAdapter(dataAdapter);
        goals_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());  //context
            SharedPreferences.Editor prefEditor = prefs.edit();
            prefEditor.putString("savedValue",goals_spinner.getSelectedItem().toString());
            prefEditor.commit();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        });
        String savedValue = PreferenceManager
                .getDefaultSharedPreferences(getActivity().getBaseContext()) //context
                .getString("savedValue", "");
        for (int i = 0; i <6; i++)
            if (savedValue.equals(goals_spinner.getItemAtPosition(i).toString())) {
                goals_spinner.setSelection(i);
                break;

            }
        return view;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.fr1_menu_profile:
                android.support.v4.app.FragmentTransaction t = getFragmentManager().beginTransaction();
                Fragment mFrag = new MyProfileFragment_7_2();
                t.replace(R.id.container_main, new MyProfileFragment_7_2());
                t.commit();
                return true;
            case R.id.action_menu_profile_back:


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        final CustomUserInfoList adapter = new
                CustomUserInfoList(getActivity(), currentUser, imageId);
        list = (ListView) view.findViewById(R.id.my_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(final AdapterView<?> parent, final View view,
                                    final int position, long rowId) {
                final AlertDialog.Builder inputAlert = new AlertDialog.Builder(getActivity());

                inputAlert.setMessage("Type value of " + users_params[position]);
                final EditText userInput = new EditText(getActivity());

                int maxLength = 3;

                InputFilter[] FilterArray = new InputFilter[1];
                FilterArray[0] = new InputFilter.LengthFilter(maxLength);

                userInput.setInputType(1234567890);

                userInput.setFilters(FilterArray);
               userInput.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "300")});
                inputAlert.setView(userInput);



                inputAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(userInput.length() < 1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(), "Please enter Minimum 1 symbol", Toast.LENGTH_LONG).show();
                            return;
                        }
                        else  {

                        currentUser.setUserParam(Integer.valueOf(userInput.getText().toString()), position);
                        adapter.updateUser(currentUser);
                        saveUser();

                        }
                    }
                });
                inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = inputAlert.create();
                alertDialog.show();


            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(LOG_TAG, "On activity result My profile Fragment 7_1");

        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_1, menu);
        infoMenu = menu.findItem(R.id.fr1_menu_profile);
        backMenu = menu.findItem(R.id.fr1_menu_profile_back);
        super.onCreateOptionsMenu(menu, inflater);
    }



}




