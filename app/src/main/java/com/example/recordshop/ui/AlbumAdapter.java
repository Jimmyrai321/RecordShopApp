package com.example.recordshop.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshop.R;
import com.example.recordshop.databinding.LayoutAlbumsBinding;
import com.example.recordshop.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;

    public AlbumAdapter(List<Album> albumList, Context context) {
        this.albumList = albumList;
        this.context = context;

    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int i) {
        LayoutAlbumsBinding binding = LayoutAlbumsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new AlbumViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int position) {
        Album album = albumList.get(position);
        albumViewHolder.layoutAlbumsBinding.setAlbum(album);
        albumViewHolder.layoutAlbumsBinding.albumPic.setImageDrawable((ContextCompat.getDrawable(context,album.getAlbum_icon())));



    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }



    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private LayoutAlbumsBinding layoutAlbumsBinding;

        public AlbumViewHolder(LayoutAlbumsBinding layoutAlbumsBinding) {
            super(layoutAlbumsBinding.getRoot());
            this.layoutAlbumsBinding = layoutAlbumsBinding;
        }

    }
}


