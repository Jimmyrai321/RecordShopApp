package com.example.recordshop.model;


import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import com.example.recordshop.BR;
import com.example.recordshop.R;
import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("artist")
    private String artist;

    @SerializedName("release_year")
    private Integer release_year;

    @SerializedName("genre")
    private String genre;

    @SerializedName("album_info")
    private String album_info;

    @SerializedName("stock_count")
    private Integer stock_count;

    private static int album_icon;

    public Album() {
    }

    public Album(String name, Long id, String artist, Integer release_year, String genre, String album_info, Integer stock_count) {
        this.name = name;
        this.id = id;
        this.artist = artist;
        this.release_year = release_year;
        this.genre = genre;
        this.album_info = album_info;
        this.stock_count = stock_count;
        setAlbum_icon(genre);
    }

    public void setAlbum_icon(String genre){
        Log.i("GENRE",genre);
        switch(genre){
            case"ELECTRONIC":
                album_icon = R.drawable.electronic_album_icon;
                break;
            case"RNB":
                album_icon = R.drawable.rnb_album_icon;
                break;
            case"HOUSE":
                album_icon = R.drawable.house_album_icon;
                break;
            case"DISCO":
                album_icon = R.drawable.disco_album_icon;
                break;
            case"EDM":
                album_icon = R.drawable.edm_album_icon;
                break;
            case"JAZZ":
                album_icon = R.drawable.jazz_album_icon;
                break;
            case"METAL":
                album_icon = R.drawable.metal_album_icon;
                break;
            case"HIPHOP":
                album_icon = R.drawable.hiphop_album_icon;
                break;
            case"LATIN":
                album_icon = R.drawable.latin_album_icon;
                break;
            case"DUBSTEP":
                album_icon = R.drawable.dubstep_album_icon;
                break;
            case"REGGAE":
                album_icon = R.drawable.reggae_album_icon;
                break;
            case"ROCK":
                album_icon = R.drawable.rock_album_icon;
                break;
            case"POP":
                album_icon = R.drawable.pop_album_icon;
                break;
            case"INDIE":
                album_icon = R.drawable.indie_album_icon;
                break;
        }
        notifyPropertyChanged(BR.album_icon);
    }

    @BindingAdapter("android:imageRes")
    public static void loadImage(View view, int imageId){
        ImageView imageView = (ImageView) view;
        Log.i("IMAGERES",String.valueOf(imageId));
        imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));

    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
        notifyPropertyChanged(BR.release_year);
    }

    @Bindable
    public String getAlbum_info() {
        return album_info;
    }

    public void setAlbum_info(String album_info) {
        this.album_info = album_info;
        notifyPropertyChanged(BR.album_info);
    }

    @Bindable
    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
        notifyPropertyChanged(BR.stock_count);
    }

    @Bindable
    public Integer getAlbum_icon() {
        return album_icon;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        setAlbum_icon(genre);
        notifyPropertyChanged(BR.genre);
    }
}
