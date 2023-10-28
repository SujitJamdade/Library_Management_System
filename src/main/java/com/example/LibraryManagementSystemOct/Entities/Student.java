package com.example.LibraryManagementSystemOct.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "student") //This class will have a table whose name is studentTable so providing name as student
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    Integer studentId;  // due to @Id annotation it can behave as primary key

    String name;

    int age;

    @Column(name = "contactNo", unique = true,nullable = false)
    String mobNo;

    String emailId;

    String bloodGroup;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
            @JsonIgnore
    LibraryCard libraryCard;

    // this should also have libraryCard info


}
