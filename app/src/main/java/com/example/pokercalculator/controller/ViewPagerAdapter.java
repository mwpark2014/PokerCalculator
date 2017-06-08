package com.example.pokercalculator.controller;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pokercalculator.R;
import com.example.pokercalculator.ui.HelperFragment;
import com.example.pokercalculator.ui.ReviewFragment;

/**
 * Created by Mason on 6/5/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_ITEMS = 2;
    private static final int REVIEW_FRAG_POS = 1;
    private static final int HELPER_FRAG_POS = 0;
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == REVIEW_FRAG_POS)
                return ReviewFragment.newInstance("ReviewFragment");
        else if(position == HELPER_FRAG_POS)
                return HelperFragment.newInstance("HelperFragment");
        else
            return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == REVIEW_FRAG_POS)
            return context.getString(R.string.review_frag_title);
        else if (position == HELPER_FRAG_POS)
            return context.getString(R.string.helper_frag_title);
        else
            return null;
    }
}
