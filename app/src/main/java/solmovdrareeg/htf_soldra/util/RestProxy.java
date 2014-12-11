package solmovdrareeg.htf_soldra.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.androidannotations.annotations.rest.RestService;

import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.model.CityList;

/**
 * Created by Drareeg on 11.12.14.
 */
public class RestProxy {

    Context context;

    public RestProxy(Context context){
        this.context = context;
    }

    @RestService
    RestClient restClient;

    CityList getAllCities(){
        if(haveNetworkConnection()){
            return restClient.getAllCities();
        }else{
            //TODO
            return null;
        }
    }

    City getById(long id){
        if(haveNetworkConnection()){
            return restClient.getById(id);
        }else{
            //TODO
            return null;
        }

    }

    CityList getByProvince(String province){
        if(haveNetworkConnection()){
            return restClient.getByProvince(province);
        }else{
            return null;
        }
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
