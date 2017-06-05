package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.ExerciseListAdapter;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayCategory;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayExercises;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * Created by Max on 07.03.2017.
 */

public class Fragment6_2ListExercisesForCategory extends android.support.v4.app.Fragment implements View.OnClickListener {
    ArrayCategory arrayCategory = new ArrayCategory();
    private ListView listViewCategories;
    private ExerciseListAdapter adapterList;
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    private TextView textView;
    private FragmentTransaction transaction;
    private ListExercisesForCategory listener;
    public String id_saving_to_sp;

    private Button addToWrkt,deleteWork;
    int keyVisible;

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




        Bundle bundle = getArguments();
        String str1 = bundle.getString("NAME");
        Bundle bundle1 = getArguments();
        if (bundle1 != null) {
            keyVisible = bundle.getInt("VISIBLE");
        }
        adapterList = new ExerciseListAdapter(getActivity(),keyVisible);

        Gson gson = new Gson();

        category = gson.fromJson(str1, Category.class);
        for (Exercise exercie : category.getExercises()) {
            adapterList.addExercise(exercie);
            Log.d("TAG", "onCreateView: ");
        }
//

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedPreferences  = getActivity().getSharedPreferences("ID_OF_ROW", Context.MODE_PRIVATE);
String id_saving = sharedPreferences.getString("ID_VALUE",null);




        View view = inflater.inflate(R.layout.fragment6_2, container, false);

        textView = (TextView) view.findViewById(R.id.category_value_name6_2_txt);
        listViewCategories = (ListView) view.findViewById(R.id.categories_map6_2);
        img_exercise = (ImageView) view.findViewById(R.id.main_exercise_img_in_list);


        addToWrkt = (Button) view.findViewById(R.id.add_to_workout_btn);
        addToWrkt.setOnClickListener(this);
        deleteWork = (Button) view.findViewById(R.id.delete_workout_btn);
        deleteWork.setOnClickListener(this);
        Log.d("TAG", "onCreateView: categori" + category.getExercises().size());
        textView.setText(category.getData());
        listViewCategories.setAdapter(adapterList);

        Toast.makeText(getContext(), "ID OF ROW:" +id_saving, Toast.LENGTH_SHORT).show();
id_saving_to_sp = id_saving;
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Log.i("GETFRAGMENT","FRAGMENT");
        if (keyVisible == 12){

            addToWrkt.setVisibility(View.VISIBLE);

//            checked_exercises.setVisibility(View.GONE);
        }
        Toast toast = Toast.makeText(getActivity(),
                "CODE:" +keyVisible,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
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
            ArrayList<Exercise> exercises = new ArrayList<>();
            for (int i = 0; i < adapterList.getCount(); i++) {
                Exercise exercise = (Exercise) adapterList.getItem(i);
                if (exercise.isBox()){
                    exercises.add(exercise);
                }


               if(exercise.isBox()){
                    Toast.makeText(getActivity(), "You've add " +exercises.size() +" exercise(s) to your workout ", Toast.LENGTH_SHORT).show();
                }

              else  if(exercises.size()<1){
                    Toast.makeText(getActivity(), "You haven't chosen any exercises", Toast.LENGTH_SHORT).show();
                }
//else {
//                    Toast.makeText(getActivity(), "You have add  " + exercises.size() +" exercises", Toast.LENGTH_SHORT).show();
//                }
            }



            Gson gson = new Gson();
            ArrayExercises arrayExercises = new ArrayExercises();
            arrayExercises.setExercises(exercises);
            String myExersises = gson.toJson(arrayExercises, ArrayExercises.class);
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(String.valueOf(id_saving_to_sp), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("ID_TR",myExersises);


            editor.commit();
        }
        if (v.getId() == R.id.delete_workout_btn){
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MY_PERSONAL_CATEGORY",Context.MODE_PRIVATE);
            String s = sharedPreferences.getString("MY_PERS_EXER","");
            if (s != null && !s.equals("")){
                ArrayExercises arrayExercises = gson.fromJson(s,ArrayExercises.class);
                for (Exercise exercise :arrayExercises.getExercises()) {

                }
            }
        }

    }

    public interface ListCategoryListener {
        void listAllExercises();
    }


}