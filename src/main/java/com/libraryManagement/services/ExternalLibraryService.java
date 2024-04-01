package com.libraryManagement.services;

import com.libraryManagement.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ExternalLibraryService {
    @GET("/books")
//    @GetMapping(value = "/books")
     Call<List<Book>> getAllBookFromAPI();

}
