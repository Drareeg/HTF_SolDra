package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import solmovdrareeg.htf_soldra.model.LegendaEntry;

/**
 * Created by Dries on 11/12/2014.
 */
@EBean
public class LegendaListAdapter extends BaseAdapter {

    List<LegendaEntry> entries;
    @RootContext
    Context context;

    @Override
    public int getCount() {
        return entries.size();
    }


    public void add(LegendaEntry entry){
        entries.add(entry);
    }

    @Override
    public LegendaEntry getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LegendaView legendaView = null;
        if (convertView == null) {
            legendaView = LegendaView_.build(context);
        } else {
            legendaView = (LegendaView) convertView;
        }

        legendaView.bind(getItem(position));

        return legendaView;
        }

    public void clear() {
       entries = new ArrayList<LegendaEntry>();
    }
}
