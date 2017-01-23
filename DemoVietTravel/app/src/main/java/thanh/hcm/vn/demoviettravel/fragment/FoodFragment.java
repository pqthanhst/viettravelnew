package thanh.hcm.vn.demoviettravel.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.adapter.ListFoodAdapter;
import thanh.hcm.vn.demoviettravel.adapter.ListPlaceAdapter;
import thanh.hcm.vn.demoviettravel.model.FoodModel;
import thanh.hcm.vn.demoviettravel.model.PlaceModel;

import static thanh.hcm.vn.demoviettravel.R.id.rcvListPlace;


public class FoodFragment extends BaseFragment {


    View view;
    Context context;
    RecyclerView rcvListFood;
    ArrayList<FoodModel> arrayListFood= new ArrayList<>();

    private  static FoodFragment foodFragment=null;

    public static FoodFragment getInstall(){
        if(foodFragment==null){
            foodFragment=new FoodFragment();
        }
        return foodFragment;
    }

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_food, null);
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

        rcvListFood =(RecyclerView) view.findViewById(R.id.rcvListFood);

        arrayListFood.add(new FoodModel(1,R.drawable.imageone,"Bún Mắm","Sóc Trăng","2 - 3"));
        arrayListFood.add(new FoodModel(2,R.drawable.imagefive,"Bún Cá","Nha Trang","2 - 3"));
        arrayListFood.add(new FoodModel(3,R.drawable.imagesfour,"Lẩu Thái","Thái Lan","5 - 7"));
        arrayListFood.add(new FoodModel(4,R.drawable.imagessix,"Chả Cá Lã Vọng","Hà Nội","5 - 7"));
        arrayListFood.add(new FoodModel(5,R.drawable.imagetree,"Nem Cua","Hà Nội","2 - 3"));
        arrayListFood.add(new FoodModel(6,R.drawable.imagetwo,"Bánh Mì","Sài Gòn","1 - 3"));
        arrayListFood.add(new FoodModel(7,R.drawable.imagesfour,"Bánh Bèo","Hội An","2 - 4"));

        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListFood.setLayoutManager(llm);

        ListFoodAdapter placeAdapter = new ListFoodAdapter(context,arrayListFood);
        rcvListFood.setAdapter(placeAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_food_page), true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

}
