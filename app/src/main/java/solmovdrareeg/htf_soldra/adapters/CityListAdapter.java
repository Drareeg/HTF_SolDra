package solmovdrareeg.htf_soldra.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import solmovdrareeg.htf_soldra.model.City;

/**
 * Created by Drareeg on 05.12.14.
 */
//@EBean
public class CityListAdapter extends BaseAdapter {

    List<City> cities;
//    @RootContext
//    Context context;
//
    @Override
    public int getCount() {
        return cities.size();
    }


    public void add(City city){
        cities.add(city);
    }

    @Override
    public City getItem(int position) {
        return cities.get(position);
    }
//
    @Override
    public long getItemId(int position) {
        return position;
    }
//
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        CityItemView userProfileItemView = null;
////        if (convertView == null) {
////            userProfileItemView = UserProfileItemView_.build(context);
////        } else {
////            userProfileItemView = (CityItemView) convertView;
////        }
////
////        userProfileItemView.bind(getItem(position));
//
       //return userProfileItemView;
        return null;    }
//
//    public void clear() {
//        persons = new ArrayList<ContactablePerson>();
//    }
}
