package starace.com.mapui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mstarace on 5/29/16.
 */
public class ContinentFragment extends Fragment {
    private View continentFragmentView;
    private TextView continentTitle;
    private Spinner continentSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        continentFragmentView = inflater.inflate(R.layout.continent_fragment,container,false);
        setUpViews(getArguments().getString(MainActivity.KEY_CONTINENT_BUNDLE,"no continent"));
        return continentFragmentView;
    }

    private void setUpViews(String continent){
        continentTitle = (TextView) continentFragmentView.findViewById(R.id.continent_title);
        continentSpinner = (Spinner) continentFragmentView.findViewById(R.id.continent_spinner);
        Log.d("ContinentFragment", "This is the continent " + continent);
        continentTitle.setText(continent);
        setUpSpinnerData();

    }

    private void setUpSpinnerData(){
        List<String> spinnerList;
        spinnerList = Arrays.asList(getResources().getStringArray(R.array.north_america_languages));
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,spinnerList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        continentSpinner.setAdapter(spinnerAdapter);

    }

}
