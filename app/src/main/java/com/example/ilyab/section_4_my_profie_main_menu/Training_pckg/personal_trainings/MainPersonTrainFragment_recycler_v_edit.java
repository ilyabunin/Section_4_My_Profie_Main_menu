package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.nikhilpanju.recyclerviewenhanced.OnActivityTouchListener;
import com.nikhilpanju.recyclerviewenhanced.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by ilyab on 06.05.2017.
 */

public class MainPersonTrainFragment_recycler_v_edit extends Fragment implements RecyclerTouchListener.RecyclerTouchListenerHelper, View.OnClickListener {
    private AlertDialog.Builder alertDialog;
    private EditText et_personal_trainings_name;
    RecyclerView mRecyclerView;
    private TextView name_personal_training, no_training;
    private TextView descript_personal_training, id_recycler;
    MainAdapter mAdapter;
    String[] dialogItems;
    List<Integer> unclickableRows, unswipeableRows;
    private EditText et_personal_trainings_description;
    private boolean add = false;
    private int edit_position;
    private int openOptionsPosition;
    private OnActivityTouchListener touchListener;
    private RecyclerTouchListener onTouchListener;
    private Paint p = new Paint();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        SharedPreferences trainings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        View view = inflater.inflate(R.layout.workout_personal_trainings, container, false);
        return view;


     }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mRecyclerView.addOnItemTouchListener(onTouchListener);
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {



        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_personal_trainings);
        fab.setOnClickListener(this);
        name_personal_training = (TextView) getActivity().findViewById(R.id.mainText);
        descript_personal_training = (TextView) getActivity().findViewById(R.id.subText);
no_training = (TextView) getActivity().findViewById(R.id.txt_personal_trainings_no_workout);

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.card_recycler_view);
        mAdapter = new MainAdapter(getActivity(), getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        onTouchListener = new RecyclerTouchListener(getActivity(), mRecyclerView);
        onTouchListener
                .setIndependentViews(R.id.rowButton)
                .setViewsToFade(R.id.rowButton)
                .setClickable(new RecyclerTouchListener.OnRowClickListener() {
                    @Override
                    public void onRowClicked(int position) {
                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Row " + getId() + " clicked!");
                        Log.d("MY_TAG", "onRowClicked: " + mAdapter.getItem(position).getId());
//                        (position + 1)
                    }

                    @Override
                    public void onIndependentViewClicked(int independentViewID, int position) {
                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Button in row " + (position + 1) + " clicked!");
                        FragmentManager fragmentManager = getFragmentManager();
                        Fragment fragment = getFragmentManager().findFragmentById(R.id.container_main);
                        RowModel rowModel = mAdapter.modelList.get(position);
                        fragment = PersonalTrainigCardFragment.newInstance(rowModel.getMainText());
                        fragmentManager.beginTransaction().replace(R.id.container_main, fragment).addToBackStack("REPLACE_TO_PROFILE").commit();

                    }
                })
                .setLongClickable(true, new RecyclerTouchListener.OnRowLongClickListener() {
                    @Override
                    public void onRowLongClicked(int position) {
                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Row " + (position + 1) + " long clicked!");
                    }
                })
                .setSwipeOptionViews(R.id.add, R.id.edit, R.id.change)
                .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, final int position) {
                        String message = "";
                        if (viewID == R.id.add) {

                            message += "Add Exercises";
                        } else if (viewID == R.id.edit) {
                            alertDialog = new AlertDialog.Builder(getActivity());
                            final View view = getActivity().getLayoutInflater().inflate(R.layout.alertdialog_personal_training_name_description, null);
                            et_personal_trainings_name = (EditText) view.findViewById(R.id.name_of_training_alert_d);
                            et_personal_trainings_description = (EditText) view.findViewById(R.id.description_of_training_alert_d);
                            name_personal_training = (TextView) getView().findViewById(R.id.mainText);
                            descript_personal_training = (TextView) getView().findViewById(R.id.subText);
                            alertDialog.setMessage("Edit Training info");
                            alertDialog.setView(view);


                            alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    if (et_personal_trainings_name.length() < 1) {
                                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Type minimum 1 Symbol");

                                        return;

                                    }

                                    else if (et_personal_trainings_name.length() > 30){
                                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Maximum size of name is 30 symbols");
                                    }
                                    else if (et_personal_trainings_description.length() > 40){
                                        ToastUtil.makeToast(getActivity().getApplicationContext(), "Maximum size of notes is 40 symbols");
                                    }
                                    else {
                                        String et_name = et_personal_trainings_name.getText().toString();
                                        String et_description = et_personal_trainings_description.getText().toString();

                                        RowModel model = mAdapter.getItem(position);
                                        model.setMainText(et_name);
                                        model.setSubText(et_description);
                                        SharedPreferences sPref = getActivity().getSharedPreferences("TRAINING", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sPref.edit();
                                        editor.putString(model.getId(),model.toString());
                                        editor.commit();
                                        mAdapter.notifyItemChanged(position);
                                        dialog.dismiss();

                                    }
                                }


                            });
                            alertDialog.show();


                        } else if (viewID == R.id.change) {
                            message += "Delete Training";

                            // delTraining();
                            removeItem(position);
                        }
                        message += " clicked for row " + (position + 1);
                        ToastUtil.makeToast(getActivity().getApplicationContext(), message);
                    }
                });
        super.onViewCreated(view, savedInstanceState);
        if (mAdapter.modelList.isEmpty()){
            getActivity().findViewById(R.id.txt_personal_trainings_no_workout).setVisibility(View.GONE);

        }
    }


    private List<RowModel> getData() {

        List<RowModel> list = new ArrayList<>(1);
        //        for (int i = 0; i < 1; i++) {
        //            list.add(new RowModel("My personal training " + (i + 1), "Description... "));

        //        }
        SharedPreferences sPref = getActivity().getSharedPreferences("TRAINING", Context.MODE_PRIVATE);
        Map<String, ?> allTraining = sPref.getAll();

        for (Map.Entry entry : allTraining.entrySet()) {
            RowModel rowModel = RowModel.newInstance(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            list.add(rowModel);

        }
        Collections.sort(list, new Comparator<RowModel>() {
            @Override
            public int compare(RowModel obj1, RowModel obj2) {
                return obj1.getId().compareToIgnoreCase(obj2.getId()); // To compare string values
            }
        });
        return list;
    }
    @Override
    public void setOnActivityTouchListener(OnActivityTouchListener listener) {
        this.touchListener = listener;
    }


    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        LayoutInflater inflater;
        List<RowModel> modelList;

        public MainAdapter(Context context, List<RowModel> list) {
            inflater = LayoutInflater.from(context);
            modelList = new ArrayList<>(list);
        }


        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.row_personal_training, parent, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            holder.bindData(modelList.get(position));


        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

        public void addDescript(RowModel subText) {
            modelList.add(subText);
            notifyItemInserted(modelList.size());

        }

        public RowModel getItem(int position) {
            return modelList.get(position);
        }



        class MainViewHolder extends RecyclerView.ViewHolder {

            TextView mainText, subText;

            public MainViewHolder(View itemView) {
                super(itemView);
                mainText = (TextView) itemView.findViewById(R.id.mainText);
                subText = (TextView) itemView.findViewById(R.id.subText);
            }


            public void bindData(RowModel rowModel) {
                mainText.setText(rowModel.getMainText());
                subText.setText(rowModel.getSubText());
            }


        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fab_personal_trainings:
                for (int i = 0; i < 1; i++) {

                    RowModel rowModel = new RowModel("My personal training " + (mAdapter.modelList.size() + 1), "Note... ","");
                    mAdapter.modelList.add(rowModel);
                    mAdapter.notifyDataSetChanged();
                    SharedPreferences sPref = getActivity().getSharedPreferences("TRAINING", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sPref.edit();
                    editor.putString(rowModel.getId(), rowModel.toString());
                    editor.commit();



                    break;


                }


        }
    }

    public void removeItem(int position) {

//        mAdapter.modelList.remove(position);
//        mAdapter.notifyItemRemoved(position);
//        mAdapter.notifyItemRangeChanged(position, mAdapter.modelList.size());
//        RowModel rowModel = new RowModel("My personal training " + (mAdapter.modelList.size() + 1), "Description... ");
        RowModel model = mAdapter.getItem(position);
        mAdapter.modelList.remove(position);
        mAdapter.notifyDataSetChanged();
        SharedPreferences sPref = getActivity().getSharedPreferences("TRAINING", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.remove(model.getId());
        editor.commit();

    }

    private void alertDialog() {

//
//        alertDialog = new AlertDialog.Builder(this.getContext());
//        final View view = getActivity().getLayoutInflater().inflate(R.layout.alertdialog_personal_training_name_description, null);
//        et_personal_trainings_name = (EditText) view.findViewById(R.id.name_of_training_alert_d);
//        et_personal_trainings_description = (EditText) getView().findViewById(R.id.description_of_training_alert_d);
//        name_personal_training = (TextView) getView().findViewById(R.id.mainText);
//        descript_personal_training = (TextView) getView().findViewById(R.id.subText);
//        alertDialog.setMessage("Edit Training info");
//        alertDialog.setView(view);
//
//        //In case it gives you an error for setView(View) try
//        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//
//                if (et_personal_trainings_name.length() < 1) {
//                    ToastUtil.makeToast(getActivity().getApplicationContext(), message);
//
//
//                    return;
//                } else {
//                  String et_name = et_personal_trainings_name.getText().toString();
//                   ;name_personal_training.setText(et_name);
//                    //    name_personal_training.setText( et_personal_trainings_name.getText());
//                    ToastUtil.makeToast(getView().getContext(), et_personal_trainings_name.getText().toString());
//                    message += et_personal_trainings_name.getText().toString();
//                    dialog.dismiss();
//
//                }
//            }
//
//
//        });
//
//        alertDialog.show();
//    }
    }


}




 

