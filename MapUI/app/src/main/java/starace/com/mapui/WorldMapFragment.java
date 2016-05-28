package starace.com.mapui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by mstarace on 5/27/16.
 */
public class WorldMapFragment extends Fragment {
    private View mapFragmentView;
    private ImageView mapImage;
    private int mapId;
    private WorldMapListener mapListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle mapBundle) {
        mapFragmentView = inflater.inflate(R.layout.map_fragment,container,false);
        mapId = getArguments().getInt(MainActivity.KEY_MAP_BUNDLE, -1);
        mapImage = (ImageView) mapFragmentView.findViewById(R.id.map_image);
        mapImage.setImageResource(mapId);
        initMapFragmentClickListener();

        return mapFragmentView;
    }

    public void initMapFragmentClickListener(){
        ViewGroup root = (ViewGroup) getActivity().findViewById(R.id.fragment_relative_layout);
        mapListener = new WorldMapListener(getActivity(),null, root);
        mapImage.setOnTouchListener(mapListener);

    }

}
