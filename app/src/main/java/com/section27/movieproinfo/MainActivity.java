package com.section27.movieproinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.section27.movieproinfo.adapter.MovieAdapter;
import com.section27.movieproinfo.databinding.ActivityMainBinding;
import com.section27.movieproinfo.model.Movie;
import com.section27.movieproinfo.model.MovieRepository;
import com.section27.movieproinfo.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Movie> moviesList = new ArrayList<>();
    private ArrayList<Movie> topMoviesList = new ArrayList<>();
    private ArrayList<Movie> seriesList = new ArrayList<>();
    private ArrayList<Movie> searchMovieList = new ArrayList<>();

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;

    private int popularMoviePage = 1;
    private int popularSeriesPage = 1;
    private int topMoviePage = 1;
    private int searchMoviePage = 1;

    private String currentTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Movie Pro App");

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        setupViews();
        setSwipeRefreshLayoutListener();
        setupRecyclerView();
        getPopularMovies(popularMoviePage);
    }
    private void setSwipeRefreshLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (currentTitle.equals("Movie Pro App") || currentTitle.equals("Popular Movie")) {
                popularMoviePage = 1;
                getPopularMovies(popularMoviePage);
            } else if (currentTitle.equals("Top Movie")) {
                topMoviePage = 1;
                getTopMovies(topMoviePage);
            } else if (currentTitle.equals("Popular Series")) {
                popularSeriesPage = 1;
                getPopularSeries(popularSeriesPage);
            }
            swipeRefreshLayout.setRefreshing(false);
        });
    }
    private void setupViews() {
        swipeRefreshLayout = activityMainBinding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.teal_200);

        recyclerView = activityMainBinding.rvMovies;
    }

    private void setupRecyclerView() {
        movieAdapter = new MovieAdapter(getApplicationContext(), moviesList);

        int spanCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 2 : 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1)) {
                    if (currentTitle.equals("Movie Pro App") || currentTitle.equals("Popular Movie")) {
                        getPopularMovies(popularMoviePage);
                    } else if (currentTitle.equals("Top Movie")) {
                        getTopMovies(topMoviePage);
                    } else if (currentTitle.equals("Popular Series")) {
                        getPopularSeries(popularSeriesPage);
                    } else if (currentTitle.equals("Search")) {
                        searchMoviePage++;
                        EditText editText = findViewById(R.id.tvSearch);
                        searchMovie(editText);
                    }
                }
            }
        });
    }

    public List<Movie> removeDuplicate(List<Movie> duplicateList , List<Movie> noneDuplicateList ) {
        Log.i("myTag", "title is " + currentTitle);
        for (Movie movie : duplicateList) {
            if (!noneDuplicateList.contains(movie)) {
                noneDuplicateList.add(movie);
            }
        }
        return noneDuplicateList;
    }

    private void getPopularMovies(int page) {
        currentTitle = "Popular Movie";
        mainActivityViewModel.getMutableLiveData(MovieRepository.POPULAR_MOVIE, page).observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                if (popularMoviePage == 1) {
                    moviesList.clear();
                    topMoviesList.clear();
                    seriesList.clear();
                }
                   moviesList =(ArrayList<Movie>) removeDuplicate(moviesFromLiveData , moviesList);
                movieAdapter.notifyDataSetChanged();
                popularMoviePage++;
                Log.i("myTag", "size " + moviesList.size() + " page " + popularMoviePage);
            }
        });
    }

    private void getTopMovies(int page) {
        currentTitle = "Top Movie";
        mainActivityViewModel.getMutableLiveData(MovieRepository.TOP_MOVIE, page).observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                if (topMoviePage == 1) {
                    moviesList.clear();
                    topMoviesList.clear();
                    seriesList.clear();
                }
                topMoviesList =(ArrayList<Movie>) removeDuplicate(moviesFromLiveData , topMoviesList);
                movieAdapter.notifyDataSetChanged();
                topMoviePage++;
            }
        });
    }

    private void getPopularSeries(int page) {
        currentTitle = "Popular Series";
        mainActivityViewModel.getMutableLiveData(MovieRepository.POPULAR_SERIES, page).observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesFromLiveData) {
                if (popularSeriesPage == 1) {
                    moviesList.clear();
                    topMoviesList.clear();
                    seriesList.clear();
                }
                seriesList =(ArrayList<Movie>) removeDuplicate(moviesFromLiveData , seriesList);

                movieAdapter.notifyDataSetChanged();
                popularSeriesPage++;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        topMoviePage = 1;
        popularMoviePage = 1;
        popularSeriesPage = 1;
        searchMoviePage=1;
        EditText etMovieName = findViewById(R.id.tvSearch);

        if (itemId == R.id.popularMovie) {
        currentTitle = "Popular Movie";
            getPopularMovies(popularMoviePage);
            getSupportActionBar().setTitle("Popular Movie");
            etMovieName.setVisibility(View.VISIBLE);
            return true;
        } else if (itemId == R.id.topRated) {
            currentTitle = "Top Movie";

            getTopMovies(topMoviePage);
            getSupportActionBar().setTitle("Top Movie");
            etMovieName.setVisibility(View.GONE);
            return true;
        } else if (itemId == R.id.popularSeries) {
            currentTitle = "Popular Series";
            getPopularSeries(popularSeriesPage);
            getSupportActionBar().setTitle("Popular Series");
            etMovieName.setVisibility(View.GONE);
            return true;
        } else {
            getPopularMovies(1);
            return super.onOptionsItemSelected(item);
        }
    }

    public void searchMovie(View view) {
        EditText etMovieName = findViewById(R.id.tvSearch);
        Toast.makeText(getApplicationContext(), etMovieName.getText(), Toast.LENGTH_SHORT).show();
        mainActivityViewModel.getMutableLiveDataSearch(String.valueOf(etMovieName.getText()), searchMoviePage)
                .observe(this, new Observer<List<Movie>>() {
                    @Override
                    public void onChanged(List<Movie> movies) {
                        getSupportActionBar().setTitle("Search for Movie");
                        //this trigger first time u want change to search first clean movie list
                        if(!currentTitle.equals("Search")){
                        moviesList.clear();
                        }
                        moviesList =(ArrayList<Movie>) removeDuplicate(movies , moviesList);
                        movieAdapter.notifyDataSetChanged();
                    }
                });
        currentTitle = "Search";

    }
}
