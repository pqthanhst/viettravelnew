package thanh.hcm.vn.demoviettravel.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.fragment.AboutFragment;
import thanh.hcm.vn.demoviettravel.fragment.FoodFragment;
import thanh.hcm.vn.demoviettravel.fragment.HomeFragment;
import thanh.hcm.vn.demoviettravel.fragment.HotelsFragment;
import thanh.hcm.vn.demoviettravel.fragment.LanguageFragment;
import thanh.hcm.vn.demoviettravel.fragment.PlaceFragment;
import thanh.hcm.vn.demoviettravel.fragment.SettingFragment;
import thanh.hcm.vn.demoviettravel.fragment.VehicleFragment;
import thanh.hcm.vn.demoviettravel.residemenu.ResideMenu;
import thanh.hcm.vn.demoviettravel.residemenu.ResideMenuItem;
import thanh.hcm.vn.demoviettravel.utils.Contants;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static ResideMenu resideMenu;
    private ResideMenuItem itemHome, itemPlace, itemFood, itemHotel, itemVehicle, itemLanguage, itemAbout, itemSetting;
    private static Context mcontext;
    private static TextView tvTitleMain;
    public static FragmentManager fm;
    public static Button btnMenuLeft, btnBackLeft, btnMenuRight;
    private static int exitNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mcontext = this;
        setUpMenu();

        fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            switchFragment(getString(R.string.side_nav_home_page), null, false);
            //switchFragment("Home", null, false);
        }
    }

    private void setUpMenu() {
        resideMenu = new ResideMenu(this);

        resideMenu.setBackground(R.drawable.mapgold);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        //set with menu scale
        resideMenu.setScaleValue(0.6f);

        itemHome = new ResideMenuItem(this, R.string.icon_home, "Home");
        itemPlace = new ResideMenuItem(this, R.string.icon_place, "Places");
        itemFood = new ResideMenuItem(this, R.string.icon_food, "Foods");
        itemHotel = new ResideMenuItem(this, R.string.icon_hotel, "Hotel");
        itemLanguage = new ResideMenuItem(this, R.string.icon_language, "Language");
        itemVehicle = new ResideMenuItem(this, R.string.icon_verhicle, "Vehicle");

        itemAbout = new ResideMenuItem(this, R.string.icon_about, "About");
        itemSetting = new ResideMenuItem(this, R.string.icon_setting, "Setting");

        itemHome.setOnClickListener(this);
        itemPlace.setOnClickListener(this);
        itemFood.setOnClickListener(this);
        itemHotel.setOnClickListener(this);
        itemVehicle.setOnClickListener(this);
        itemLanguage.setOnClickListener(this);

        itemSetting.setOnClickListener(this);
        itemAbout.setOnClickListener(this);


        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPlace, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFood, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemHotel, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemVehicle, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemLanguage, ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSetting, ResideMenu.DIRECTION_RIGHT);

        tvTitleMain = (TextView) findViewById(R.id.tvTitleMain);
        btnMenuLeft = (Button) findViewById(R.id.title_bar_left_menu);
        btnBackLeft = (Button) findViewById(R.id.title_bar_left_menu_back);
        btnMenuRight = (Button) findViewById(R.id.title_bar_right_menu);
        btnBackLeft.setVisibility(View.GONE);

        btnMenuLeft.setOnClickListener(this);
        btnMenuRight.setOnClickListener(this);
        btnBackLeft.setOnClickListener(this);
    }

    private static ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            ///Toast.makeText(mcontext,"Menu is opened",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mcontext,"Menu is closed",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

//    @Override
//    public void onClick(View v) {
//        if (v == itemHome) {
//            changeFrament(new HomeFragment(), "Home");
//        } else if (v == itemPlace) {
//            changeFrament(new PlaceFragment(), "Places");
//        } else if (v == itemFood) {
//            changeFrament(new FoodFragment(), "Foods");
//        } else if (v == itemHotel) {
//            changeFrament(new HotelsFragment(), "Hotels");
//        } else if (v == itemVehicle) {
//            changeFrament(new VehicleFragment(), "Vehicle");
//        } else if (v == itemLanguage) {
//            changeFrament(new LanguageFragment(), "Language");
//        } else if (v == itemAbout) {
//            changeFrament(new AboutFragment(), "About");
//        } else if (v == itemSetting) {
//            changeFrament(new SettingFragment(), "Setting");
//        }
//
//        resideMenu.closeMenu();
//    }

    @Override
    public void onClick(View view) {

        if (view == btnMenuLeft) {
            resideMenu.openMenu(ResideMenu.DIRECTION_LEFT, true);
        } else if (view == btnBackLeft) {
            onBackPressed();
        } else if (view == btnMenuRight) {
            resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT, true);
        } else if (view == itemHome) {
            switchFragment(getString(R.string.side_nav_home_page), null, false);

        } else if (view == itemPlace) {
            switchFragment(getString(R.string.side_nav_place_page), null, false);

        } else if (view == itemFood) {
            switchFragment(getString(R.string.side_nav_food_page), null, false);

        } else if (view == itemHotel) {
            switchFragment(getString(R.string.side_nav_hotel_page), null, false);

        } else if (view == itemVehicle) {
            switchFragment(getString(R.string.side_nav_vehicle_page), null, false);

        } else if (view == itemLanguage) {
            switchFragment(getString(R.string.side_nav_language_page), null, false);

        } else if (view == itemAbout) {
            switchFragment(getString(R.string.side_nav_about_page), null, false);

        } else if (view == itemSetting) {
            switchFragment(getString(R.string.side_nav_setting_page), null, false);
        }


    }
//
//    private void changeFrament(Fragment fragment, String title) {
//        resideMenu.clearIgnoredViewList();
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_fragment, fragment, "fragment")
//                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
//        tvTitleMain.setText(title);
//
//    }

    public static void setEnableResideMenu(boolean status) {
        if (status) {
            getResideMenu().setSwipeDirectionEnable();
        } else {
            getResideMenu().setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
            getResideMenu().setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);
        }
    }

    // What good method is to access resideMenu？
    public static ResideMenu getResideMenu() {
        return resideMenu;
    }

    public static void switchFragment(String fragmentName, Bundle bundle, boolean isAddToBackStack) {

        if (fm != null) {
            while (fm.getBackStackEntryCount() > 0) {
                fm.popBackStackImmediate();
            }
        }
        if (fm != null) {

            boolean isShowPaddingFragment = true;
            // Perform the FragmentTransaction to load in the list tab content.
            // Using FragmentTransaction#replace will destroy any Fragments
            // currently inside R.id.fragment_content and add the new Fragment
            // in its place.
            resideMenu.clearIgnoredViewList();

            FragmentTransaction ft = fm.beginTransaction();
            //activeFragment = position;\
            Fragment fragment = null;

            if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_home_page))) {
                fragment = HomeFragment.getInstall();
                exitNumber = 0;
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_food_page))) {
                fragment = FoodFragment.getInstall();

                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_hotel_page))) {
                fragment = HotelsFragment.getInstall();
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_vehicle_page))) {
                fragment = VehicleFragment.getInstall();
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_language_page))) {
                fragment = LanguageFragment.getInstall();
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_place_page))) {
                fragment = PlaceFragment.getInstall();
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_about_page))) {
                fragment = AboutFragment.getInstall();
                Contants.currentStatus = 0;
            } else if (fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(mcontext.getString(R.string.side_nav_setting_page))) {
                fragment = SettingFragment.getInstall();
                Contants.currentStatus = 0;
            }

            //child fragment
//            else if(fm.findFragmentByTag(fragmentName) == null && fragmentName.equalsIgnoreCase(context.getString(R.string.side_nav_fr_manage_add_team_individual))){
//                fragment = new FragmentManageTeamAddIndividual();
//            }


            if (fragment != null && ft != null) {

                fragment.setRetainInstance(false);
                fragment.setArguments(bundle);
                ft.replace(R.id.main_fragment, fragment, fragmentName);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                if (isAddToBackStack) {
                    ft.addToBackStack(fragment.getClass().getSimpleName());
                }

                ft.commitAllowingStateLoss();
                tvTitleMain.setText(fragmentName);
            }

            if (resideMenu.isOpened()) {

                resideMenu.closeMenu();
            }
        }
    }

    public static void updateGA(String title, boolean showMenu) {
        tvTitleMain.setText(title);
        if (showMenu) {
            btnMenuLeft.setVisibility(View.VISIBLE);
            btnBackLeft.setVisibility(View.GONE);
        } else {
            btnMenuLeft.setVisibility(View.GONE);
            btnBackLeft.setVisibility(View.VISIBLE);
        }
    }

    public static void backToScreen(String screenName) {
        if (fm != null) {
            if (fm.findFragmentByTag(screenName) != null) {
                while (fm.getBackStackEntryCount() > 0 && !fm.findFragmentByTag(screenName).isVisible()) {

                    Log.d("Main Back to screen", "fm.findFragmentByTag(" + screenName + "): " + fm.findFragmentByTag(screenName).getTag());
                    Log.d("Main Back to screen", "fm.getBackStackEntryCount(): " + fm.getBackStackEntryCount());

                    fm.popBackStackImmediate();
                }
            } else {
                while (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStackImmediate();
                }
                switchFragment(mcontext.getString(R.string.side_nav_home_page), new Bundle(), false);

            }
        }
    }

    @Override
    protected void onDestroy() {
        fm = null;
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (fm != null && fm.getBackStackEntryCount() > 0) {
            Log.e("backpress 1", "--" + Contants.currentStatus);

            fm.popBackStack();

        } else {
            if (fm != null && fm.findFragmentByTag(getString(R.string.side_nav_home_page)) == null) {
                Log.e("backpress 2", "--" + Contants.currentStatus);
                if (Contants.currentStatus > 0) {
                    EventBus.getDefault().post( Contants.currentStatus);
                } else {
                    switchFragment(getString(R.string.side_nav_home_page), null, false);

                }

            } else if (fm != null && fm.findFragmentByTag(getString(R.string.side_nav_home_page)) != null) {
                Log.e("backpress 3", "--" + Contants.currentStatus);
                if (exitNumber > 0) {
                    moveTaskToBack(true);
                    exitNumber = 0;
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.alert_message_press_again_to_exit), Toast.LENGTH_SHORT).show();
                    exitNumber++;
                }
            } else {
                if (resideMenu.isOpened()) {
                    resideMenu.closeMenu();
                } else {
                    if (exitNumber > 0) {
                        moveTaskToBack(true);
                        exitNumber = 0;
                    } else {
                        Toast.makeText(MainActivity.this, getString(R.string.alert_message_press_again_to_exit), Toast.LENGTH_SHORT).show();
                        exitNumber++;

                    }

                }
            }
        }
    }
}
