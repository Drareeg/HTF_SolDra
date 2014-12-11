package solmovdrareeg.htf_soldra.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.adapters.LegendaListAdapter;
import solmovdrareeg.htf_soldra.model.LegendaEntry;

/**
 * Created by Dries on 11/12/2014.
 */
@EFragment
public class TipFragment extends Fragment {
    @ViewById
    ListView legenda_list;

    @Bean
    LegendaListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        legenda_list.setAdapter(adapter);
        adapter.clear();
        LegendaEntry myEntry = new LegendaEntry();
        myEntry.setDescription("herp");
        myEntry.setImage(R.drawable.black);
        adapter.add(myEntry);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tip_fragment, container, false);
    }
}
