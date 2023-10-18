package com.example.LibraryManagementSystemOct.Repository;

import com.example.LibraryManagementSystemOct.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
