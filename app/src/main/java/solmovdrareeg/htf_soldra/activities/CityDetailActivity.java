package solmovdrareeg.htf_soldra.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.api.sharedpreferences.StringSetPrefField;

import java.util.HashSet;
import java.util.Set;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.City;

@EActivity
public class CityDetailActivity extends Activity {

    @Extra
    City city = new City();

    @ViewById
    TextView gemeenteTextView;

    @ViewById
    Button favoriteButton;


    private String unfav = "Unfavorite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

    }

    @AfterExtras
    public void doAfterExtra(){

    }



    @AfterViews
    public void doAfterViews(){
        HashSet<String> empty = new HashSet<String>();
        SharedPreferences prefs = getSharedPreferences(String.valueOf(R.string.preferences), MODE_PRIVATE);
        Set<String> prefids = prefs.getStringSet("prefids", empty);


        gemeenteTextView.setText(city.getName());
        if(!prefids.contains(city.getId())){
            favoriteButton.setText("Add to favorites");
        }else{
            favoriteButton.setText(unfav);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Click(R.id.favoriteButton)
    public void doFavAction(){
        HashSet<String> empty = new HashSet<String>();
        SharedPreferences prefs = getSharedPreferences(String.valueOf(R.string.preferences), MODE_PRIVATE);
        Set<String> prefids = prefs.getStringSet("prefids", empty);


        if(favoriteButton.getText().toString().equals(unfav)){
            //remove from pref

            prefids.remove(city.getId()+"");

        }else{
            prefids.add(city.getId()+"");
            System.out.println("added to prefs");
        }
        SharedPreferences.Editor editor = getSharedPreferences(String.valueOf(R.string.preferences), MODE_PRIVATE).edit();
        editor.putStringSet("prefids", prefids);
        editor.commit();
    }


}
