package starace.com.mapui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements WorldMapListener.WorldMapClick{
    public static final String KEY_MAP_BUNDLE = "Map_ID";
    public static final String KEY_CONTINENT_BUNDLE = "Continent_Name";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews(){
        WorldMapFragment worldFragment = new WorldMapFragment();
        Bundle mapBundle = new Bundle();
        mapBundle.putInt(KEY_MAP_BUNDLE, R.drawable.world_map_continents);
        worldFragment.setArguments(mapBundle);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.framelayout_map_fragment,worldFragment)
                .commit();

    }

    @Override
    public void setContinentFragment(String continent) {
        //create and swap fragment here
        Log.d("MainActivity", "This is the continent passed from the listener " + continent);
        ContinentFragment continentFragment = new ContinentFragment();
        Bundle continentBundle = new Bundle();
        continentBundle.putString(KEY_CONTINENT_BUNDLE, continent);
        continentFragment.setArguments(continentBundle);
        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_map_fragment,continentFragment)
                .addToBackStack(null)
                .commit();

    }

    private void initDefault(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

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
