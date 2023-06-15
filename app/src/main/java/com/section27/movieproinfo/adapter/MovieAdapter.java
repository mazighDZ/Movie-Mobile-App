package com.section27.movieproinfo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.section27.movieproinfo.R;
import com.section27.movieproinfo.databinding.MovieListItemBinding;
import com.section27.movieproinfo.model.Movie;
import com.section27.movieproinfo.view.MovieActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyMovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArraylist;

    public MovieAdapter(Context context, ArrayList<Movie> movieArraylist) {
        this.context = context;
        this.movieArraylist = movieArraylist;
    }

    @NonNull
    @Override
    public MyMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item ,
                parent,
                false);
        return new MyMovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMovieViewHolder holder, int position) {
        Movie movie = movieArraylist.get(position);
        holder.movieListItemBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return movieArraylist != null ? movieArraylist.size() : 0;
    }

//ViewHolder class

    public class MyMovieViewHolder extends RecyclerView.ViewHolder {
private MovieListItemBinding movieListItemBinding;
        public MyMovieViewHolder( MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding =movieListItemBinding;
            // when user click on item
            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movieArraylist.get(position);
                        Intent i =  new Intent(context , MovieActivity.class);
                        i.putExtra("movie" , selectedMovie);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //set flag to Calling startActivity() from outside
                        context.startActivity(i);

                    }
                }
            });

        }
    }
}
