package solmovdrareeg.htf_soldra.util;

import org.androidannotations.annotations.sharedpreferences.DefaultStringSet;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

import java.util.Set;

import solmovdrareeg.htf_soldra.model.CityList;

/**
 * Created by Drareeg on 11.12.14.
 */
@SharedPref
public interface MyPrefs {

    @DefaultStringSet
    Set<String> favoritedCityIds();


    long lastUpdated();
}
