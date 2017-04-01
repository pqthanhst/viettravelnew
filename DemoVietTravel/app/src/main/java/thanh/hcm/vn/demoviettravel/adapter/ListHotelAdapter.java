package thanh.hcm.vn.demoviettravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import thanh.hcm.vn.demoviettravel.R;
import thanh.hcm.vn.demoviettravel.activity.MainActivity;
import thanh.hcm.vn.demoviettravel.model.FoodModel;
import thanh.hcm.vn.demoviettravel.model.HotelModel;

/**
 * Created by phamquocthanh on 1/22/2017.
 */

public class ListHotelAdapter extends RecyclerView.Adapter<ListHotelAdapter.MyViewHolder> {

private Context context;
private List<HotelModel> hotelList;
private int width, height;
        RelativeLayout.LayoutParams layoutParams;
/**
 * View holder class
 * */
public class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivPhoto;
    private TextView tvName,tvAddress,tvTime;
    private RatingBar rtbStart;
    private RelativeLayout rlItemRowPlace;

    public MyViewHolder(View view) {
        super(view);

        rlItemRowPlace = (RelativeLayout) view.findViewById(R.id.rlItemRowPlace);
        ivPhoto =(ImageView) view.findViewById(R.id.ivItemRowPlace);
        tvName =(TextView) view.findViewById(R.id.tvItemRowPlaceName);
        tvAddress=(TextView) view.findViewById(R.id.tvItemRowPlaceAddress);
        rtbStart=(RatingBar) view.findViewById(R.id.rtbStart);
        rtbStart.setVisibility(View.VISIBLE);
        tvTime =(TextView) view.findViewById(R.id.tvItemRowPlaceTime);
        tvTime.setVisibility(View.GONE);
    }
}

    public ListHotelAdapter(Context context, List<HotelModel> hotelList) {
        this.context=context;
        this.hotelList = hotelList;

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();  // deprecated

        this.width = width;
        this.height =height/4;
        layoutParams = new RelativeLayout.LayoutParams(this.width,this.height);
    }

    @Override
    public void onBindViewHolder(ListHotelAdapter.MyViewHolder holder, int position) {
        HotelModel hotel = hotelList.get(position);

        holder.ivPhoto.setLayoutParams(layoutParams);
        Picasso.with(context)
                .load(hotel.getPhotoHotel()).centerCrop().resize(width,height).error(R.drawable.ic_launcher)
                .into(holder.ivPhoto);

        holder.tvName.setText(hotel.getNameHotel());
        holder.tvAddress.setText(hotel.getAddressHotel());
        holder.rtbStart.setRating(hotel.getNumRanting());
        holder.rlItemRowPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.switchFragment(context.getString(R.string.hotel_detail_page), null, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    @Override
    public ListHotelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_list_place,parent, false);
        return new ListHotelAdapter.MyViewHolder(v);
    }
}
