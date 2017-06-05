package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
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

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.google.gson.Gson;

import static com.example.ilyab.section_4_my_profie_main_menu.R.id.btn_fl_save_training_description;

/**
 * Created by ilyab on 03.05.2017.
 */

public class PersonalTrainigCardFragment extends Fragment implements View.OnClickListener {
    private String title;
    private String id;
    private TextView name_training;
    private EditText edit_description;
    private TextView save_description;
    private MenuItem add_exercise;
    private RowModel mRowModel;

    private FloatingActionButton fab_edit, fab_save;
    SharedPreferences sPref;
    MainPersonTrainFragment_recycler_v_edit.MainAdapter mAdapter;

    final String SAVED_TEXT = "saved_description";

    public static PersonalTrainigCardFragment newInstance( String id) {
        PersonalTrainigCardFragment fragment = new PersonalTrainigCardFragment();
//        fragment.title = title;
        fragment.id = id;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_training_card, container, false);
        name_training = (TextView) view.findViewById(R.id.preview_personal_training_title);
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("TRAINING",getActivity().MODE_PRIVATE);
        mRowModel = gson.fromJson(sharedPreferences.getString(id,""),RowModel.class);
//        if (!model.equals("")){
//
//        }


        Log.d("TAG", "onCreateView: rowmodel " + mRowModel.getId()+ " " + id);
        name_training.setText(mRowModel.getMainText());


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        fab_edit = (FloatingActionButton) getActivity().findViewById(R.id.btn_fl_edit_training_description);
        fab_save = (FloatingActionButton) getActivity().findViewById(btn_fl_save_training_description);
        fab_edit.setOnClickListener(this);
        fab_save.setOnClickListener(this);

        edit_description = (EditText) getActivity().findViewById(R.id.et_personal_training_description);
        save_description = (TextView) getActivity().findViewById(R.id.txt_personal_training_description);
//        btn_edit_descript = (Button) getActivity().findViewById(R.id.btn_edit_training_description);
//        btn_save_descript = (Button) getActivity().findViewById(R.id.btn_save_training_description);
//        btn_cancel_saving = (Button) getActivity().findViewById(R.id.btn_cancel_training_description);
//        btn_save_descript.setOnClickListener(this);
//        btn_edit_descript.setOnClickListener(this);
        loadText();


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_fl_edit_training_description:
                edit_description.setVisibility(View.VISIBLE);
                save_description.setVisibility(View.GONE);
                fab_save.setVisibility(View.VISIBLE);
                fab_edit.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Edit Description", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_fl_save_training_description:


                String edittext = String.valueOf(edit_description.getText());
//                RowModel model = id;
              saveText();
                fab_save.setVisibility(View.GONE);
                fab_edit.setVisibility(View.VISIBLE);
                edit_description.setVisibility(View.GONE);
                save_description.setVisibility(View.VISIBLE);
                save_description.setText(edittext);

                break;

        }

    }

    void saveText() {

        Gson gson = new Gson();
        mRowModel.setDescription(String.valueOf(edit_description.getText()));
        String model = gson.toJson(mRowModel,RowModel.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("TRAINING",getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(id,model);
        editor.commit();
//        sPref = getActivity().getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor ed = sPref.edit();
//        ed.putString(SAVED_TEXT, edit_description.getText().toString());
//        ed.commit();
        Toast.makeText(getActivity(), "Description is saved", Toast.LENGTH_SHORT).show();
    }
    void loadText() {
//        sPref = getActivity().getPreferences(MODE_PRIVATE);
        String savedText;

        try {
            savedText = mRowModel.getDescription();

        }catch (Exception e){
            savedText = "Enter description";

        }
        save_description.setText(savedText);
        edit_description.setText(savedText);
        Toast.makeText(getActivity(), "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_add_exercises_to_training:
//                android.support.v4.app.FragmentTransaction t = getFragmentManager().beginTransaction();
//                Fragment mFrag = new MyProfileFragment_7_2();
//                t.replace(R.id.container_main, new MyProfileFragment_7_2());
//                t.commit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_exercises_to_personal_tra_from_card, menu);
        add_exercise = menu.findItem(R.id.menu_add_exercises_to_training);
        super.onCreateOptionsMenu(menu, inflater);
    }
}