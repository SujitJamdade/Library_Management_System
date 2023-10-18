package com.example.LibraryManagementSystemOct.Repository;


import com.example.LibraryManagementSystemOct.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
