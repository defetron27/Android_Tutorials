package com.max.def.tutorials;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter
{
    public TabAdapter(FragmentManager supportFragmentManager)
    {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int i)
    {
        switch (i)
        {
            case 0:
                return new BlankFragment();
            case 1:
                return new BlankFragment2();
            case 2:
                return new BlankFragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {

        switch (position)
        {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            default:
                return null;
        }
    }
}
