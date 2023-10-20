package com.example.LibraryManagementSystemOct.Entities;

import com.example.LibraryManagementSystemOct.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer trancationID;

    @Enumerated(value = EnumType.STRING)
    TransactionStatus transactionStatus;

    Date returnDate;

    Integer fine;

    @CreationTimestamp
    Date createdOn;

    @UpdateTimestamp
    Date lastModifiedOn;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
