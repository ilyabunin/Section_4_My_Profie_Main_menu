package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.workout_by_coach;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilyab.section_4_my_profie_main_menu.R;

public class CardCoachDetails extends AppCompatActivity {
    ImageView mImageView;
    TextView coach_tx_name, coach_tx_degree, coach_tx_specialization, coach_tx_about_info;
    private Button back_btn, choose_coach;
private FragmentManager fr_manager;
    private android.support.v4.app.FragmentTransaction fr_transact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.card_coach_details);
//back_btn = (Button) findViewById(R.id.btn_back_to_list_coach);
//        choose_coach = (Button) findViewById(R.id.btn_save_coach);
//        mImageView = (ImageView) findViewById(R.id.coach_avatar_card);
//            coach_tx_name = (TextView) findViewById(R.id.name_coach_profile);
//            coach_tx_degree = (TextView) findViewById(R.id.degree_coach_profile);
//            coach_tx_specialization = (TextView) findViewById(R.id.specialization_coach_profile);
//            coach_tx_about_info = (TextView) findViewById(R.id.coach_personal_info_profile);
//            mImageView.setImageResource(getIntent().getIntExtra("coach_img_id",000));
//            coach_tx_name.setText(getIntent().getStringExtra("coach_name"));
//            coach_tx_degree.setText(""+getIntent().getStringExtra("coach_degree"));
//            coach_tx_specialization.setText(""+getIntent().getStringExtra("coach_specialization"));
//            coach_tx_about_info.setText(""+getIntent().getStringExtra("coach_about_info"));
//            back_btn.setOnClickListener(this);
//            choose_coach.setOnClickListener(this);
        }




//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_back_to_list_coach:
//                onBackPressed();
//                break;
//            case R.id.btn_save_coach:
//                Toast.makeText(getApplicationContext(), "You choose: " + getIntent().getStringExtra("coach_name"), Toast.LENGTH_LONG).show();
//
////
//
//                break;
//
//        }

//        onBackPressed();
//
//        if(v.getId()== R.id.btn_back_to_list_coach){
//            onBackPressed();
//        }
//        else if(v.getId()== R.id.btn_save_coach) {
//            Toast.makeText(getApplicationContext(),"You choose: " +getIntent().getStringExtra("coach_name") , Toast.LENGTH_LONG).show();
//
//        }
//        choose_coach.setClickable(false);
//    }
//    }
}
