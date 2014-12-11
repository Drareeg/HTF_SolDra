package solmovdrareeg.htf_soldra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.adapters.CityListAdapter;
import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.model.CityList;
import solmovdrareeg.htf_soldra.util.MyPrefs_;
import solmovdrareeg.htf_soldra.util.RestProxy;

/**
 * Created by Dries on 11/12/2014.
 */
@EFragment
public class FavoritesFragment extends Fragment {

    @Pref
    MyPrefs_ prefs;

    @ViewById
    ListView listView;

    @Bean
    RestProxy proxy;

    @AfterViews
    void bindAdapter() {

        listView.setAdapter(adapter);
        //adapter.clear();

        if (prefs.favoritedCityIds().get() == null) {
            System.out.println("geen rpefs");
            //TODO toon geen favs
        } else {
            System.out.println("wel prefs");
            for (String id : prefs.favoritedCityIds().get()) {
                adapter.add(proxy.getById(Long.parseLong(id)));
                notifyChanged();
            }
        }


    }

    @Bean
    CityListAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favorites_fragment, container, false);
    }

    @UiThread
    public void notifyChanged() {
        adapter.notifyDataSetChanged();
    }

    @ItemClick
    void listViewItemClicked(City clickedCity) {
        Intent intent = new Intent(getActivity().getApplicationContext(), CityDetailActivity_.class);
        intent.putExtra("city", clickedCity);
        startActivity(intent);
    }
}
