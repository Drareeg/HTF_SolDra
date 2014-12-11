package solmovdrareeg.htf_soldra.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.util.RestProxy;

/**
 * Created by Dries on 11/12/2014.
 */
@EFragment
public class OverviewFragment extends Fragment {

    @Bean
    RestProxy proxy;

    @ViewById
    TextView cityTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.overview_fragment, container, false);
    }

    @Click(R.id.searchButton)
    public void searchCity(){
        proxy.getByName(cityTextView.getText().toString());
    }


}
