package com.libraryManagement.dtos.reponse;

import com.libraryManagement.model.Book;
import lombok.Data;

import java.util.List;

@Data
public class AllBookResponse {

    private int count;
    private List<Book> results;

}
