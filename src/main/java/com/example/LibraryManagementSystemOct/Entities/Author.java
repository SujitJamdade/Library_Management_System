package com.example.LibraryManagementSystemOct.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer authorId;

    @Column(nullable = false)
    String authorName;

    int age;

    double rating;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
            @JsonIgnore
    List<Book> bookList = new ArrayList<>();


}
