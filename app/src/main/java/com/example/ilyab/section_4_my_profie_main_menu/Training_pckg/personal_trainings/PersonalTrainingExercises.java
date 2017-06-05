package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg.Fragment6_3CardExercise;
import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.ExerciseListAdapter;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayExercises;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.google.gson.Gson;

/**
 * Created by ilyab on 02.06.2017.
 */

public class PersonalTrainingExercises extends Fragment {
    public String id;
    private ListView listofexercises;
    private TextView nameOfExercise, sets_value, reps_value, weight_value;
    private ImageView icon_exercise, edit_btn, del_btn;
    Category category;
    Exercise exercise;
    private ExerciseListAdapter adapterList;
    ArrayExercises exercises = new ArrayExercises();

    public static PersonalTrainingExercises newInstance(String id) {
        PersonalTrainingExercises fragment = new PersonalTrainingExercises();
//        fragment.title = title;
        fragment.id = id;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(String.valueOf(id), Context.MODE_PRIVATE);
        String id_saving = sharedPreferences.getString("ID_TR", null);
        Toast.makeText(getContext(), "" + id_saving, Toast.LENGTH_SHORT).show();

        View view = inflater.inflate(R.layout.personal_list_of_exercises, container, false);
        listofexercises = (ListView) view.findViewById(R.id.personal_exercises_that_i_have_chosed);
        icon_exercise = (ImageView) view.findViewById(R.id.main_exercise_img_in_list_i_have_chosen);
        nameOfExercise = (TextView) view.findViewById(R.id.exercise_title_txt_i_have_chosen);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        adapterList = new ExerciseListAdapter(getActivity(), 12);

        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(String.valueOf(id),Context.MODE_PRIVATE);
        String s = sharedPreferences.getString("ID_TR",null);
        if (s != null && !s.equals("")){
            ArrayExercises arrayExercises = gson.fromJson(s,ArrayExercises.class);
            for (Exercise exercise :arrayExercises.getExercises()) {
exercises.setExercises(arrayExercises.getExercises());
            }
            super.onViewCreated(view, savedInstanceState);
        }
        listofexercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
}
