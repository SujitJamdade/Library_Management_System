package com.example.LibraryManagementSystemOct.Controller;


import com.example.LibraryManagementSystemOct.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook/{bookId}/{cardId}")
    public ResponseEntity issueBook(@PathVariable("bookId") Integer bookId, @PathVariable("cardId") Integer cardId){

        
    }


}
