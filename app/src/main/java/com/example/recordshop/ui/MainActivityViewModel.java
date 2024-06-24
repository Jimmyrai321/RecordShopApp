package com.example.recordshop.ui;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshop.model.Album;
import com.example.recordshop.model.AlbumRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {


        AlbumRepository albumRepository;


        public MainActivityViewModel(@NotNull Application application) {
            super(application);
            this.albumRepository = new AlbumRepository(application);
        }

        public MutableLiveData<List<Album>> getRepositoryLiveData(){
            return albumRepository.getMutableLiveData();
        }
}

