package com.section27.movieproinfo.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofiteInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/";


    public static MovieDataService getService() {
        if(retrofit == null){
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
        }

        return retrofit.create(MovieDataService.class);
    }
}
