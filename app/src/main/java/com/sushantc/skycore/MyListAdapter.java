package com.sushantc.skycore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sushantc.skycore.model.Business;

import java.util.Objects;

public class MyListAdapter extends ListAdapter<Business,MyListAdapter.ViewHolder> {
    private Context context;

    protected MyListAdapter() {
        super(diffCallback);
    }

    private static DiffUtil.ItemCallback<Business> diffCallback = new DiffUtil.ItemCallback<Business>() {
        @Override
        public boolean areItemsTheSame(@NonNull Business oldItem, @NonNull Business newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Business oldItem, @NonNull Business newItem) {
            return Objects.deepEquals(oldItem,newItem);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(getItem(position).getImageUrl()).placeholder(R.drawable.images).error(R.drawable.images).into(holder.iv);
        holder.title.setText(getItem(position).getName());
        holder.desc.setText(getItem(position).getLocation().getDisplayAddress().get(0)==null?"":getItem(position).getLocation().getDisplayAddress().get(0));
        holder.status.setText(getItem(position).getIsClosed()?"Currently CLOSED":"Currently OPEN");
        holder.rating.setText(""+getItem(position).getRating());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc,status,rating;
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_tv);
            desc = itemView.findViewById(R.id.desc_tv);
            status = itemView.findViewById(R.id.status);
            rating = itemView.findViewById(R.id.rating);
            iv = itemView.findViewById(R.id.image_iv);
        }
    }
}
