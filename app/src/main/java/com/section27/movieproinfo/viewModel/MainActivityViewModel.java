package com.section27.movieproinfo.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.section27.movieproinfo.model.Movie;
import com.section27.movieproinfo.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository repository;
    private LiveData<List<Movie>> movies;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getMutableLiveData(int typeMovie , int page){
        return  repository.getMutableLiveData(typeMovie,page);
    }
    public LiveData<List<Movie>> getMutableLiveDataSearch( String movieName,int page){
        return  repository.getMutableLiveDataSearch(movieName,page);
    }
}
