package thanh.hcm.vn.demoviettravel.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import thanh.hcm.vn.demoviettravel.activity.MainActivity;

/**
 * Created by phamquocthanh on 1/21/2017.
 */
//PopupCallback,JsonCallback,
public class BaseFragment extends Fragment implements  View.OnClickListener {


    private Activity activity;

    public void setFragmentActivity(Activity activity) {
        this.activity = activity;
    }

    public void  switchFragment(String fragmentName, Bundle bundle, boolean isAddToBackStack){
        if(activity !=null ){

            if(activity instanceof MainActivity){
                ((MainActivity)activity).switchFragment(fragmentName, bundle, isAddToBackStack);
            }
        }

    }

    public void updateGA(String title, boolean showMenu){
        if(activity !=null ){

            if(activity instanceof MainActivity){
                ((MainActivity)activity).updateGA(title, showMenu);
            }
        }
    }

    @Override
    public void onClick(View view) {

    }

//    @Override
//    public void jsonCallback(Object data, int processID, int index) {
//
//    }
//
//    @Override
//    public void jsonError(String msg, int processID) {
//
//    }
//
//    @Override
//    public void popUpCallback(Object data, int processID, Object obj, int num, int index) {
//
//    }
}

