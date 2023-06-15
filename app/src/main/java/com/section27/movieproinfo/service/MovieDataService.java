package com.section27.movieproinfo.service;

import com.section27.movieproinfo.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//https://api.themoviedb.org/3/movie/popular?api_key=xxxx
public interface MovieDataService {
//end point url is 3/person/popular

    @GET("3/movie/popular")
    Call<Result>  getPopularMovies(@Query("api_key") String apikey , @Query("page") int page);// we will set apikey in Result Class

    @GET("3/movie/top_rated")
    Call<Result>  getTopMovies(@Query("api_key") String apikey, @Query("page") int page);

    @GET("3/tv/popular")
    Call<Result> getPopularSeries(@Query("api_key") String apikey,  @Query("page") int page);
  @GET("3/search/movie")
    Call<Result> getSearchedMovie(@Query("api_key") String apikey, @Query("query") String query ,@Query("page") int page );

}
