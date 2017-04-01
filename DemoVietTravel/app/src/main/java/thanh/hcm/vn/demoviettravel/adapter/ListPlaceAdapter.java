package thanh.hcm.vn.demoviettravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;
import thanh.hcm.vn.demoviettravel.fragment.PlaceDetailFragment;
import thanh.hcm.vn.demoviettravel.model.PlaceModel;

/**
 * Created by phamquocthanh on 1/21/2017.
 */

public class ListPlaceAdapter extends RecyclerView.Adapter<ListPlaceAdapter.MyViewHolder> {

    private Context context;
    private List<PlaceModel> placeList;
    private int width, height;
    RelativeLayout.LayoutParams layoutParams;
    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvName,tvAddress,tvTime;

        public MyViewHolder(View view) {
            super(view);

            ivPhoto =(ImageView) view.findViewById(R.id.ivItemRowPlace);
            tvName =(TextView) view.findViewById(R.id.tvItemRowPlaceName);
            tvAddress=(TextView) view.findViewById(R.id.tvItemRowPlaceAddress);
            tvTime =(TextView) view.findViewById(R.id.tvItemRowPlaceTime);
        }
    }

    public ListPlaceAdapter(Context context, List<PlaceModel> placeList) {
        this.context=context;
        this.placeList = placeList;

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        this.width = width;
        this.height =height/4;
        layoutParams = new RelativeLayout.LayoutParams(this.width,this.height);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlaceModel place = placeList.get(position);

        holder.ivPhoto.setLayoutParams(layoutParams);
        Picasso.with(context)
                .load(place.getPhotoPlace()).centerCrop().resize(width,height).error(R.drawable.ic_launcher)
                .into(holder.ivPhoto);

        holder.tvName.setText(place.getNamePlace());
        holder.tvAddress.setText(place.getAddressPlace());
        holder.tvTime.setText("Best time visit: "+place.getTimePlace());
        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.switchFragment(context.getString(R.string.place_detail_page), null, true);

            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_list_place,parent, false);
        return new MyViewHolder(v);
    }
}
