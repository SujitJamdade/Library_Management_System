package com.example.LibraryManagementSystemOct.Services;


import com.example.LibraryManagementSystemOct.Entities.Student;
import com.example.LibraryManagementSystemOct.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystemOct.Repository.StudentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    JavaMailSender mailSender;

    // adding student into DB
    public String addStudent(Student student){
        studentRepository.save(student);

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body ="Hi "+student.getName()+" !\n \n"+
                "Welcome to University College Dublin. Your admission has been confirmed for 2024-2025\n\n"+
                "**Note : This is System generated mail, Please ignore !\n\n"+
                "Thank & Regards,\n" +
                "Dublin University";

        mailMessage.setFrom("sujit.learning.use@gmail.com");
        mailMessage.setTo(student.getEmailId());
        mailMessage.setSubject("Welcome to University College Dublin");
        mailMessage.setText(body);

        mailSender.send(mailMessage);

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
