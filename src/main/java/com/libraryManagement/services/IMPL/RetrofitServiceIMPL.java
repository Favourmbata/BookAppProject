package com.libraryManagement.services.IMPL;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceIMPL {

    private final static String bookLibraryBaseUrl = "https://gutendex.com/";

    public static Retrofit getRetrofitInstance(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return  new Retrofit.Builder()
                .baseUrl(bookLibraryBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

}
