package solmovdrareeg.htf_soldra.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import solmovdrareeg.htf_soldra.activities.FavoritesFragment;
import solmovdrareeg.htf_soldra.activities.FavoritesFragment_;
import solmovdrareeg.htf_soldra.activities.OverviewFragment;
import solmovdrareeg.htf_soldra.activities.OverviewFragment_;
import solmovdrareeg.htf_soldra.activities.TipFragment;
import solmovdrareeg.htf_soldra.activities.TipFragment_;

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
                return new OverviewFragment_();
            case 1:
                return new TipFragment_();
            case 2:
                return new FavoritesFragment_();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
