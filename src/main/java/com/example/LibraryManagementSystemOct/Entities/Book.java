package com.example.LibraryManagementSystemOct.Entities;


import com.example.LibraryManagementSystemOct.Enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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

    @ManyToOne
    @JoinColumn
    Author author;




}
