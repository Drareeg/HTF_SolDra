package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.LegendaEntry;

/**
 * Created by Dries on 11/12/2014.
 */
@EViewGroup(R.layout.legendaview_layout)
public class LegendaView extends LinearLayout{

    @ViewById
    ImageView legenda_image;

    @ViewById
    TextView legenda_description;


    public LegendaView(Context context) {
       super(context);
    }

   public void bind(LegendaEntry entry){
      legenda_image.setImageResource(entry.getImage());
      legenda_description.setText(entry.getDescription());


    }
}
