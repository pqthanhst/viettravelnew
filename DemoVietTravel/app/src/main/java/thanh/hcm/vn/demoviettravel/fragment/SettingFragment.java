package thanh.hcm.vn.demoviettravel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thanh.hcm.vn.demoviettravel.R;


public class SettingFragment extends BaseFragment {

    private View view;
    private Context context;

    private  static SettingFragment settingFragment=null;

    public static SettingFragment getInstall(){
        if(settingFragment == null){
            settingFragment = new SettingFragment();
        }
        return settingFragment;
    }

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_setting, null);
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

    }

    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.side_nav_setting_page), true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}
