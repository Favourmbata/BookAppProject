package com.libraryManagement.controller;

import com.libraryManagement.model.Book;
import com.libraryManagement.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private  final BookService bookService ;
    private List<Book> readingList = new ArrayList<>();

    @GetMapping( "/getAllBooks")
    public ResponseEntity<?> getBooks(){
        try{
            return new ResponseEntity<>(bookService.getExternalBooks(), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping( "/search/{bookTitle}")
    public ResponseEntity<?> searchBook(@PathVariable("bookTitle") String bookTitle){
        try {
            Book book = bookService.searchBookByTitle(bookTitle);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping ("/addToReadingList")
    public ResponseEntity<String> addToReadingList(@RequestParam Book book){
        readingList.add(book);
        return ResponseEntity.ok("Book added to reading list successfully");
    }

    @GetMapping("/displayReadingList")
    public ResponseEntity<List<Book>>displayReadingList(){
        return ResponseEntity.ok(readingList);
    }

}
