package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.pckg_vip_advertising;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.ilyab.section_4_my_profie_main_menu.R;

/**
 * Created by ilyab on 04.03.2017.
 */

public class Vip_fragment extends FragmentActivity
{

    private ViewPager viewPager;
    private VipPageAdapter mAdapter;
    TextView skip;
    Button bt1,bt2,bt3,bt4;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.vip_main_fragment);
        bt1=(Button) findViewById(R.id.btn1);
        bt2=(Button) findViewById(R.id.btn2);
        bt3=(Button) findViewById(R.id.btn3);
        bt4=(Button) findViewById(R.id.btn4);
        viewPager = (ViewPager) findViewById(R.id.pager);

        mAdapter = new VipPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                btnAction(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    private void btnAction(int action){
        switch(action){
            case 0:
                setButton(bt2,4,15, R.drawable.circle2);
                setButton(bt1,4,15,R.drawable.circle);
                setButton(bt3,4,15,R.drawable.circle);
                setButton(bt4,4,15,R.drawable.circle);
                break;

            case 1:  setButton(bt1,4,15,R.drawable.circle2);
                setButton(bt2,4,15, R.drawable.circle);
                setButton(bt3,4,15,R.drawable.circle);
                setButton(bt4,4,15,R.drawable.circle);
                break;

            case 2:  setButton(bt3,4,15,R.drawable.circle2);
                setButton(bt2,4,15,R.drawable.circle);
                setButton(bt1,4,15,R.drawable.circle);
                setButton(bt4,4,15,R.drawable.circle);

                break;
            case 3:  setButton(bt4,4,15,R.drawable.circle2);
                setButton(bt2,4,15,R.drawable.circle);
                setButton(bt1,4,15,R.drawable.circle);
                setButton(bt3,4,15,R.drawable.circle);

                break;
        }
    }
    private void setButton(Button btn,int w,int h,int c){

        btn.setWidth(w);
        btn.setHeight(h);
        btn.setBackgroundResource(c);
    }



}


