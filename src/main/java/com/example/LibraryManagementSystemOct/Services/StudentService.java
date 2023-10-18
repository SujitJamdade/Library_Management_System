package com.example.LibraryManagementSystemOct.Services;


import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Repository.StudentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);

        return student.getName() + " has been saved to the DB.";
    }

}
