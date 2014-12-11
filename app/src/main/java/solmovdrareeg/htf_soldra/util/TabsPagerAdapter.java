package solmovdrareeg.htf_soldra.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import solmovdrareeg.htf_soldra.activities.FavoritesFragment;
import solmovdrareeg.htf_soldra.activities.OverviewFragment;
import solmovdrareeg.htf_soldra.activities.TipFragment;

/**
 * Created by Dries on 11/12/2014.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new OverviewFragment();
            case 1:
                return new TipFragment();
            case 2:
                return new FavoritesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
