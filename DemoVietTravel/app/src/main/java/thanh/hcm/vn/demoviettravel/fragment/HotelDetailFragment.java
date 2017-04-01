package thanh.hcm.vn.demoviettravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;

/**
 * Created by phamquocthanh on 3/21/2017.
 */

public class HotelDetailFragment extends BaseFragment {

    private View view;
    private Context context;

    private  static HotelDetailFragment hotelDetailFragment = null;

    public static HotelDetailFragment getInstall(){
        if(hotelDetailFragment == null){
            hotelDetailFragment = new HotelDetailFragment();
        }
        return hotelDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_hotel_detail, null);
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

    private void initView(View view){
        MainActivity.setEnableResideMenu(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.hotel_detail_page), true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        view = null;
        MainActivity.setEnableResideMenu(true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}

