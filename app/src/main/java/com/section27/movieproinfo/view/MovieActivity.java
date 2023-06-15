package com.section27.movieproinfo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.util.Log;

import com.section27.movieproinfo.R;
import com.section27.movieproinfo.databinding.ActivityMovieBinding;
import com.section27.movieproinfo.model.Movie;

public class MovieActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieBinding activityMovieBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityMovieBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie);
        Intent i = getIntent();
        if(i != null){
            movie = getIntent().getParcelableExtra("movie");
            activityMovieBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle()!= null ? movie.getTitle() : movie.getName());

        }else {
            Log.i("MyTag" , " Intent was Empty ");
        }

    }
}