package starace.com.mapui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    public static final String KEY_MAP_BUNDLE = "Map_ID";
    private FrameLayout mapContainerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews(){
        //mapContainerLayout = (FrameLayout) findViewById(R.id.framelayout_map_fragment);
        WorldMapFragment worldFragment = new WorldMapFragment();
        Bundle mapBundle = new Bundle();
        mapBundle.putInt(KEY_MAP_BUNDLE, R.drawable.world_map_continents);
        worldFragment.setArguments(mapBundle);

        FragmentManager mapFragmentManager = getSupportFragmentManager();
        mapFragmentManager.beginTransaction()
                .add(R.id.framelayout_map_fragment,worldFragment)
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
