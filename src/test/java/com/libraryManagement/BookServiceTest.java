package com.libraryManagement;

import com.libraryManagement.model.Book;
import com.libraryManagement.services.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Test That all book can be recieved from external api")
    public void testReceiveBook(){

        List<Book> allbooks = bookService.getExternalBooks();
        assertNotNull(allbooks);
    }

    @Test
    @DisplayName("Test That search for book by title")
    public void testSearch(){

        Book book = bookService.searchBookByTitle("Frankenstein");
        assertTrue(book.getTitle().contains("Frankenstein"));
        assertNotNull(book);
    }

}
