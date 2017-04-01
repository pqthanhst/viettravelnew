package thanh.hcm.vn.demoviettravel.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;
import thanh.hcm.vn.demoviettravel.model.PlaceModel;

/**
 * Created by phamquocthanh on 2/18/2017.
 */

public class ListPlaceMainAdapter extends RecyclerView.Adapter<ListPlaceMainAdapter.PlaceViewHolder> {
    private List<PlaceModel> placeList;
    private Activity activity;
    private boolean currentPosition = false;
    private int isClick = 0;

    /**
     * Contructor
     */
    public ListPlaceMainAdapter(Activity activity, List<PlaceModel> placeList) {
        this.activity = activity;
        this.placeList = placeList;

    }

    /**
     * Create ViewHolder
     */
    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout lnPlaceItem;
        private TextView namePlaceTxt, addressPlaceTxt;
        private ImageView photoPlaceImv;

        public PlaceViewHolder(final View itemView) {
            super(itemView);
            lnPlaceItem = (LinearLayout) itemView.findViewById(R.id.lnPlaceItem);
            namePlaceTxt = (TextView) itemView.findViewById(R.id.tvNamePlace);
            addressPlaceTxt = (TextView) itemView.findViewById(R.id.tvAddressPlace);
            photoPlaceImv = (ImageView) itemView.findViewById(R.id.ivImagePlace);

            lnPlaceItem.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Log.e("ontouch","--"+event.getAction());
                    MainActivity.setEnableResideMenu(false);
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        currentPosition = true;
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (currentPosition) {

                            Toast.makeText(activity, "on click item" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        }
                        MainActivity.setEnableResideMenu(true);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_MOVE) {

                        currentPosition = false;
                        return true;
                    }
                    else if(event.getAction()==MotionEvent.ACTION_CANCEL){
                        currentPosition = false;
                        return true;
                    }

                    return false;
                }
            });


        }

    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** Get layout */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_place_in_main, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        /** Set Value*/

        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displaymetrics);

        int width = displaymetrics.widthPixels / 3;
        holder.lnPlaceItem.setLayoutParams(new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT));

        PlaceModel place = placeList.get(position);

        holder.namePlaceTxt.setText(place.getNamePlace());
        holder.addressPlaceTxt.setText(place.getAddressPlace());
        Picasso.with(activity)
                .load(place.getPhotoPlace()).centerCrop().resize(width, width - 50).error(R.drawable.ic_launcher)
                .into(holder.photoPlaceImv);
       /*Sự kiện click vào item*/
        Log.e("Position", "posi" + position);

    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}
