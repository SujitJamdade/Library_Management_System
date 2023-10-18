package com.example.LibraryManagementSystemOct.Services;


import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystemOct.Repository.StudentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    // adding student into DB
    public String addStudent(Student student){
        studentRepository.save(student);

        return student.getName() + " has been saved to the DB.";
    }

    // Getting student from DB
    public Student getStudentByID(Integer studentId) throws Exception {

        Optional<Student> OptionalStudent = studentRepository.findById(studentId);

        if(!OptionalStudent.isPresent()){
            throw new Exception("The Id Entered is invalid");
        }

        Student student = OptionalStudent.get();

        return student;
    }

}
