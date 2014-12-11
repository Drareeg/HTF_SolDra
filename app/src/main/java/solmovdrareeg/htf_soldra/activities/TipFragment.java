package solmovdrareeg.htf_soldra.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

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
        for (LegendaEntry e : generateLegendaList()){
            adapter.add(e);
        }
        adapter.notifyDataSetChanged();
        Log.i("code gets here:",adapter.getCount()+"");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tip_fragment, container, false);
    }

    private List<LegendaEntry> generateLegendaList(){
        List<LegendaEntry> output = new ArrayList<LegendaEntry>();
        output.add(new LegendaEntry(
                R.drawable.green,
                "Er is genoeg stroom beschikbaar om in ons verbruik te voorzien. Er is geen reden tot ongerustheid!"
        ));
        output.add(new LegendaEntry(
                R.drawable.orange,
                "Het risico bestaat dat er niet genoeg stroom beschikbaar is om in ons verbruik te voorzien. Laten we allemaal minder verbruiken, vooral tijdens de kritieke periode (in principe tussen 17.00 en 20.00 uur) om zo afschakeling te voorkomen!"
        ));
        output.add(new LegendaEntry(
                R.drawable.red,
                "Er is niet genoeg stroom beschikbaar om op elk moment in ons verbruik te voorzien. De overheid neemt verbodsmaatregelen om het verbruik alsnog te doen dalen. Wij van onze kant kunnen bijkomende inspanningen leveren om afschakeling te voorkomen."
        ));
        output.add(new LegendaEntry(
                R.drawable.black,
                "Indien het echt nodig is, zal een deel van de verbruikers tijdelijk geen stroom krijgen om zo een langdurige en ongecontroleerde stroompanne te vermijden."
        ));
        return output;
    }
}
