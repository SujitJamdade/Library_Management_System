package com.example.LibraryManagementSystemOct.Controller;


import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Services.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


}
