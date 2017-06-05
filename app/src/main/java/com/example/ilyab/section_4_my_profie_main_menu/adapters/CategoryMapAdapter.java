package com.example.ilyab.section_4_my_profie_main_menu.adapters;

/**
 * Created by Max on 01.03.2017.
 */

public class CategoryMapAdapter {// extends BaseAdapter
//    private Context context;
//    private ArrayList<Category> categories = new ArrayList<>();
//    private ArrayList<Exercise> exercises = new ArrayList<>();/////////////////////////////////////
//    private AdapterCategoryMapAdapter listener;
//
//    public void setAdapterListener(AdapterCategoryMapAdapter listener) {
//        this.listener = listener;
//    }
//
//    public void addCategory(Category category) {
//        categories.add(category);
//        notifyDataSetChanged();
//    }
//    public void addExercise(Exercise exercise) {///////////////////////////////
//        exercises.add(exercise);//////////////////////////////////////////
//        notifyDataSetChanged();//////////////////////////////////////////
//    }
//
//    public CategoryMapAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return categories.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return categories.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category6_1_row, parent, false);
//        LinearLayout ll = (LinearLayout) view.findViewById(R.id.main_container_row);
//        TextView kayTxt = (TextView) view.findViewById(R.id.category_value_name_txt);
//        Category cat = categories.get(position);
//       // ArrayList<Exercise> exercises = cat.getExercises();
//        Exercise ex1 = exercises.get(position);////////////////////
//      //  ArrayList<Category> categories = ex1.getCategories();//////////////////////////////
//
//        kayTxt.setText(cat.getData());
//        for (Exercise ex : exercises) {
//              View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise6_1_row, null);
//            TextView title = (TextView) view1.findViewById(R.id.exercise_title_txt);
//            title.setText(ex.getData());
//            ll.addView(view1);
//        }
//      //  listener.adapterListener(ex1);//////////////////////////////////////////////////////
//        return view;
//    }
//    public interface AdapterCategoryMapAdapter {
//        void adapterListener(Exercise ex1);
//
//
//    }
}

//    private ArrayList<Exercise> exercises = new ArrayList<>();
//
//    public void addExercise(Exercise exercise) {
//        exercises.add(exercise);
//        notifyDataSetChanged();