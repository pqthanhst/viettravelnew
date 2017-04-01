package thanh.hcm.vn.demoviettravel.fragment;

import android.app.Activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;

/**
 * Created by phamquocthanh on 3/14/2017.
 */

public class PlaceDetailFragment extends BaseFragment {

    private View view;
    private Activity context;

    private YouTubePlayerSupportFragment youTubeView;
    private static final int RECOVERY_REQUEST = 1;

    private static PlaceDetailFragment placeDetailFragment = null;
    private TextView tvTitleListPhoto, tvTitleListFood, tvNamePlaceDetail, tvAddressPlaceDetail, tvBestTimeVisit, tvInfo;
    private YouTubePlayer youTubeplayer;

    public static PlaceDetailFragment getInstall() {
        if (placeDetailFragment == null) {
            placeDetailFragment = new PlaceDetailFragment();
        }
        return placeDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        setFragmentActivity(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_place_detail, null);
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

        tvTitleListPhoto = (TextView) view.findViewById(R.id.tvTitleListPhoto);
        tvTitleListFood = (TextView) view.findViewById(R.id.tvTitleListFood);
        tvNamePlaceDetail = (TextView) view.findViewById(R.id.tvNamePlaceDetail);
        tvAddressPlaceDetail = (TextView) view.findViewById(R.id.tvAddressPlaceDetail);
        tvBestTimeVisit = (TextView) view.findViewById(R.id.tvBestTimeVisit);
        tvInfo = (TextView) view.findViewById(R.id.tvInfo);

        tvTitleListPhoto.setText(Html.fromHtml("<u>Nice views of place<u/>"));
        tvTitleListFood.setText(Html.fromHtml("<u>Special foods of place<u/>"));

        MainActivity.setEnableResideMenu(false);

    }

    private void setupYoutubeView(String idVideo) {

        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        youTubeView = (YouTubePlayerSupportFragment) fragmentManager.findFragmentById(R.id.youtube_fragment);

        if (youTubeView != null) {
            youTubeView.initialize(context.getString(R.string.key_youtube), new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                    Log.i("Detail", "YouTube Player onInitializationSuccess");
                    // Don't do full screen
                    youTubeplayer = player;
                    youTubeplayer.setFullscreen(false);
                    if (!wasRestored) {
                        youTubeplayer.cueVideo("-OYUwQsT5pc");//fhWaJi1Hsfo
                    }
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Log.i("Detail", "Failed: " + youTubeInitializationResult);
                    if (youTubeInitializationResult.isUserRecoverableError()) {

                        youTubeInitializationResult.getErrorDialog(context, RECOVERY_REQUEST).show();
                    } else {

                        String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
                        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Log.e("PlaceDetail", "setupYoutubeView null");
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        updateGA(context.getString(R.string.place_detail_page), true);
        if (youTubeView == null) {
            Log.e("PlaceDetail", "onResume youtube null");
            setupYoutubeView("");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("PlaceDetail", "onpause run");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("PlaceDetail", "onDetach run");
        youTubeView = null;
        view = null;
        MainActivity.setEnableResideMenu(true);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }
}