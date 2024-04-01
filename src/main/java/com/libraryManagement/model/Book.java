package com.libraryManagement.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmOuterJoinEnum;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    @OneToMany
    private List<Author> authors;
//    private LocalDateTime createdDate;


}
