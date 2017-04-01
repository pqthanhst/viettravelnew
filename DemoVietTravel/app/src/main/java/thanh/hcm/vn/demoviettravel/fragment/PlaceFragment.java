package thanh.hcm.vn.demoviettravel.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DecimalFormat;
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
    ImageView img,img2,img3,img4,img5;

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

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();

        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        widthScreen = width / 100;
        heightScreen = height / 100;

        rlListPlace.setVisibility(View.GONE);

        FrameLayout root = (FrameLayout)view.findViewById(R.id.root);

        DecimalFormat format = new DecimalFormat("#");

        img = new ImageView(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(Math.round(getResources().getDimension(R.dimen._120sdp)), Math.round(getResources().getDimension(R.dimen._80sdp)));
        params.leftMargin = Math.round(getResources().getDimension(R.dimen._48sdp));
        params.topMargin  = Math.round(getResources().getDimension(R.dimen._15sdp));
        root.addView(img, params);
        img.setOnClickListener(this);

        img2 = new ImageView(context);
        //img2.setBackgroundColor(Color.CYAN);
        FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(Math.round(getResources().getDimension(R.dimen._120sdp)), Math.round(getResources().getDimension(R.dimen._85sdp)));
        params2.leftMargin = Math.round(getResources().getDimension(R.dimen._78sdp)) ;
        params2.topMargin  = Math.round(getResources().getDimension(R.dimen._96sdp));
        root.addView(img2, params2);
        img2.setOnClickListener(this);


        img3 = new ImageView(context);
        //img3.setBackgroundColor(Color.BLACK);
        FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams(Math.round(getResources().getDimension(R.dimen._100sdp)), Math.round(getResources().getDimension(R.dimen._94sdp)));
        params3.leftMargin = Math.round(getResources().getDimension(R.dimen._120sdp)) ;
        params3.topMargin  = Math.round(getResources().getDimension(R.dimen._182sdp));
        root.addView(img3, params3);

        img3.setOnClickListener(this);


        img4 = new ImageView(context);
        //img4.setBackgroundColor(Color.WHITE);
        FrameLayout.LayoutParams params4 = new FrameLayout.LayoutParams(Math.round(getResources().getDimension(R.dimen._110sdp)),Math.round(getResources().getDimension(R.dimen._60sdp)));
        params4.leftMargin = Math.round(getResources().getDimension(R.dimen._110sdp)) ;
        params4.topMargin  = Math.round(getResources().getDimension(R.dimen._276sdp));
        root.addView(img4, params4);
        img4.setOnClickListener(this);

        img5 = new ImageView(context);
        //img5.setBackgroundColor(Color.YELLOW);
        FrameLayout.LayoutParams params5 = new FrameLayout.LayoutParams(Math.round(getResources().getDimension(R.dimen._90sdp)), Math.round(getResources().getDimension(R.dimen._110sdp)));
        params5.leftMargin = Math.round(getResources().getDimension(R.dimen._50sdp)) ;
        params5.topMargin  = Math.round(getResources().getDimension(R.dimen._310sdp));
        root.addView(img5, params5);
        img5.setOnClickListener(this);
        //get color pixel

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

    @Override
    public void onDetach() {
        super.onDetach();
        rlListPlace.setVisibility(View.GONE);
        Contants.currentStatus = 0;
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
        if(view == img){
            Toast.makeText(context, "Mien Bac", Toast.LENGTH_SHORT).show();
            rlListPlace.setVisibility(View.VISIBLE);
            Contants.currentStatus = 1;
        }else if(view == img2){
            Toast.makeText(context, "Mien Trung Bac", Toast.LENGTH_SHORT).show();
        }else if(view == img3){
            Toast.makeText(context, "Mien Trung Nam", Toast.LENGTH_SHORT).show();
        }else if(view == img4){
            Toast.makeText(context, "Mien Trung Nam", Toast.LENGTH_SHORT).show();
        }else if(view == img5){
            Toast.makeText(context, "Mien Nam", Toast.LENGTH_SHORT).show();
        }
    }

   public void itemListPlaceClick(){
       switchFragment(context.getString(R.string.place_detail_page), null, false);
   }
}
