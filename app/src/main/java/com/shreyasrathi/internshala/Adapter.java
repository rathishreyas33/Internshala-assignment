package com.shreyasrathi.internshala;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<album> albums;

    public Adapter(Context ct,List<album> albums){
        this.inflater = LayoutInflater.from(ct);
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.itemlistdesign,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //bind the data
        holder.alid.setText(albums.get(position).getId());
        Picasso.get().load(albums.get(position).getThumbnailurl()).into(holder.althumbnail);
        holder.altitle.setText(albums.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView alid,altitle;
        ImageView althumbnail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            alid = itemView.findViewById(R.id.id);
            altitle = itemView.findViewById(R.id.title);
            althumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
