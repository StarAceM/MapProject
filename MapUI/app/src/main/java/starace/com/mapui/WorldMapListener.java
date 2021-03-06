package starace.com.mapui;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mstarace on 5/27/16.
 */
public class WorldMapListener extends View implements View.OnTouchListener{
    private ViewGroup root;
    private Context context;
    private View mapView;
    private String[] continents;
    private List<Rect> worldMapRects;

    public WorldMapListener(Context context, AttributeSet attrs, ViewGroup root) {
        super(context, attrs);
        this.context = context;
        this.root = root;
        this.continents = context.getResources().getStringArray(R.array.continents);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mapView = v;
        final int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                String location = checkTouchLocation((int)event.getRawX(),(int)event.getRawY());
                WorldMapClick continentSetter = (WorldMapClick) context;
                continentSetter.setContinentFragment(location);
//                Toast.makeText(context,"The Continent Selected is " +location,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return true;
    }

    private String checkTouchLocation(int x, int y){

        for (int i = 0; i < worldMapRects.size();i++){
           if(worldMapRects.get(i).contains(x,y)){
               return continents[i];
           }
        }

        return "";
    }

    public interface WorldMapClick{
        void setContinentFragment(String continent);
    }

    public void createRectangles(){
        worldMapRects = new ArrayList<>();
        for(int i = 0; i < continents.length; i++){

            switch (continents[i]){
                case "North America":
                    //will need to be relative values based on screen size
                    Rect curContinentRect = new Rect(20,750,500,1080);
                    Log.d("Listener", curContinentRect.height() + " " + curContinentRect.width() + " " +curContinentRect.exactCenterX());
                    worldMapRects.add(i,curContinentRect);
                    break;
                default:
                    break;

            }
        }
    }

}
