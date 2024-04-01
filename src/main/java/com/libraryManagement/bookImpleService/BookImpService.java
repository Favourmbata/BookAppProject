package com.libraryManagement.bookImpleService;

import com.libraryManagement.dtos.reponse.AllBookResponse;
import com.libraryManagement.exceptions.BookNotFoundException;
import com.libraryManagement.model.Book;
import com.libraryManagement.services.BookService;
import com.libraryManagement.services.ExternalLibraryService;
import com.libraryManagement.services.IMPL.RetrofitServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookImpService implements BookService {


//    @Override
//    public List<Book> fetchAllBookToDataBase(){
//
//        ExternalLibraryService externalLibrary = RetrofitServiceIMPL.getRetrofitInstance().create(ExternalLibraryService.class);
//
//        Call<List<Book>> listOfBookFromExternalLibrary = externalLibrary.getAllBookFromAPI();
//
//        try {
//            Response<List<Book>> listOfBooks = listOfBookFromExternalLibrary.execute();
//            return listOfBooks.body();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public Book searchBookByTitle(String title){
        List<Book> externalBooks = getExternalBooks();

        for (Book book : externalBooks) {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                return book;
            }
        }
        throw new BookNotFoundException("Book Not Found in External Books");
    }


    @Override
    public List<Book> getExternalBooks(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("https://gutendex.com/books");

        ResponseEntity<AllBookResponse> allBooks = restTemplate.getForEntity(uri, AllBookResponse.class);
        AllBookResponse response = allBooks.getBody();
        if(response != null) return response.getResults();
        throw new BookNotFoundException("No Book Found");
    }


}
