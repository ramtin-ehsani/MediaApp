package com.myapp.mediaproject.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.myapp.mediaproject.HomeFragment;
import com.myapp.mediaproject.MoviesFragment;
import com.myapp.mediaproject.SeriesFragment;

public class FragAdapter extends FragmentPagerAdapter {
    public FragAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return new HomeFragment();
        else if (position==1)
            return new MoviesFragment();
        else if (position==2)
            return new SeriesFragment();
        else return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Movies";
            case 2:
                return "Series";
        }
        return null;
    }
}
