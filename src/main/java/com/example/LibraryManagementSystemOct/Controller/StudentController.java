package com.example.LibraryManagementSystemOct.Controller;


import com.example.LibraryManagementSystemOct.DTO.BasicDetailsStudentResponse;
import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Services.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/getStudent/{id}")
    public ResponseEntity getStudentByID(@PathVariable("id") Integer studentId){

        try{
            Student student = studentService.getStudentByID(studentId);
            return new ResponseEntity(student, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // using DTO Response

    @GetMapping("/getBasicDetails")
    public BasicDetailsStudentResponse getBasicDetails(@RequestParam("id") Integer id){

        BasicDetailsStudentResponse resultObj = studentService.getBasicDetails(id);

        return resultObj;
    }

}
