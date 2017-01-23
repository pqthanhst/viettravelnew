package thanh.hcm.vn.demoviettravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import thanh.hcm.vn.demoviettravel.R;

/**
 * Created by thanh on 1/6/2017.
 */

public class ListPlaceInMainAdapter extends PagerAdapter {


    private ArrayList<Integer> IMAGES;
    private LayoutInflater inflater;
    private Context context;


    public ListPlaceInMainAdapter(Context context, ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES=IMAGES;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        int count= 0;
        if((IMAGES.size()%3)>0){
            count =(IMAGES.size()/3)+1;
        }
        return count;
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_list_place, view, false);

        assert imageLayout != null;

        CardView cardViewOne= (CardView) imageLayout.findViewById(R.id.cvPlaceOne);
        CardView cardViewTwo= (CardView) imageLayout.findViewById(R.id.cvPlaceTwo);
        CardView cardViewThree= (CardView) imageLayout.findViewById(R.id.cvPlaceThree);

        final ImageView imageViewOne = (ImageView) imageLayout
                .findViewById(R.id.ivImagePlaceOne);
        final ImageView imageViewTwo = (ImageView) imageLayout
                .findViewById(R.id.ivImagePlaceTwo);
        final ImageView imageViewThree = (ImageView) imageLayout
                .findViewById(R.id.ivImagePlaceThree);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displaymetrics);

        //int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels / 3;
        int currentPosition=0;
        if(position>0){
            currentPosition=3;
        }
        if(position>1){
            currentPosition=6;
        }
        if(position>2){
            currentPosition=9;
        }

        if(currentPosition<=(IMAGES.size()-1)){
            Log.e("image 1","--"+currentPosition);
            Picasso.with(context)
                    .load(IMAGES.get(currentPosition)).centerCrop().resize(width,width-50).error(R.drawable.ic_launcher)
                    .into(imageViewOne);
            cardViewOne.setVisibility(View.VISIBLE);
        }else {
            cardViewOne.setVisibility(View.INVISIBLE);
        }

        if((currentPosition+1)<=(IMAGES.size()-1)){
            Log.e("image 2","--"+(currentPosition+1));
            Picasso.with(context)
                    .load(IMAGES.get((currentPosition+1))).centerCrop().resize(width,width-50).error(R.drawable.ic_launcher)
                    .into(imageViewTwo);

            cardViewTwo.setVisibility(View.VISIBLE);
        }else {
            cardViewTwo.setVisibility(View.INVISIBLE);

        }

        if((currentPosition+2)<=(IMAGES.size()-1)){
            Log.e("image 3","--"+(currentPosition+2));
            Picasso.with(context)
                    .load(IMAGES.get((currentPosition+2))).centerCrop().resize(width,width-50).error(R.drawable.ic_launcher)
                    .into(imageViewThree);

            cardViewThree.setVisibility(View.VISIBLE);
        }else {
            cardViewThree.setVisibility(View.INVISIBLE);

        }

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}