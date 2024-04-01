package com.libraryManagement.exceptions;

public class BookNotFoundException extends LibraryManagementException{
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
