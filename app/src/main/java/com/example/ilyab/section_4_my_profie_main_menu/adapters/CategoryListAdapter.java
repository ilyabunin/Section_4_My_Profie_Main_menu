package com.example.ilyab.section_4_my_profie_main_menu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;
import com.example.ilyab.section_4_my_profie_main_menu.models.Category;
import com.example.ilyab.section_4_my_profie_main_menu.models.Data;

import java.util.ArrayList;

/**
 * Created by Max on 26.02.2017.
 */

public class CategoryListAdapter extends BaseAdapter {
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Integer> images = new ArrayList<>();
    private Context context;
    Data data = new Data();

    public void addCategory(Category category) {
        categories.add(category);
        notifyDataSetChanged();
    }
    public void addImage(Integer image) {
        images.add(image);
        notifyDataSetChanged();
    }

    public CategoryListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.category6_list_row, parent, false);
        TextView nameTxt = (TextView) view.findViewById(R.id.category_row_name_txt);
        Category category = categories.get(position);
        nameTxt.setText(category.getData());
        ImageView image = (ImageView) view.findViewById(R.id.images);
        for (Integer image1:category.getImageCategory()){
            image.setImageResource(image1);
        }



        return view;
    }
}
