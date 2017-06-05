package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.CategoryMapAdapter;
import com.example.ilyab.section_4_my_profie_main_menu.models.Data;
import com.example.ilyab.section_4_my_profie_main_menu.models.DescriptionExercises;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by Max on 09.03.2017.
 */

public class Fragment6_3CardExercise extends android.support.v4.app.Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {
    private FragmentTransaction transaction;
    private TextView nameExercise, descriptonExercise;
    private CategoryMapAdapter adapterMap;
    private SliderLayout imageSlider;
    private TextView paramSets, paramReps, paramsWeight;
    private EditText etParamSets, etParamReps, etParamsWeight;
    Exercise exercise;
    DescriptionExercises descriptionExercises1 = new DescriptionExercises();
    Data data = new Data();
    ListExercises listener;
    HashMap<String,Integer> images;
    public void setListExercises(ListExercises listener) {
        this.listener = listener;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle bundle = getArguments();
        String str1 = bundle.getString("NAME");
        Gson gson = new Gson();
        exercise = gson.fromJson(str1, Exercise.class);

//        Bundle bundle = getArguments();
//        String str1 = bundle.getString("NAME");
//        Gson gson = new Gson();
//        category = gson.fromJson(str1, Category.class);
//        for (Exercise exercie:category.getExercises()) {
//            adapterList.addExercise(exercie);
//            Log.d("TAG", "onCreateView: ");
//        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_card_exercise_6_3, menu);

        final MenuItem item = menu.findItem(R.id.add_card_item);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_6_3_new, null);
        nameExercise = (TextView) view.findViewById(R.id.name_exercise_6_3);

        descriptonExercise = (TextView) view.findViewById(R.id.txt_description_in_exercise);

        nameExercise.setText(exercise.getData());


        descriptonExercise.setMovementMethod(new ScrollingMovementMethod());


        String ar = null;
        for (DescriptionExercises exercie1:exercise.getDescriptions()) {
           ar = exercie1.getData();
            Log.d("TAG", "onCreateView: ");
        }
        images = exercise.getImages();
        descriptonExercise.setText(ar);
        imageSlider = (SliderLayout) view.findViewById(R.id.slider_new_img);
        paramSets = (TextView) view.findViewById(R.id.txt_sets_in_exercise);
        paramReps = (TextView) view.findViewById(R.id.txt_sets_in_exercise);
        paramsWeight = (TextView) view.findViewById(R.id.txt_weight_sets_in_exercise);
        paramSets.setOnClickListener(this);
        paramReps.setOnClickListener(this);
        paramsWeight.setOnClickListener(this);
        etParamSets = (EditText) view.findViewById(R.id.et_sets_in_exercise);
        etParamReps = (EditText) view.findViewById(R.id.et_reps_in_exercise);
        etParamsWeight = (EditText) view.findViewById(R.id.et_weight_sets_in_exercise);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
////        file_maps.put("1", R.mipmap.exercise_1); //вместо первого поля можно давать комментарий или описание
////        file_maps.put("2", R.mipmap.exercise_2);
////        file_maps.put("3", R.mipmap.exercise_3);
////        file_maps.put("4", R.mipmap.exercise_4);

        for (String name : images.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .image(images.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            imageSlider.addSlider(textSliderView);
        }
        imageSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageSlider.setDuration(1000);
        imageSlider.addOnPageChangeListener(this);


        super.onViewCreated(view, savedInstanceState);
    }

    TextSliderView textSliderView = new TextSliderView(getActivity());

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onClick(View v) {

    }
    public interface ListExercises{
    }
}