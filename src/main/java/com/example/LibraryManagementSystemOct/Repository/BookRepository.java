package com.example.LibraryManagementSystemOct.Repository;


import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    List<Book> findBooksByGenre(Genre genre);

}
