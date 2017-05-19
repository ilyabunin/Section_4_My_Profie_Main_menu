package com.example.ilyab.section_4_my_profie_main_menu;


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

import com.example.ilyab.section_4_my_profie_main_menu.Else_pckg.MainElseFragment;
import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.MainExercisesFragment;
import com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.MainTrainingFragment;
import com.example.ilyab.section_4_my_profie_main_menu.motiv_gym_feed.MotivationFeedFragment;
import com.nikhilpanju.recyclerviewenhanced.OnActivityTouchListener;
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,RecyclerTouchListener.RecyclerTouchListenerHelper  {
    private boolean viewIsAtHome;
    private OnActivityTouchListener touchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                getSupportActionBar().setTitle("My Profile");
                title = "My Exercises";
                fragment = new MainExercisesFragment();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment, "PERSONAL_FRAG_TAG").addToBackStack("REPLACE_TO_PROFILE").commit();


                break;
            case R.id.nav_profile:
                getSupportActionBar().setTitle("My Profile");
                title = "My Exercises";
                fragment = new MyProfileFragment7_1();
                fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();

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
    public void setOnActivityTouchListener(OnActivityTouchListener listener) {
        this.touchListener = listener;
    }
}
