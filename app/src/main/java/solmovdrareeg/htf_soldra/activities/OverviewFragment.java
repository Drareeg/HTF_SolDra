package solmovdrareeg.htf_soldra.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.adapters.CityListAdapter;
import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.model.CityList;
import solmovdrareeg.htf_soldra.util.RestProxy;

/**
 * Created by Dries on 11/12/2014.
 */
@EFragment
public class OverviewFragment extends Fragment {


    @ViewById
    ListView listView;

    @Bean
    RestProxy proxy;

    @ViewById
    TextView cityTextView;

    @AfterViews
    void bindAdapter() {
        listView.setAdapter(adapter);
    }

    @ViewById
    TextView noItemFoundTextView;

    @Bean
    CityListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        showDefaultCities();
        return inflater.inflate(R.layout.overview_fragment, container, false);

    }


    @Background
    public void showDefaultCities() {
        if (adapter.getCount() == 0) {
            long[] defaultIds = new long[]{5297547954356224l, 4790047639339008l, 5508312736989184l, 4541270517088256l, 5624528914874368l};
            for (long id : defaultIds) {
                adapter.add(proxy.getById(id));
                notifyChanged();
            }
        }
    }


    @Background
    @Click(R.id.searchButton)
    public void searchCity() {
        showListView();
        adapter.clear();
        notifyChanged();
        CityList byName = proxy.getByName(cityTextView.getText().toString());
        for (City city : byName.getItems()) {
            adapter.add(city);
        }
        notifyChanged();

        updateNoItemFoundTextView();

    }

    @UiThread
    public void showListView() {
        listView.setVisibility(View.VISIBLE);
    }

    @UiThread
    public void updateNoItemFoundTextView() {
        if (adapter.getCount() == 0) {
            listView.setVisibility(View.GONE);
            noItemFoundTextView.setVisibility(View.VISIBLE);
        }else{
            noItemFoundTextView.setVisibility(View.GONE);

        }
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
