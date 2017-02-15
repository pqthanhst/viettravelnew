package thanh.hcm.vn.demoviettravel.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.adapter.ListPlaceAdapter;
import thanh.hcm.vn.demoviettravel.model.PlaceModel;
import thanh.hcm.vn.demoviettravel.utils.Contants;

/**
 * Created by thanh on 1/18/2017.
 */

public class PlaceFragment extends BaseFragment {
    View view;
    Context context;
    ImageView ivMapPlace;
    private MotionEvent simulationEvent;
    int widthScreen, heightScreen;
    LinearLayout rlListPlace;
    ArrayList<PlaceModel> arrayListPlace = new ArrayList<>();
    RecyclerView rcvListPlace;

    private static PlaceFragment placeFragment = null;

    public static PlaceFragment getInstall() {
        if (placeFragment == null) {
            placeFragment = new PlaceFragment();
        }
        return placeFragment;
    }

    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_place, null);
            initView(view);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }

    private void initView(View view) {

        ivMapPlace = (ImageView) view.findViewById(R.id.ivMapPlace);
        rlListPlace = (LinearLayout) view.findViewById(R.id.rlListPlace);
        rcvListPlace = (RecyclerView) view.findViewById(R.id.rcvListPlace);

<<<<<<< HEAD
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
=======
        Log.e("color bac :","red :"+Color.red(bitmapBac.getPixel(5,5))+"-green :"+Color.green(bitmapBac.getPixel(5,5))+"-blue :"+Color.blue(bitmapBac.getPixel(5,5)));
        Log.e("color trung bac :","red :"+Color.red(bitmapTrungBac.getPixel(5,5))+"-green :"+Color.green(bitmapTrungBac.getPixel(5,5))+"-blue :"+Color.blue(bitmapTrungBac.getPixel(5,5)));
        Log.e("color trung nam :","red :"+Color.red(bitmapTrungNam.getPixel(5,5))+"-green :"+Color.green(bitmapTrungNam.getPixel(5,5))+"-blue :"+Color.blue(bitmapTrungNam.getPixel(5,5)));
        Log.e("color bitmap nam :","red :"+Color.red(bitmapNam.getPixel(5,5))+"-green :"+Color.green(bitmapNam.getPixel(5,5))+"-blue :"+Color.blue(bitmapNam.getPixel(5,5)));

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
>>>>>>> origin/master
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        widthScreen = width / 100;
        heightScreen = height / 100;

        rlListPlace.setVisibility(View.GONE);

        //get color pixel

        final Bitmap bitmap = ((BitmapDrawable) ivMapPlace.getDrawable()).getBitmap();


        ivMapPlace.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event == simulationEvent)
                    return false;
                int action = event.getAction();
                int x = (int) event.getX();
                int y = (int) event.getY();

                int pixel = bitmap.getPixel(x, y);

                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);

                Log.e("color bitmap :","red :"+red +"-green :"+green+"-blue :"+blue);

                Log.e("onTouchListener", "User touch at X:" + x + " Y:" + y);
                long length = 0;
                if (action == MotionEvent.ACTION_DOWN) {

                    //click(v, x, y);
<<<<<<< HEAD
//                    if (x >= widthScreen * 15 && x <= widthScreen * 63 && y >= heightScreen * 2 && y <= heightScreen * 19) {
//                        Toast.makeText(context, "Mien Bac", Toast.LENGTH_SHORT).show();
//                        rlListPlace.setVisibility(View.VISIBLE);
//                        Contants.currentStatus = 1;
//                    } else if (x >= widthScreen * 35 && x <= widthScreen * 68 && y >= heightScreen * 19 && y <= heightScreen * 37) {
//                        Toast.makeText(context, "Mien Trung Bac", Toast.LENGTH_SHORT).show();
//                    } else if (x >= widthScreen * 36 && x <= widthScreen * 77 && y >= heightScreen * 37 && y <= heightScreen * 58) {
//                        Toast.makeText(context, "Mien Trung Nam", Toast.LENGTH_SHORT).show();
//                    } else if (x >= widthScreen * 18 && x <= widthScreen * 48 && (y >= heightScreen * 58 || y >= heightScreen * 55) && y <= heightScreen * 80) {
//                        Toast.makeText(context, "Mien Nam", Toast.LENGTH_SHORT).show();
//                    }
                    if(checkIsPlaceBac(x,y)){
                        Toast.makeText(context, "Mien Bac", Toast.LENGTH_SHORT).show();
                        rlListPlace.setVisibility(View.VISIBLE);
                        Contants.currentStatus = 1;
                    }else if(checkIsPlaceTrungBac(x,y)){
                        Toast.makeText(context, "Mien Trung Bac", Toast.LENGTH_SHORT).show();
                    }else if(checkIsPlaceTrungNam(x,y)){
                        Toast.makeText(context, "Mien Trung Nam", Toast.LENGTH_SHORT).show();
                    }else if(checkIsPlaceNam(x,y)){
                        Toast.makeText(context, "Mien Nam", Toast.LENGTH_SHORT).show();
=======
                    if(x>=widthScreen*15 && x<=widthScreen*63 && y>=heightScreen*2 && y<=heightScreen*19){
                        Toast.makeText(context,"Mien Bac",Toast.LENGTH_SHORT).show();
                        rlListPlace.setVisibility(View.VISIBLE);
                        Contants.currentStatus = 1;
                    }else if(x>=widthScreen*35 && x<=widthScreen*68 && y>=heightScreen*19 && y<=heightScreen*37){
                        Toast.makeText(context,"Mien Trung Bac",Toast.LENGTH_SHORT).show();
                    }else if(x>=widthScreen*36 && x<=widthScreen*77 && y>=heightScreen*37 && y<=heightScreen*58){
                        Toast.makeText(context,"Mien Trung Nam",Toast.LENGTH_SHORT).show();
                    }else if(x>=widthScreen*18 && x<=widthScreen*48 && (y>=heightScreen*58 || y>=heightScreen*55) && y<=heightScreen*80){
                        Toast.makeText(context,"Mien Nam",Toast.LENGTH_SHORT).show();
>>>>>>> origin/master
                    }

//                    if(red == Color.red(bitmapBac.getPixel(5,5)) && green == Color.green(bitmapBac.getPixel(5,5)) && blue == Color.blue(bitmapBac.getPixel(5,5))){
//                        Toast.makeText(context,"Mien Bac",Toast.LENGTH_SHORT).show();
//                        rlListPlace.setVisibility(View.VISIBLE);
//                        Contants.currentStatus = 1;
//                    }
//                    else if(red == Color.red(bitmapTrungBac.getPixel(5,5)) && green == Color.green(bitmapTrungBac.getPixel(5,5)) && blue == Color.blue(bitmapTrungBac.getPixel(5,5))){
//                        Toast.makeText(context,"Mien Trung Bac",Toast.LENGTH_SHORT).show();
//                    }else if(red==Color.red(bitmapTrungNam.getPixel(5,5)) && green == Color.green(bitmapTrungNam.getPixel(5,5)) && blue == Color.blue(bitmapTrungNam.getPixel(5,5))){
//                        Toast.makeText(context,"Mien Trung Nam",Toast.LENGTH_SHORT).show();
//                    }else if(red ==Color.red(bitmapNam.getPixel(5,5)) && green == Color.green(bitmapNam.getPixel(5,5)) && blue == Color.blue(bitmapNam.getPixel(5,5))){
//                        Toast.makeText(context,"Mien Nam",Toast.LENGTH_SHORT).show();
//                    }
                }
                return false;
            }
        });
        arrayListPlace.add(new PlaceModel(1, R.drawable.imageone, "Fansipan", "Sapa", "Thang 10 - Thang 11"));
        arrayListPlace.add(new PlaceModel(2, R.drawable.imagefive, "Vinh Ha Long", "Ha Long", "Thang 6 - Thang 9"));
        arrayListPlace.add(new PlaceModel(3, R.drawable.imagesfour, "Phong Nha ", "Thanh Hoa", "Thang 2 - Thang 3"));
        arrayListPlace.add(new PlaceModel(4, R.drawable.imagessix, "Vung Tau", "Vung Tau", "Thang 3 - Thang 4"));
        arrayListPlace.add(new PlaceModel(5, R.drawable.imagetree, "Ca Mau", "Ca Mau", "Thang 1 - Thang 5"));
        arrayListPlace.add(new PlaceModel(6, R.drawable.imagetwo, "Tram Chim", "Tram Chim", "Thang 4 - Thang 8"));
        arrayListPlace.add(new PlaceModel(7, R.drawable.imagesfour, "Thap Rua", "Ha Noi", "Thang 7 - Thang 1"));


        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListPlace.setLayoutManager(llm);

        ListPlaceAdapter placeAdapter = new ListPlaceAdapter(context, arrayListPlace);
        rcvListPlace.setAdapter(placeAdapter);
    }

    private boolean checkIsPlaceBac(int x, int y) {
        boolean isStatus = false;
        if (x >= widthScreen * 15 && x <= widthScreen * 63 && y >= heightScreen * 2 && y <= heightScreen * 19) {
            isStatus = true;
        }
        return isStatus;
    }

    private boolean checkIsPlaceTrungBac(int x, int y) {
        boolean isStatus = false;
        //if(x>=widthScreen*35 && x<=widthScreen*68 && y>=heightScreen*19 && y<=heightScreen*37){
        if (x >= widthScreen * 35 && x <= widthScreen * 50 && y >= heightScreen * 19 && y <= heightScreen * 25) {
            isStatus = true;
        } else if (x >= widthScreen * 50 && x <= widthScreen * 60 && y >= heightScreen * 25 && y <= heightScreen * 30) {
            isStatus = true;
        } else if (x >= widthScreen * 60 && x <= widthScreen * 68 && y >= heightScreen * 30 && y <= heightScreen * 37) {
            isStatus = true;
        }
        return isStatus;
    }

    private boolean checkIsPlaceTrungNam(int x, int y) {
        boolean isStatus = false;
        if (x >= widthScreen * 66 && x <= widthScreen * 77 && y >= heightScreen * 37 && y <= heightScreen * 48) {
            isStatus=true;
        }else if(x >= widthScreen * 36 && x <= widthScreen * 77 && y >= heightScreen * 48 && (y <= heightScreen * 58 || y <= heightScreen * 60)){
            isStatus=true;
        }
        return isStatus;
    }

    private boolean checkIsPlaceNam(int x, int y){
        boolean isStatus = false;
        if(x >= widthScreen * 18 && x <= widthScreen * 48 && y >= heightScreen * 55 && y <= heightScreen * 80){
            isStatus=true;
        }
        return isStatus;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_place_page), true);

        //EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(Integer currentStatus) {
        Log.e("Current place event", currentStatus + "");
        if (currentStatus == 1) {
            rlListPlace.setVisibility(View.GONE);
            Contants.currentStatus = 0;
        }
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }


}
