package com.example.LibraryManagementSystemOct.Repository;


import com.example.LibraryManagementSystemOct.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
