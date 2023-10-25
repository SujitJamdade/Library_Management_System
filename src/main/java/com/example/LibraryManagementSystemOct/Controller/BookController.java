package com.example.LibraryManagementSystemOct.Controller;

import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Enums.Genre;
import com.example.LibraryManagementSystemOct.Exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystemOct.Services.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("book")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book, @RequestParam("authorId") Integer authorId) {

        try{
            String response = bookService.addBook(book,authorId);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBookByGenre")
    public List<String> getBooksByGenre(@RequestParam("genre") Genre genre)
    {

        return null;

    }
}

