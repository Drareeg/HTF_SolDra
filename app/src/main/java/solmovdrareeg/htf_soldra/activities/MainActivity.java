package solmovdrareeg.htf_soldra.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.util.MyPrefs;
import solmovdrareeg.htf_soldra.util.MyPrefs_;
import solmovdrareeg.htf_soldra.util.RestClient;


@EActivity
public class MainActivity extends Activity {

    @ViewById(R.id.textView)
    public TextView textView;

    @RestService
    RestClient restClient;

    @Pref
    MyPrefs_ mypref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         testApi();

    }

    @Click(R.id.button)
    public void addFavCity() {
        Set<String> originalNames = mypref.favoritedCityNames().get();
        if (originalNames == null) {
            originalNames = new HashSet<String>();
        }
        Random r = new Random();
        originalNames.add("tits" + r.nextInt(50));
        mypref.edit().favoritedCityNames().put(originalNames).apply();
        showPrefs();
    }

    @Background
    public void testApi() {
        showName(restClient.getById(4503989127217152l).getName());
    }

    @UiThread
    public void showName(String name) {
        textView.setText(name);
    }

    public void showPrefs() {
        String prefCities = "";
        if (mypref.favoritedCityNames() != null) {
            for (String c : mypref.favoritedCityNames().get()) {
                prefCities += c;
            }
        }
        showName(prefCities);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
