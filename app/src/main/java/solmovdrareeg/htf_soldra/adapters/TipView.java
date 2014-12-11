package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.Tip;

/**
 * Created by Dries on 11/12/2014.
 */
@EViewGroup(R.layout.tipview_layout)
public class TipView extends LinearLayout {

    @ViewById
    TextView tip_title;

    @ViewById
    TextView tip_description;


    public TipView(Context context) {
        super(context);
    }

    public void bind(Tip entry){
        tip_title.setText(entry.getTitle());
        tip_description.setText(entry.getDescription());

    }
}
