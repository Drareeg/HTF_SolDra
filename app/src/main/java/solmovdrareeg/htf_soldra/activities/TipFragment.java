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
import solmovdrareeg.htf_soldra.adapters.TipListAdapter;
import solmovdrareeg.htf_soldra.model.LegendaEntry;
import solmovdrareeg.htf_soldra.model.Tip;

/**
 * Created by Dries on 11/12/2014.
 */
@EFragment
public class TipFragment extends Fragment {
    @ViewById
    ListView tip_list;

    @Bean
    TipListAdapter adapterTip;

    @AfterViews
    void bindAdapters() {
        tip_list.setAdapter(adapterTip);
        adapterTip.clear();
        for(Tip t : generateTipList()){
            adapterTip.add(t);
        }
        adapterTip.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tip_fragment, container, false);
    }


    private List<Tip> generateTipList() {
        List<Tip> output = new ArrayList<Tip>();
        output.add(new Tip(
                "1. Kleine wasjes, koude wasjes",
                "Laat de was even staan, maar als dat echt niet lukt, probeer dan eens koud te wassen. Want wist je dat jouw wasmachine 90% van haar energie gebruikt om water op te warmen? Een andere energieverslinder in het washok is de droogkast. Laat die dus ook even ‘uitblazen’ en hang je was gewoon te drogen aan de draad.\n"
        ));
        output.add(new Tip(
                "2. Laat je oven ook eens stoom afblazen",
                "Want hij werkt hard om jou steeds de lekkerste gerechtjes voor te schotelen. Open hem daarom niet voortdurend om te kijken of je maaltijd al klaar is. Zo verlies je veel warmte. Én veel stroom.\n"));
        output.add(new Tip(
                "3. Word de koning(in) van het eenpansgerecht",
                "Beperk je verbruik tot één vuur. Leve frittata, paella, omeletjes, gewokte kip ... Moet je toch wat koken? Draai de warmteknop terug zodra je water borrelt.\n"));
        output.add(new Tip(
                "4. Zet je koelkast op dieet",
                "Elke keer je zijn deur opent, verlies je 30% koude lucht en vreet je koelkast elektriciteit. Probeer daarom alles wat je nodig hebt in een keer te nemen.\n"));
        output.add(new Tip(
                "5. Wees niet blij met ‘stand-by’",
                "Zet je computer, de tv ... steeds helemaal uit. Want een apparaat in stand-by modus verbruikt nog steeds 50% elektriciteit!\n"));
        output.add(new Tip(
                "6. Zeg 'ja' tegen de trap",
                "Geef de lift ook eens vakantie. Dat is goed voor je verbruik én je gezondheid!\n"));
        output.add(new Tip(
                "7. Let op je elektrische waterkoker",
                "Een waterkoker is een heel efficiënte manier om water op te warmen. Je hoeft er echter niet meer water dan nodig in te doen.\n" +
                        "Wees je ervan bewust dat er veel vermogen gebruikt wordt (2000 watt) om het water op te warmen. Gezien het risico op stroomtekort deze winter is het dus beter om het gebruik ervan te vermijden op momenten waarop het elektriciteitsverbruik het hoogst ligt, meer bepaald tussen 17 en 20 uur.\n"));
        output.add(new Tip(
                "8. Leef meer ‘unplugged’",
                "De laders van je elektrische tandenborstel, je gsm of je laptop trek je best uit wanneer je ze niet nodig hebt. Ze verbruiken meer dan je denkt! Daarom laat je ze ook best 'unplugged' tijdens de piekmomenten, vooral tussen 17 en 20u.\n"));
        output.add(new Tip(
                "9. Surf draadloos",
                "Gebruik je ‘unplugged’ laptop in plaats van een desktop om te surfen en denk eraan om je batterij buiten de piekmomenten op te laden.\n"));
        output.add(new Tip(
                "10. Denk ‘donker’ na elke bijeenkomst",
                "Een lokaal dat de hele nacht verlicht blijft, verbruikt genoeg stroom om 1000 koppen thee te zetten. Straffe koffie, he?\n"));

        return output;
    }
}
