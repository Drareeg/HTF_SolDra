package solmovdrareeg.htf_soldra.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solmovdrareeg.htf_soldra.R;

/**
 * Created by Dries on 11/12/2014.
 */
public class FavoritesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorites_fragment, container, false);
    }
}
