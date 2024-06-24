package com.example.recordshop.service;

import com.example.recordshop.model.Album;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @PUT("albums/{id}")
    Call<Album> updateAlbum(@Path("id") Long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<Album> deleteAlbum(@Path("id") Long id);

}
