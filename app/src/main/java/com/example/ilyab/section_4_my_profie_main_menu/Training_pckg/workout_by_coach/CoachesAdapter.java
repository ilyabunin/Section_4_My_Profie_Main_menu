package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;

import java.util.ArrayList;

/**
 * Created by ilyab on 12.03.2017.
 */

public class CoachesAdapter extends RecyclerView.Adapter<CoachesAdapter.CoachesViewHolder> {

    ArrayList<Coaches> coaches = new ArrayList<Coaches>();
    Context ctxt;
    protected CoachListListener listener;

    public CoachesAdapter(ArrayList<Coaches> coaches, Context ctxt, CoachListListener listener) {
        this.coaches = coaches;
        this.ctxt = ctxt;
        this.listener = listener;
    }

    @Override
    public CoachesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coach_card_layout, parent, false);

        CoachesViewHolder coachesViewHolder = new CoachesViewHolder(view, ctxt, coaches);


        return coachesViewHolder;
    }

    @Override
    public void onBindViewHolder(CoachesViewHolder holder, int position) {

        Coaches CCH = coaches.get(position);
        holder.coach_img.setImageResource(CCH.getImageId());
        holder.coach_name.setText(CCH.getName());
        holder.coach_degree.setText(CCH.getDegree());
        holder.coach_speacializtion.setText(CCH.getSpecialization());
        holder.coach_personalinfo.setText(CCH.getPersonal_info());

    }

    @Override
    public int getItemCount() {
        return coaches.size();
    }


    public  class CoachesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView coach_img;
        TextView coach_name, coach_degree, coach_speacializtion, coach_personalinfo;
        ArrayList<Coaches> coaches = new ArrayList<Coaches>();
        Context ctxt;

        public CoachesViewHolder(View itemView, Context ctxt, ArrayList<Coaches> coaches) {


            super(itemView);
            this.coaches = coaches;
            this.ctxt = ctxt;
            itemView.setOnClickListener(this);
            coach_img = (ImageView) itemView.findViewById(R.id.coachImage);
            coach_name = (TextView) itemView.findViewById(R.id.coachName);
            coach_degree = (TextView) itemView.findViewById(R.id.coachDegree);
            coach_speacializtion = (TextView) itemView.findViewById(R.id.coachSpecialization);
            coach_personalinfo = (TextView) itemView.findViewById(R.id.coachAboutInfo);


        }

        @Override
        public void onClick(View v) {
//            int position = getAdapterPosition();
//            Coaches coaches = this.coaches.get(position);
//            Intent intent = new Intent(this.ctxt, CardCoachDetails.class);
//            intent.putExtra("coach_img_id", coaches.getImageId());
//            intent.putExtra("coach_name", coaches.getName());
//            intent.putExtra("coach_degree", coaches.getDegree());
//            intent.putExtra("coach_specialization", coaches.getSpecialization());
//            intent.putExtra("coach_about_info", coaches.getPersonal_info());
//            this.ctxt.startActivity(intent);
            listener.choiceCoachCallback(coaches.get(getAdapterPosition()));
        }
    }

    interface CoachListListener{
        void choiceCoachCallback(Coaches coach);
    }


}
