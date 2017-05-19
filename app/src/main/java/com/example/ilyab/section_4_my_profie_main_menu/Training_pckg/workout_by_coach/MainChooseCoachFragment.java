package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;

import java.util.ArrayList;

public class MainChooseCoachFragment extends Fragment implements CoachesAdapter.CoachListListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Coaches> coacheslist = new ArrayList<Coaches>();

    int[] image_id = {R.drawable.avatar7,R.drawable.avatar7, R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4, R.drawable.avatar5, R.drawable.avatar6};
    String[] name;
    String[] degree;
    String[] specialization;
    String[] personal_info;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coach_card_layout, container, false);

        getActivity().setContentView(R.layout.activity_choose_coach);
        name = getResources().getStringArray(R.array.coaches_name);
        degree = getResources().getStringArray(R.array.degree);
        specialization = getResources().getStringArray(R.array.specialization);
        personal_info = getResources().getStringArray(R.array.info);
        int count = 0;
        for (String Name : name) {
            Coaches coach = new Coaches(image_id[count], Name, degree[count], specialization[count], personal_info[count]);
            count++;
            coacheslist.add(coach);

        }
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_coach_);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CoachesAdapter(coacheslist, getContext(), this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    void showDialog(Coaches coach) {
        DialogFragment newFragment = MyAlertDialogFragment.newInstance("Coach profile",coach);
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick() {

    }


    @Override
    public void choiceCoachCallback(Coaches coach) {
        showDialog(coach);
    }

    public static class MyAlertDialogFragment extends DialogFragment {
        Coaches coach;
        public static MyAlertDialogFragment newInstance(String title,Coaches coach ) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putString("title", title);
            frag.setArguments(args);
            frag.setCoach(coach);
            return frag;
        }

        private void setCoach(Coaches coach){
            this.coach = coach;
        }




        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            ImageView mImageView;
            TextView coach_tx_name, coach_tx_degree, coach_tx_specialization, coach_tx_about_info;
            LayoutInflater inflater = getActivity().getLayoutInflater();

            View view = inflater.inflate(R.layout.card_coach_details, null);
            String title = getArguments().getString("title");

            mImageView = (ImageView) view.findViewById(R.id.coach_avatar_card);
            coach_tx_name = (TextView) view.findViewById(R.id.name_coach_profile);
            coach_tx_degree = (TextView) view.findViewById(R.id.degree_coach_profile);
            coach_tx_specialization = (TextView) view.findViewById(R.id.specialization_coach_profile);
            coach_tx_about_info = (TextView) view.findViewById(R.id.coach_personal_info_profile);


            mImageView.setImageResource(coach.getImageId());
            coach_tx_name.setText(coach.getName());
            coach_tx_degree.setText(coach.getDegree());
            coach_tx_specialization.setText(coach.getSpecialization());
            coach_tx_about_info.setText(coach.getPersonal_info());


            return new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setView(view)
                    .setPositiveButton("Choose",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast.makeText(getActivity().getApplicationContext(), "You choose: " + coach.getName(), Toast.LENGTH_LONG).show();

                                }
                            }
                    )
                    .setNegativeButton("Back",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            }
                    )
                    .create();
        }
    }
}
