package com.example.LibraryManagementSystemOct.Repository;

import com.example.LibraryManagementSystemOct.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {


}
