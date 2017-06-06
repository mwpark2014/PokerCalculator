package com.example.pokercalculator.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Mason on 6/5/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_ITEMS = 2;
    private static final int REVIEW_FRAG_POS = 1;
    private static final int HELPER_FRAG_POS = 0;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == REVIEW_FRAG_POS)
                return ReviewFragment.newInstance("ReviewFragment");
        else
                return HelperFragment.newInstance("HelperFragment");

    }
}
