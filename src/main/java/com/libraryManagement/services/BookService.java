package com.libraryManagement.services;

import com.libraryManagement.model.Book;

import java.util.List;

public interface BookService {

     List<Book> getExternalBooks();

     Book searchBookByTitle( String title);

}
