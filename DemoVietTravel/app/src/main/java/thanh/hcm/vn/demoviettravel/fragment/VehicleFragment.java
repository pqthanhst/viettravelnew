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
import thanh.hcm.vn.demoviettravel.adapter.ListVehicleAdapter;
import thanh.hcm.vn.demoviettravel.model.FoodModel;
import thanh.hcm.vn.demoviettravel.model.VehicleModel;

/**
 * Created by thanh on 1/18/2017.
 */

public class VehicleFragment extends BaseFragment {

    View view;
    Context context;
    RecyclerView rcvListVehicle;
    ArrayList<VehicleModel> arrayListVehicle= new ArrayList<>();

    private  static VehicleFragment vehicleFragment=null;

    public static VehicleFragment getInstall(){
        if(vehicleFragment==null){
            vehicleFragment=new VehicleFragment();
        }
        return vehicleFragment;
    }

    public VehicleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_vehicle, null);
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

        rcvListVehicle =(RecyclerView) view.findViewById(R.id.rcvListVehicle);

        arrayListVehicle.add(new VehicleModel(1,R.drawable.imageone,"Mai Linh","Toan Quoc",2.5f));
        arrayListVehicle.add(new VehicleModel(2,R.drawable.imagefive,"Bún Cá","Nha Trang",3.5f));
        arrayListVehicle.add(new VehicleModel(3,R.drawable.imagesfour,"Lẩu Thái","Thái Lan",1.5f));
        arrayListVehicle.add(new VehicleModel(4,R.drawable.imagessix,"Chả Cá Lã Vọng","Hà Nội",4.5f));
        arrayListVehicle.add(new VehicleModel(5,R.drawable.imagetree,"Nem Cua","Hà Nội",3.5f));
        arrayListVehicle.add(new VehicleModel(6,R.drawable.imagetwo,"Bánh Mì","Sài Gòn",4.5f));
        arrayListVehicle.add(new VehicleModel(7,R.drawable.imagesfour,"Bánh Bèo","Hội An",3.7f));

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListVehicle.setLayoutManager(llm);

        ListVehicleAdapter placeAdapter = new ListVehicleAdapter(context,arrayListVehicle);
        rcvListVehicle.setAdapter(placeAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_vehicle_page), true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
