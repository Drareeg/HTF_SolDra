package solmovdrareeg.htf_soldra.activities;

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
    void bindAdapter(){
        listView.setAdapter(adapter);
    }

    @Bean
    CityListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.overview_fragment, container, false);
    }

    @Background
    @Click(R.id.searchButton)
    public void searchCity(){
        //todo
        //adapter.clear();
        CityList byName = proxy.getByName(cityTextView.getText().toString());
        for(City city : byName.getItems()) {
            adapter.add(city);
        }
        System.out.println("done searching" + adapter.getCount());
        notifyChanged();

    }
@UiThread
    public void notifyChanged() {
        adapter.notifyDataSetChanged();
    }


}
