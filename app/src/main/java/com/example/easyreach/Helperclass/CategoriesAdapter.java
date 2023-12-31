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
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {
    ArrayList<CategoriesHelperClass> mostViewedLocations;
    public CategoriesAdapter(ArrayList<CategoriesHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }
    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        AdapterAllCategoriesViewHolder lvh = new AdapterAllCategoriesViewHolder(view);
        return lvh;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        CategoriesHelperClass helperClass = mostViewedLocations.get(position);
        holder.cc_image.setImageResource(helperClass.getCc_image());
        holder.cc_title.setText(helperClass.getCc_title());

    }
    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }
    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {

        ImageView cc_image;
        TextView cc_title;
        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            cc_image = itemView.findViewById(R.id.cc_image);
            cc_title = itemView.findViewById(R.id.cc_title);
        }
    }
}
