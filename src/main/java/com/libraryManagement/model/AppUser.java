package com.libraryManagement.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AppUser {
    private String userName;
    private AppUserBook listOfBook;

}
