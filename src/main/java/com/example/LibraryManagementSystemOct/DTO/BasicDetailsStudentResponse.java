package com.example.LibraryManagementSystemOct.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicDetailsStudentResponse {

    String name;
    Integer age;
    String mobNo;
}
