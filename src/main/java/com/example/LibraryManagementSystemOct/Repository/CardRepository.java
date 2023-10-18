package com.example.LibraryManagementSystemOct.Repository;

import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {


}
