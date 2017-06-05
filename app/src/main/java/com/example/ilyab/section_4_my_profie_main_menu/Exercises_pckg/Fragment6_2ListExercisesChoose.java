package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.ExerciseListAdapter;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayCategory;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * Created by Max on 07.03.2017.
 */

public class Fragment6_2ListExercisesChoose extends android.support.v4.app.Fragment implements View.OnClickListener {
    ArrayCategory arrayCategory = new ArrayCategory();
    private ListView listViewCategories;
    private ExerciseListAdapter adapterList;
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    private TextView textView;
    private FragmentTransaction transaction;
    private ListExercisesForCategory listener;
    private CheckBox checked_exercises;
    private Button addToWrkt;
    int recieve_visible;

    private ImageView img_exercise;

    Category category;
    Exercise exercie;

    String[] dataEx = {"Упражнение №1", " Упражнение №2", " Упражнение №3"};
    ArrayList data;

    public void setListExercisesForCategory(ListExercisesForCategory listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        adapterList = new ExerciseListAdapter(getActivity(),1);
        Bundle bundle = getArguments();
        String str1 = bundle.getString("NAME");
        Gson gson = new Gson();

        category = gson.fromJson(str1, Category.class);
        for (Exercise exercie : category.getExercises()) {
            exercie.setBox(false);
            adapterList.addExercise(exercie);
            Log.d("TAG", "onCreateView: ");
        }
//

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Bundle bundle = getArguments();
        if (bundle != null) {
            recieve_visible = bundle.getInt("VISIBLE");



        }
        View view = inflater.inflate(R.layout.fragment6_2, container, false);
        textView = (TextView) view.findViewById(R.id.category_value_name6_2_txt);
        listViewCategories = (ListView) view.findViewById(R.id.categories_map6_2);
        img_exercise = (ImageView) view.findViewById(R.id.main_exercise_img_in_list);

        addToWrkt = (Button) view.findViewById(R.id.add_to_workout_btn);
        addToWrkt.setOnClickListener(this);

        Log.d("TAG", "onCreateView: category" + category.getExercises().size());
        textView.setText(category.getData());
        listViewCategories.setAdapter(adapterList);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {



        Log.i("GETFRAGMENT","FRAGMENT");

        listViewCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Exercise exercise = (Exercise) adapterList.getItem(position);
                Toast.makeText(getActivity(), "Pos : " + position, Toast.LENGTH_SHORT).show();

                Fragment6_3CardExercise fragment = new Fragment6_3CardExercise();


                Exercise exercise1 = new Exercise();
                exercise1 = exercise;
                Bundle bundle = new Bundle();
                Gson gson = new Gson();
                bundle.putString("NAME", gson.toJson(exercise, Exercise.class));
                fragment.setArguments(bundle);


                FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_main, fragment);
                fragmentTransaction.addToBackStack("REPLACE_TO_PROFILE");
                fragmentTransaction.commit();
            }
        });
    }

    public interface ListExercisesForCategory {



        void listExercisesForCategory();

    }

//    public List<Exercise> getList() {
//        for(int i = 0;i<adapterList.getCount()-1;i++){
//            if(adapterList.getExercises().get(i).mCheckBox.isChecked()){
//                exercises.add(adapterList.getExercises().get(i));
//            }
//
//        }
//       return exercises;
//    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_to_workout_btn) {


        }
    }

    public interface ListCategoryListener {
        void listAllExercises();
    }


}