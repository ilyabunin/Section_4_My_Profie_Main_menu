package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.personal_trainings;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.DataAdapter;

import java.util.ArrayList;


public class MainPersonTrainingFragment extends Fragment implements View.OnClickListener, SearchView.OnQueryTextListener {
    private TextView personaltxt;
    private ArrayList personal_trainings =  new ArrayList<>();
    private DataAdapter adapter;
    private RecyclerView recyclerView;
    private AlertDialog.Builder alertDialog;
    private AlertDialog.Builder alertDialog_Delete;
    private EditText et_personal_trainings;
    private int edit_position;
    private View view;
    private boolean add = false;
    private Paint p = new Paint();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout_personal_trainings, container, false);
        personaltxt = (TextView) view.findViewById(R.id.txt_personal_trainings_no_workout);

        TextView textView = new TextView(getActivity());


        return view;



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initDialog();
        if (personal_trainings.isEmpty()) {
            getActivity().findViewById(R.id.txt_personal_trainings_no_workout).setVisibility(View.VISIBLE);
        }
     else {
                getActivity().findViewById(R.id.txt_personal_trainings_no_workout).setVisibility(View.INVISIBLE);
            }
        }





    private void initViews(){
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_personal_trainings);
        fab.setOnClickListener(this);
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DataAdapter(personal_trainings);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        initSwipe();


    }
    private void initSwipe(){
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
              final int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT){
                    adapter.removeItem(position);
                }else {

                        removeView();
                        edit_position = position;
                        alertDialog.setTitle("Edit Name");

                        et_personal_trainings.setText((CharSequence) personal_trainings.get(position));
                        alertDialog.show();


                }}

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if(dX > 0){
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_edit_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    } else {
                        p.setColor(Color.parseColor("#D32F2F"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_del_white);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    private void removeView(){
        if(view.getParent()!=null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }



    private void initDialog(){
        alertDialog = new AlertDialog.Builder(this.getContext());
        view = getActivity().getLayoutInflater().inflate(R.layout.dialog_create_personal_training_layout,null);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(add){
                    if(et_personal_trainings.length() < 1)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Please enter Minimum 1 symbol", Toast.LENGTH_LONG).show();
                        return;
                    }
                    else {

                    add =false;
                    adapter.addItem(et_personal_trainings.getText().toString());
                    dialog.dismiss();
                    getActivity().findViewById(R.id.txt_personal_trainings_no_workout).setVisibility(View.INVISIBLE);
                } }
                    else {

//
                    personal_trainings.set(edit_position,et_personal_trainings.getText().toString());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();

                }

            }
        });
        et_personal_trainings = (EditText)view.findViewById(R.id.name_personal_trainings);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_personal_trainings:

                removeView();
                add = true;
                alertDialog.setTitle("Set name of personal training");
                    et_personal_trainings.setText("");
                    alertDialog.show();

                break;


        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}