package solmovdrareeg.htf_soldra.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;

import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.model.CityList;

/**
 * Created by Drareeg on 11.12.14.
 */
@EBean
public class RestProxy {

    Context context;

    public RestProxy(Context context){
        this.context = context;
    }

    @RestService
    RestClient restClient;

    public void injectClient(RestClient client){
        this.restClient = client;

    }

    public CityList getAllCities(){
        if(haveNetworkConnection()){
            return restClient.getAllCities();
        }else{
            //TODO
            return null;
        }
    }

    public City getById(long id){
        if(haveNetworkConnection()){
            return restClient.getById(id);
        }else{
            //TODO
            return null;
        }

    }

    public CityList getByProvince(String province){
        if(haveNetworkConnection()){
            return restClient.getByProvince(province);
        }else{
            return null;
        }
    }

    public CityList getByName(String gemeente){
        ArrayList<City> foundCities = new ArrayList();

        CityList allCities = getAllCities();
        for(City city : allCities.getItems()){
            if(city.getName().contains(gemeente)){
                foundCities.add(city);
            }
        }
        CityList filteredCities = new CityList();
        filteredCities.setItems(foundCities.toArray(new City[foundCities.size()]));
        return filteredCities;
    }


    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

}
