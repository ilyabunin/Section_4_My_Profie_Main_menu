package com.example.ilyab.section_4_my_profie_main_menu;


import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ilyab.section_4_my_profie_main_menu.Else_pckg.MainElseFragment;
import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.Example6_1Fragment;
import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.Fragment6ListAllCategory;
import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.Fragment6_2ListExercisesForCategory;
import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.Fragment6_3CardExercise;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.MainTrainingFragment;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings.MainPersonTrainFragment_recycler_v_edit;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayCategory;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Data;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.example.ilyab.section_4_my_profie_main_menu.motiv_gym_feed.MotivationFeedFragment;
import com.google.gson.Gson;
import com.nikhilpanju.recyclerviewenhanced.OnActivityTouchListener;

import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Fragment6ListAllCategory.CategoryListAllListener, Example6_1Fragment.ListCategoryListener, Fragment6_3CardExercise.ListExercises, Fragment6_2ListExercisesForCategory.ListExercisesForCategory, MainPersonTrainFragment_recycler_v_edit.AddToWorkOut {
    private boolean viewIsAtHome;
    private OnActivityTouchListener touchListener;
Fragment6ListAllCategory frag5;
    FragmentTransaction transaction;
    private FrameLayout frameLayout;
    private int visivble;
    Fragment6_2ListExercisesForCategory fragment;

    Data data = new Data();
    List<Exercise> mList;
    ArrayCategory arrayCategory = new ArrayCategory();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Category category = new Category();
        frag5 = new Fragment6ListAllCategory();
        frag5.setListener(this);
        data.addImageCategory();
        data.addExercise();
        data.addDescription();
        data.addImages();
        data.addImageExercise();
        arrayCategory = data.getArrayCategory();
        Gson gson = new Gson();
        String str = gson.toJson(arrayCategory, ArrayCategory.class);
        SharedPreferences sharedPreferences = getSharedPreferences("DATABASE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CATEGORYS", str);
        editor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.container_main);


               Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displayView(R.id.nav_exercise);

    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        }
//        if (!viewIsAtHome) { //if the current view is not the News fragment
//            displayView(R.id.nav_feed); //display the News fragment
//        } else {
//            moveTaskToBack(true);  //If view is in News fragment, exit application
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displayView(item.getItemId());
        return true;

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        android.app.Fragment frag = getFragmentManager().findFragmentByTag("PERSONAL_FRAG_TAG");
        if (touchListener != null) touchListener.getTouchCoordinates(ev);
        return super.dispatchTouchEvent(ev);

    }

    public void displayView(int viewId) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_main);
        Fragment6ListAllCategory frag6 = new Fragment6ListAllCategory();
        String title = getString(R.string.app_name);
        switch (viewId) {
            case R.id.nav_feed:
                getSupportActionBar().setTitle("Gym's news feed");
                fragment =  new MotivationFeedFragment();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).commit();

                break;
            case R.id.nav_work_out:
                getSupportActionBar().setTitle("My Workout");
                fragment =  new MainTrainingFragment();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).commit();
                break;
            case R.id.nav_exercise:
                getSupportActionBar().setTitle("My Exercises");
                title = "My Exercises";
                Bundle bundle = new Bundle();
                bundle.putInt("VISIBLE", 5);
                frag5.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.container_main, frag5).commit();





                break;
            case R.id.nav_profile:
                getSupportActionBar().setTitle("My Profile");
                title = "My Exercises";
                fragment = new MyProfileFragment7_1();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_EXERCISE").commit();

                break;
            case R.id.nav_else:
                getSupportActionBar().setTitle("Settings and customisation");
                title = "Settings and customisation";

                fragment =  new MainElseFragment();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();

                break;

        }



        // set the toolbar title
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("My Toolbar");
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }


    @Override
    public void categorySelected() {
        Example6_1Fragment frag = new Example6_1Fragment();
        frag.setListListener(this);
       FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main, frag);
        fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
//        fragmentTransaction.commit();
        Gson gson = new Gson();
        String str = gson.toJson(arrayCategory, ArrayCategory.class);
        SharedPreferences sharedPreferences = getSharedPreferences("DATABASE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CATEGORYS", str);
        editor.commit();
        fragmentTransaction.commit();
    }

    @Override
    public void listAllExercisesSelect(Category category, int recieve_visible) {

        fragment = new Fragment6_2ListExercisesForCategory();
        fragment.setListExercisesForCategory(this);

        Category category1 = new Category();
        category1 = category;
        Bundle bundle = new Bundle();
        Gson gson = new Gson();
        bundle.putString("NAME", gson.toJson(category1, Category.class));
        bundle.putInt("VISIBLE",recieve_visible);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main, fragment);
        fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
        fragmentTransaction.commit();
    }

    @Override
    public void listAllExercises() {

    }

    @Override
    public void cardForExercise(Exercise exercise) {
        Fragment6_3CardExercise fragment6_3CardExercise = new Fragment6_3CardExercise();
        fragment6_3CardExercise.setListExercises(this);
        Bundle bundle = new Bundle();
        Gson gson = new Gson();
        bundle.putString("NAME", gson.toJson(exercise, Exercise.class));


        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main, fragment6_3CardExercise);
        fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
        fragmentTransaction.commit();
    }

    @Override
    public void listExercisesForCategory() {

    }

    @Override
    public void addtoWorkout() {

        Bundle bundle = new Bundle();
        bundle.putInt("VISIBLE", 12);
        frag5.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_main, frag5).addToBackStack("REPLACE_TO_PROFILE").commit();

    }
    public void addIdRow(){

    }
}
