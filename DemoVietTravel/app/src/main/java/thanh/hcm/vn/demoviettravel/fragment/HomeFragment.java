package thanh.hcm.vn.demoviettravel.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;
import thanh.hcm.vn.demoviettravel.adapter.ListPlaceMainAdapter;
import thanh.hcm.vn.demoviettravel.adapter.SlidingImage_Adapter;
import thanh.hcm.vn.demoviettravel.model.PlaceModel;
import thanh.hcm.vn.demoviettravel.utils.StartSnapHelper;


public class HomeFragment extends BaseFragment {


    private View view;
    private Context context;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES2= {R.drawable.imageone,R.drawable.imagetwo,R.drawable.imagetree,R.drawable.imagesfour,R.drawable.imagefive,R.drawable.one,R.drawable.two,R.drawable.five,R.drawable.six,R.drawable.three};
    private static final Integer[] IMAGES= {R.drawable.one,R.drawable.two,R.drawable.five,R.drawable.six,R.drawable.three};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    private ArrayList<Integer> ImagesArrayPlace = new ArrayList<Integer>();
    //recycelview
    private List<PlaceModel> arrayListPlace = new ArrayList<>();
    private RecyclerView recyclerView, rvPlaceHot;

    private TextView ivTitleHotPlace,ivTitleNewPlace;

    private LinearLayout lnHome;

    private  static HomeFragment homeFragment=null;

    public static HomeFragment getInstall(){
        if(homeFragment == null){
            homeFragment = new HomeFragment();
        }
        return homeFragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, null);
            initView(view);

        }
        else{
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }

    private void initView(View view) {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        for(int i=0;i<IMAGES2.length;i++)
            ImagesArrayPlace.add(IMAGES2[i]);

        addlistPlace();
        lnHome=(LinearLayout)view.findViewById(R.id.lnHome);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(context,ImagesArray));
        rvPlaceHot =(RecyclerView) view.findViewById(R.id.rvPlaceHot);
        recyclerView =(RecyclerView) view.findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager llmHot = new LinearLayoutManager(context);
        llmHot.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(llm);
        rvPlaceHot.setLayoutManager(llmHot);

        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);
        SnapHelper startSnapHelper2 = new StartSnapHelper();
        startSnapHelper2.attachToRecyclerView(rvPlaceHot);

        ListPlaceMainAdapter placeMainAdapter= new ListPlaceMainAdapter(getActivity(),arrayListPlace);
        recyclerView.setAdapter(placeMainAdapter);

        ListPlaceMainAdapter placeHotMainAdapter= new ListPlaceMainAdapter(getActivity(),arrayListPlace);
        rvPlaceHot.setAdapter(placeHotMainAdapter);

        ivTitleHotPlace=(TextView) view.findViewById(R.id.ivTitleHotPlace);
        ivTitleNewPlace=(TextView) view.findViewById(R.id.ivTitleNewPlace);

        Typeface typeface= Typeface.createFromAsset(context.getAssets(), "FontAwesometwo.otf");
        ivTitleHotPlace.setTypeface(typeface);
        ivTitleNewPlace.setTypeface(typeface);

        CirclePageIndicator indicator = (CirclePageIndicator)
                view.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
        mPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){

                    MainActivity.setEnableResideMenu(false);

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    MainActivity.setEnableResideMenu(true);
                }
                return false;
            }
        });

        lnHome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){

                    MainActivity.setEnableResideMenu(true);

                }
                return false;
            }
        });

    }

    private void addlistPlace(){
        arrayListPlace.add(new PlaceModel(1, R.drawable.imageone, "Fansipan", "Sapa", "Thang 10 - Thang 11"));
        arrayListPlace.add(new PlaceModel(2, R.drawable.imagefive, "Vinh Ha Long", "Ha Long", "Thang 6 - Thang 9"));
        arrayListPlace.add(new PlaceModel(3, R.drawable.imagesfour, "Phong Nha ", "Thanh Hoa", "Thang 2 - Thang 3"));
        arrayListPlace.add(new PlaceModel(4, R.drawable.imagessix, "Vung Tau", "Vung Tau", "Thang 3 - Thang 4"));
        arrayListPlace.add(new PlaceModel(5, R.drawable.imagetree, "Ca Mau", "Ca Mau", "Thang 1 - Thang 5"));
        arrayListPlace.add(new PlaceModel(6, R.drawable.imagetwo, "Tram Chim", "Tram Chim", "Thang 4 - Thang 8"));
        arrayListPlace.add(new PlaceModel(7, R.drawable.imagesfour, "Thap Rua", "Ha Noi", "Thang 7 - Thang 1"));
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_home_page), true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

    }
}
