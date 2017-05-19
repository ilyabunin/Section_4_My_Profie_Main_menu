package com.example.ilyab.section_4_my_profie_main_menu.Training_pckg.pckg_vip_advertising;

/**
 * Created by ilyab on 04.03.2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class VipPageAdapter extends FragmentPagerAdapter {

    public VipPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:

                return new Tab1();
            case 1:

                return new Tab2();
            case 2:

                return new Tab3();
            case 3:

                return new Tab4();
        }

        return null;
    }

    @Override
    public int getCount() {

        return 4;
    }

}