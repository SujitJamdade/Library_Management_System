package com.example.LibraryManagementSystemOct.Entities;


import com.example.LibraryManagementSystemOct.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table //Incase you don't write any name : ClassName is taken as Table Name

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookId;

    String bookName;

    int price;

    int noOfPages;

    @Enumerated(value = EnumType.STRING)
    Genre genre;

    double rating;

    Boolean isBookAvailable;

    @ManyToOne
    @JoinColumn
            @JsonIgnore
    Author author;



    // Connecting to transaction
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();


}
