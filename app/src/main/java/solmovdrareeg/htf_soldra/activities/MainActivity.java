package solmovdrareeg.htf_soldra.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import solmovdrareeg.htf_soldra.R;
import solmovdrareeg.htf_soldra.model.City;
import solmovdrareeg.htf_soldra.util.RestClient;
import solmovdrareeg.htf_soldra.util.TabsPagerAdapter;


@EActivity
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
    @RestService
    RestClient restClient;

    private ActionBar actionBar;
    private FragmentManager fm;
    private TabsPagerAdapter adapter;

    @ViewById(R.id.viewpager)
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menu bar stuff
        actionBar = getActionBar();
        actionBar.setTitle("Overzicht");
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        fm = getSupportFragmentManager();

        adapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Overzicht")
                        .setTabListener(this));
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Tips")
                        .setTabListener(this));

        actionBar.addTab(
                actionBar.newTab()
                        .setText("Favoriete steden")
                        .setTabListener(this));


    }

    //Menu bar stuff

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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
        switch(tab.getPosition())
        {
            case 0 : actionBar.setTitle("Overzicht");
                break;
            case 1 : actionBar.setTitle("Tips");
                break;
            case 2 : actionBar.setTitle("Favoriete steden");
                break;
        }

        /**
          * on swiping the viewpager make respective tab selected
          * */
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
