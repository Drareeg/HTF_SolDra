package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.City;


/**
 * Created by Drareeg on 05.12.14.
 */
@EViewGroup(R.layout.city_overview_list_row)
public class CityItemView extends LinearLayout{

    @ViewById
    ImageView statusView;

    @ViewById
    TextView nameText;

    public static Map<String, Integer> imageMap;
    static{
        imageMap = new HashMap<String, Integer>();
        imageMap.put("GREEN", R.drawable.green);
        imageMap.put("RED", R.drawable.red);
        imageMap.put("ORANGE", R.drawable.orange);
        imageMap.put("BLACK", R.drawable.black);
    }


    public CityItemView(Context context) {
        super(context);
    }

    public void bind(City city){
        nameText.setText(city.getName());
        statusView.setImageResource(imageMap.get(city.getAlertCode()));
    }
}
