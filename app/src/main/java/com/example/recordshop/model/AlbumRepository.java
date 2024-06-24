package com.example.recordshop.model;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshop.service.AlbumApiService;
import com.example.recordshop.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Arrays;
import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                Log.i("ALBUMLISTLOG",""+response.code());
                Log.i("ALBUMLISTLOG", albums.toString());
                Log.i("ALBUMLISTLOG","ON SUCCESS");


                for(Album a: albums){
                    a.setAlbum_icon(a.getGenre());
                    Log.i("ALBUMLISTGENRE",a.getGenre()+" "+a.getAlbum_icon().toString());
                }
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {

            }
        });
        return mutableLiveData;
    }


}
