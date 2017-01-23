package thanh.hcm.vn.demoviettravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.adapter.ListFoodAdapter;
import thanh.hcm.vn.demoviettravel.adapter.ListHotelAdapter;
import thanh.hcm.vn.demoviettravel.model.FoodModel;
import thanh.hcm.vn.demoviettravel.model.HotelModel;

/**
 * Created by thanh on 1/18/2017.
 */

public class HotelsFragment extends BaseFragment {
    private View view;
    private Context context;
    RecyclerView rcvListHotel;
    ArrayList<HotelModel> arrayListHotel= new ArrayList<>();

    private  static HotelsFragment hotelFragment=null;

    public static HotelsFragment getInstall(){
        if(hotelFragment == null){
            hotelFragment = new HotelsFragment();
        }
        return hotelFragment;
    }

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_hotels, null);
            initView(view);

        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }

    private void initView(View view){

        rcvListHotel =(RecyclerView) view.findViewById(R.id.rcvListHotel);

        arrayListHotel.add(new HotelModel(1,R.drawable.imageone,"Lúa Nếp","Sóc Trăng",1f));
        arrayListHotel.add(new HotelModel(2,R.drawable.imagefive,"Vincom","Nha Trang",2.5f));
        arrayListHotel.add(new HotelModel(3,R.drawable.imagesfour,"CoCo Beach","Thái Lan",3f));
        arrayListHotel.add(new HotelModel(4,R.drawable.imagessix,"Thanh Hoa","Hà Nội",4.2f));
        arrayListHotel.add(new HotelModel(5,R.drawable.imagetree,"Thanh Thanh","Hà Nội",5));
        arrayListHotel.add(new HotelModel(6,R.drawable.imagetwo,"New Wold","Sài Gòn",3));
        arrayListHotel.add(new HotelModel(7,R.drawable.imagesfour,"Jupiter","Hội An",2));

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListHotel.setLayoutManager(llm);

        ListHotelAdapter placeAdapter = new ListHotelAdapter(context,arrayListHotel);
        rcvListHotel.setAdapter(placeAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_hotel_page), true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
