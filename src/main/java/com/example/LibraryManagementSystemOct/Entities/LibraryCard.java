package com.example.LibraryManagementSystemOct.Entities;


import com.example.LibraryManagementSystemOct.Enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cardNo;  // Primary Key for library_card

    @Enumerated(value = EnumType.STRING)
    CardStatus cardStatus;

    String nameOnCard;

    Integer noOfBookIssued;

    // Library Card needs to connect with the student

    @OneToOne
    @JoinColumn
    Student student; // this is FK in library_card table
    // student variable we need to put in mappedBy attribute in the parent class

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
            @JsonIgnore
    List<Transaction> transactionList = new ArrayList<>();





}
