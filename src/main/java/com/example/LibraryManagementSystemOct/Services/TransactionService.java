package com.example.LibraryManagementSystemOct.Services;

import com.example.LibraryManagementSystemOct.Repository.TransactionRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service

public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(Integer bookId, Integer cardId) throws Exception{


    }


}
