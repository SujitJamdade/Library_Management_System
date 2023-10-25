package com.example.LibraryManagementSystemOct.Services;

import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Entities.LibraryCard;
import com.example.LibraryManagementSystemOct.Entities.Transaction;
import com.example.LibraryManagementSystemOct.Enums.CardStatus;
import com.example.LibraryManagementSystemOct.Enums.TransactionStatus;
import com.example.LibraryManagementSystemOct.Exceptions.*;
import com.example.LibraryManagementSystemOct.Repository.BookRepository;
import com.example.LibraryManagementSystemOct.Repository.CardRepository;
import com.example.LibraryManagementSystemOct.Repository.TransactionRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service

public class TransactionService {


    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    static final Integer Max_LIMIT_OF_BOOKS =3;
    static final long FINE_PER_DAY = 5;

    public String issueBook(Integer bookId, Integer cardId) throws Exception{

        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        // Validation

        // Invalid BookId
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (!optionalBook.isPresent()){
            throw new BookNotFoundException("Book Id is in valid");
        }

        Book book = optionalBook.get();
        // Availability of book
        if(!book.getIsBookAvailable()){
            throw new BookNotAvailable("Book is unavailable");
        }

        // Valid CardId
        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);

        if(!optionalLibraryCard.isPresent()){
            throw new CardNotFoundException("Invalid Card Id");
        }

        LibraryCard card = optionalLibraryCard.get();

        // Valid Card Status

        if(!card.getCardStatus().equals(CardStatus.ACTIVE)){
            throw new InvalidCardStatusException("Card Status in not Active");
        }

        // Maximum no of book Issues : MAX_LIMIT = 3
        if(card.getNoOfBookIssued()==Max_LIMIT_OF_BOOKS){

            throw new MaxBookAlreadyIssued(Max_LIMIT_OF_BOOKS +"is maximum books that can be issued");

        }

        // Creating the transaction Entity

        transaction.setTransactionStatus(TransactionStatus.ISSUED);
        card.setNoOfBookIssued(card.getNoOfBookIssued()+1);
        book.setIsBookAvailable(false);    // Book is no longer available since it's issues

        // Setting FK
        transaction.setBook(book);
        transaction.setCard(card);

        // Saving relevant Entity : Bi directional mapping
        book.getTransactionList().add(transaction);
        card.getTransactionList().add(transaction);

        // Instead of saving the parent : just save the child
        transactionRepository.save(transaction);

        return "The book with bookId "+bookId+" has been issued " +
                "to card with "+cardId;

    }

    public String returnBook(Integer bookId, Integer cardId){

        Book book = bookRepository.findById(bookId).get();
        LibraryCard card = cardRepository.findById(cardId).get();

        // I need to find out that issued transaction

        Transaction transaction = transactionRepository.findTransactionByBookAndCardAndTransactionStatus(book, card,TransactionStatus.ISSUED);

        Date issueDate = transaction.getCreatedOn();

        //Predefined method that you can use to calculate days
        long milliSeconds = Math.abs(System.currentTimeMillis()-issueDate.getTime());
        long days = TimeUnit.DAYS.convert(milliSeconds,TimeUnit.MILLISECONDS);

        int fineAmount = 0;

        if(days>15){
            fineAmount = Math.toIntExact((days-15) * FINE_PER_DAY);
        }

        Transaction newTransaction = new Transaction();

        newTransaction.setTransactionStatus(TransactionStatus.ISSUED);
        newTransaction.setReturnDate(new Date());
        newTransaction.setFine(fineAmount);

        transaction.setBook(book);
        transaction.setCard(card);

        book.setIsBookAvailable(true);
        card.setNoOfBookIssued(card.getNoOfBookIssued()-1);

        book.getTransactionList().add(newTransaction);
        card.getTransactionList().add(newTransaction);

        transactionRepository.save(newTransaction);

        return "Book has been returned";
    }

}
