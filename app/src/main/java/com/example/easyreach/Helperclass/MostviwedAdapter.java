package com.example.easyreach.Helperclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easyreach.R;

import java.util.ArrayList;


public class MostviwedAdapter extends RecyclerView.Adapter<MostviwedAdapter.MostViewedHolder> {

    ArrayList<MostviwedHelperClass> mostviwedLocations;

    public MostviwedAdapter(ArrayList<MostviwedHelperClass> mostviwedLocations) {
        this.mostviwedLocations = mostviwedLocations;
    }

    @NonNull
    @Override
    //parent is a view group
    public MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viwed_card_desgin,parent,false);
        //instances of the class
        MostViewedHolder mostViewedHolder = new MostViewedHolder(view);
        return mostViewedHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedHolder holder, int position) {

        MostviwedHelperClass mostviwedHelperClass = mostviwedLocations.get(position);
        holder.mv_image.setImageResource(mostviwedHelperClass.getMv_image());
        holder.mv_title.setText(mostviwedHelperClass.getMv_title());
        holder.mv_desc.setText(mostviwedHelperClass.getMv_description());

    }

    @Override
    public int getItemCount() {
        return mostviwedLocations.size();
    }

    //basically hold the desgin or the view
    public static class  MostViewedHolder extends  RecyclerView.ViewHolder{

        ImageView mv_image;
        TextView mv_title, mv_desc;

        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);
            //hooks are neccessary for the desgins

            mv_image = itemView.findViewById(R.id.mv_image);
            mv_title = itemView.findViewById(R.id.mv_title);
            mv_desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
