package com.example.LibraryManagementSystemOct.Repository;

import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import com.example.LibraryManagementSystemOct.Entities.Transaction;
import com.example.LibraryManagementSystemOct.Enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction findTransactionByBookAndCardAndTransactionStatus(Book book, LibraryCard card, TransactionStatus transactionStatus);


}
