package com.example.ilyab.section_4_my_profie_main_menu.adapters;

/**
 * Created by ilyab on 02.05.2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;

import java.util.ArrayList;
import java.util.Random;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context mContext;


    public DataAdapter(String text) {

    }


    public DataAdapter (Context context)
    {
        mContext = context;

    }
    private ArrayList<String> personal_trainings;
private ArrayList<String> perstrainings;

    public DataAdapter(ArrayList<String> personal_trainings) {
        this.personal_trainings = personal_trainings;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_personal_trainings_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_personal_training.setText(personal_trainings.get(i));
    }

    @Override
    public int getItemCount() {
        return personal_trainings.size();
    }

    public void addItem(String nameperstraining) {
        personal_trainings.add(nameperstraining);
        notifyItemInserted(personal_trainings.size());

    }

    public void removeItem(int position) {
        personal_trainings.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, personal_trainings.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout layout_color;
        TextView tv_personal_training;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            tv_personal_training = (TextView)view.findViewById(R.id.name_personal_trainings);
            layout_color = (LinearLayout) view.findViewById(R.id.layout_row_color);
            int[] androidColors = view.getResources().getIntArray(R.array.random_colors);
            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
            layout_color.setBackgroundColor(randomAndroidColor);
        }

        @Override
        public void onClick(View view) {
            personal_trainings.get(getAdapterPosition());
            Log.d("HHH","This is onclick on row in personal workouts");
            Toast.makeText(view.getContext(),"This " +personal_trainings.get(getAdapterPosition()), Toast.LENGTH_LONG).show();
        }
    }

}