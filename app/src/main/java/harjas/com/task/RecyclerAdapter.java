package harjas.com.task;

/**
 * Created by dell pc on 18-10-2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    private List<GetterSetter> feedItemList;
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<GetterSetter> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;

    }

    @Override
    public int getItemViewType(int position) {

        if (position % 4 == 0) {
            return 1;
        } else if (position % 3 == 0) {
            return 2;
        } else if (position % 2 == 0) {
            return 3;
        }   else {
            return 4;
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case 1:
                View viewONE = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_template_one, parent, false);
                CustomViewHolder rowONE = new CustomViewHolder(viewONE);
                return rowONE;

            case 2:
                View viewTWO = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_template_two, parent, false);
                CustomViewHolder rowTWO = new CustomViewHolder(viewTWO);
                return rowTWO;

            case 3:
                View viewTHREE = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_template_three, parent, false);
                CustomViewHolder rowTHREE = new CustomViewHolder(viewTHREE);
                return rowTHREE;
            case 4:
                View viewFOUR = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_template_four, parent, false);
                CustomViewHolder rowFOUR = new CustomViewHolder(viewFOUR);
                return rowFOUR;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        GetterSetter dc_list = feedItemList.get(position);

        final int pos = position * 3;


    }

    private void setAnimation(FrameLayout container, int position) {
        Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        container.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0 / 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imgl;
        TextView tvspecies;
        FrameLayout container;

        public CustomViewHolder(View itemView) {
            super(itemView);

        }
    }
}