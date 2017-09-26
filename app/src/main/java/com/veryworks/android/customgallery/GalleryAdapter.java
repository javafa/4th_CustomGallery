package com.veryworks.android.customgallery;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 9/26/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder>{
    List<String> data;

    public void setData(List<String> data){
        this.data = data;
        // 데이터가 변경되었다고 알려주어야지만 그린다.
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String path = data.get(position);
        Uri uri = Uri.parse(path);
        holder.setImageUri(uri);
    }

    class Holder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageItem);
            textView = itemView.findViewById(R.id.textDate);
        }
        public void setImageUri(Uri uri){
            imageView.setImageURI(uri);
        }
        public void setDate(String date){
            textView.setText(date);
        }
    }
}
