package com.example.LibraryManagementSystemOct.Controller;


import com.example.LibraryManagementSystemOct.Entities.Author;
import com.example.LibraryManagementSystemOct.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){

        String response = authorService.addAuthor(author);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/findAllAuthorNames")
    public List<String> getallAuthorsName(){
        return authorService.getallAuthorsName();
    }

    @GetMapping("/getAuthor/{id}")
    public ResponseEntity getAuthorById(@PathVariable("id") Integer id){

        try {
            Author author = authorService.getAuthorById(id);
            return new ResponseEntity(author, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
