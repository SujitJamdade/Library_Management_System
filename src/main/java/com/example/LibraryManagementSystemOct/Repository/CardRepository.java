package com.example.LibraryManagementSystemOct.Repository;

import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer> {


}
