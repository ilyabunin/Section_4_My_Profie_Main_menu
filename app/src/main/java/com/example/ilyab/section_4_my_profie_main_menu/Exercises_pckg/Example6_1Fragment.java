package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;


import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayCategory;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Exercise;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by Max on 05.05.2017.
 */

public class Example6_1Fragment extends android.support.v4.app.Fragment implements SearchView.OnQueryTextListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private SectionedRecyclerViewAdapter sectionAdapter;
    private ListCategoryListener listener;
    private Button AddToTrainig;
    private CheckBox addExercises;
    private FragmentTransaction transaction;

    public void setListListener(ListCategoryListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ex7, container, false);

        sectionAdapter = new SectionedRecyclerViewAdapter();

        for (char alphabet = 'А'; alphabet <= 'Я'; alphabet++) {
            List<String> contacts = getContactsWithLetter(alphabet);

            if (contacts.size() > 0) {
                ContactsSection contactsSection = new ContactsSection(String.valueOf(alphabet), contacts);
                sectionAdapter.addSection(contactsSection);
            }
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(sectionAdapter);
        //  AddToTrainig = (Button) view.findViewById(R.id.add_to_training);
        //   AddToTrainig.setOnClickListener(this);
        addExercises = (CheckBox) view.findViewById(R.id.checkbox_row_add_exercise);




        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();

        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = ((AppCompatActivity) getActivity());
//            if (activity.getSupportActionBar() != null)
//                activity.getSupportActionBar().setTitle(R.string.nav_example7);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_ex7, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String query) {

        // getSectionsMap requires library version 1.0.4+
        for (Section section : sectionAdapter.getSectionsMap().values()) {
            if (section instanceof FilterableSection) {
                ((FilterableSection) section).filter(query);
            }
        }
        sectionAdapter.notifyDataSetChanged();

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<String> getContactsWithLetter(char letter) {
        List<String> contacts = new ArrayList<>();

        ArrayCategory arrayCategory = new ArrayCategory();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DATABASE", getActivity().MODE_PRIVATE);
        String str = sharedPreferences.getString("CATEGORYS", "");
        if (!str.isEmpty()) {
            Gson gson = new Gson();
            arrayCategory = gson.fromJson(str, ArrayCategory.class);
        }

        for (Category category : arrayCategory.getCategories()) {
            for (Exercise exercise :
                    category.getExercises()) {
                String ar = new String();
                ar = exercise.getData();
                if (ar.charAt(0) == letter) {
                    contacts.add(String.valueOf(ar));
                }
            }
        }

        return contacts;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {

        }
    }

    class ContactsSection extends StatelessSection implements FilterableSection {

        String title;
        List<String> list;
        List<String> filteredList;



        public ContactsSection(String title, List<String> list) {
            super(R.layout.section_ex7_header, R.layout.section_ex7_item);

            this.title = title;
            this.list = list;
            this.filteredList = new ArrayList<>(list);
        }


        @Override
        public int getContentItemsTotal() {
            return filteredList.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
            final ItemViewHolder itemHolder = (ItemViewHolder) holder;

            final String name = filteredList.get(position);

            itemHolder.tvItem.setText(name);
            itemHolder.imgItem.setImageResource(R.mipmap.exercise_image);
            //        itemHolder.imgItem.setImageResource(name.hashCode() % 2 == 0 ? R.drawable.ic_face_black_48dp : R.drawable.ic_tag_faces_black_48dp);
            itemHolder.tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Toast.makeText(getActivity(), String.format("Click on position #%s of Section %s", itemHolder.tvItem.getText(), title), Toast.LENGTH_SHORT).show();
                    // int exercise = sectionAdapter.getPositionInSection(itemHolder.getAdapterPosition());
                    String text = (String) itemHolder.tvItem.getText();
                    findExercise(text);

                }
            });
            itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Exercise exercise = (Exercise) adapterList.getItem(position);
                    Toast.makeText(getActivity(), String.format("Clicked on position #%s of Section %s", sectionAdapter.getPositionInSection(itemHolder.getAdapterPosition()), title), Toast.LENGTH_SHORT).show();

                }
            });
        }

        public void findExercise(String text) {
            ArrayCategory arrayCategory = new ArrayCategory();
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DATABASE", getActivity().MODE_PRIVATE);
            String str = sharedPreferences.getString("CATEGORYS", "");
            if (!str.isEmpty()) {
                Gson gson = new Gson();
                arrayCategory = gson.fromJson(str, ArrayCategory.class);
            }
            for (Category category : arrayCategory.getCategories()) {
                for (Exercise exercise :
                        category.getExercises()) {
                    if (exercise.getData().equals(text)) {
                        Toast.makeText(getActivity(), String.format("Click on position " + exercise.getData()), Toast.LENGTH_SHORT).show();
                        listener.cardForExercise(exercise);
                    }
                }
            }
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            headerHolder.tvTitle.setText(title);
        }

        @Override
        public void filter(String query) {
            if (TextUtils.isEmpty(query)) {
                filteredList = new ArrayList<>(list);
                this.setVisible(true);
            } else {
                filteredList.clear();
                for (String value : list) {
                    if (value.toLowerCase().contains(query.toLowerCase())) {
                        filteredList.add(value);
                    }
                }

                this.setVisible(!filteredList.isEmpty());
            }
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        public HeaderViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final ImageView imgItem;
        private final TextView tvItem;

        public ItemViewHolder(View view) {
            super(view);

            rootView = view;
            imgItem = (ImageView) view.findViewById(R.id.imgItem);
            tvItem = (TextView) view.findViewById(R.id.tvItem);

        }
    }

    interface FilterableSection {
        void filter(String query);
    }

    public interface ListCategoryListener {
        void listAllExercises();

        void cardForExercise(Exercise exercise);
    }
}
