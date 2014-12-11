package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.City;


/**
 * Created by Drareeg on 05.12.14.
 */
@EViewGroup(R.layout.city_overview_list_row)
public class CityItemView extends LinearLayout{


    @ViewById
    TextView nameText;


    public CityItemView(Context context) {
        super(context);
    }

    public void bind(City city){
       nameText.setText(city.getName());

    }
}
