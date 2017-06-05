package com.example.ilyab.section_4_my_profie_main_menu.Exercises_pckg;

import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.adapters.CategoryListAdapter;
import com.example.ilyab.section_4_my_profie_main_menu.models.ArrayCategory;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.google.gson.Gson;


/**
 * Created by Max on 26.02.2017.
 */

public class Fragment6ListAllCategory extends android.support.v4.app.Fragment implements View.OnClickListener {
    public String id;
    public int key_value;
    private ListView listViewFrag6;
    private CategoryListAdapter adapter;
    private FragmentTransaction transaction;
    private LinearLayout ln;
    private CategoryListAllListener listener;
    int recieve_visible;


    public void setListener(CategoryListAllListener listener) {
        this.listener = listener;
    }

    public static Fragment6ListAllCategory newInstance(String id) {
        Fragment6ListAllCategory fragment = new Fragment6ListAllCategory();
//        fragment.title = title;
        fragment.id = id;
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CategoryListAdapter(getActivity());



        ArrayCategory arrayCategory = new ArrayCategory();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DATABASE", getActivity().MODE_PRIVATE);
        String str = sharedPreferences.getString("CATEGORYS", "");
        if (!str.isEmpty()) {
            Gson gson = new Gson();
            arrayCategory = gson.fromJson(str, ArrayCategory.class);
        }
        for (Category category : arrayCategory.getCategories()) {
            adapter.addCategory(category);
            for (Integer imageCategory:category.getImageCategory()) {
                adapter.addImage(imageCategory);
                Log.d("TAG", "onCreateView: ");
            }
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment6, container, false);
        ln = (LinearLayout) view.findViewById(R.id.all_exercises);
        listViewFrag6 = (ListView) view.findViewById(R.id.category_list);
        listViewFrag6.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            recieve_visible = bundle.getInt("VISIBLE");
        }
           else if (bundle == null) {
            recieve_visible = -1;
        }




        ln.setOnClickListener(this);
        listViewFrag6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = (Category) adapter.getItem(position);
//                if(category==null)
//                    Log.i("CATEGORY","NULL");

                Log.d("TAG", "onItemClickClick: listener" + listener);

                listener.listAllExercisesSelect(category,recieve_visible);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.all_exercises) {
            listener.categorySelected();

        }
    }

    public interface CategoryListAllListener {
        void categorySelected();
        void listAllExercisesSelect(Category category,int recieve_visible);
    }
}
