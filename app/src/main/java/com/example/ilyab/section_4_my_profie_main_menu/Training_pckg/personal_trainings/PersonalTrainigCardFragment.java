package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ilyab on 03.05.2017.
 */

public class PersonalTrainigCardFragment extends Fragment implements View.OnClickListener {
    private String title;
    private TextView name_training;
    private EditText edit_description;
    private TextView save_description;
    private Button btn_edit_descript, btn_save_descript, btn_cancel_saving;
    private ImageView edit_pic, save_pic;

    SharedPreferences sPref;
    MainPersonTrainFragment_recycler_v_edit.MainAdapter mAdapter;

    final String SAVED_TEXT = "saved_description";

    public static PersonalTrainigCardFragment newInstance(String title) {
        PersonalTrainigCardFragment fragment = new PersonalTrainigCardFragment();
        fragment.title = title;
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_training_card, container, false);
        name_training = (TextView) view.findViewById(R.id.preview_personal_training_title);
        name_training.setText(title);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        edit_description = (EditText) getActivity().findViewById(R.id.et_personal_training_description);
        save_description = (TextView) getActivity().findViewById(R.id.txt_personal_training_description);
        btn_edit_descript = (Button) getActivity().findViewById(R.id.btn_edit_training_description);
        btn_save_descript = (Button) getActivity().findViewById(R.id.btn_save_training_description);
        btn_cancel_saving = (Button) getActivity().findViewById(R.id.btn_cancel_training_description);
        btn_save_descript.setOnClickListener(this);
        btn_edit_descript.setOnClickListener(this);
        loadText();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_cancel_training_description) {

            btn_edit_descript.setVisibility(View.VISIBLE);
            save_description.setVisibility(View.VISIBLE);
            edit_description.setVisibility(View.INVISIBLE);
            btn_cancel_saving.setVisibility(View.GONE);
            btn_save_descript.setVisibility(View.GONE);
        }
        if (v.getId() == R.id.btn_edit_training_description) {
////            RowModel model = mAdapter.getItemId(pos);
//            model.setDescription(edit_description.toString());
            save_description.setVisibility(View.INVISIBLE);
            edit_description.setVisibility(View.VISIBLE);
            btn_save_descript.setVisibility(View.VISIBLE);
            btn_cancel_saving.setVisibility(View.VISIBLE);
            btn_edit_descript.setVisibility(View.GONE);


        } if (v.getId() == R.id.btn_save_training_description) {

            mAdapter.notifyDataSetChanged();
            btn_edit_descript.setVisibility(View.VISIBLE);
            btn_save_descript.setVisibility(View.GONE);
            btn_cancel_saving.setVisibility(View.GONE);
            saveText();
            sPref = getActivity().getPreferences(MODE_PRIVATE);
            String savedText = sPref.getString(SAVED_TEXT, "");
            save_description.setText(savedText);
            Toast.makeText(getActivity(), "Text loaded", Toast.LENGTH_SHORT).show();
            save_description.setVisibility(View.VISIBLE);
            edit_description.setVisibility(View.INVISIBLE);
        }
        else{

        }

    }

    void saveText() {

        sPref = getActivity().getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, edit_description.getText().toString());
        ed.commit();
        Toast.makeText(getActivity(), "Text saved", Toast.LENGTH_SHORT).show();
    }
    void loadText() {
        sPref = getActivity().getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        save_description.setText(savedText);
        Toast.makeText(getActivity(), "Text loaded", Toast.LENGTH_SHORT).show();
    }


}