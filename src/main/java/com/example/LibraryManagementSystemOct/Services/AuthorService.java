package com.example.LibraryManagementSystemOct.Services;

import com.example.LibraryManagementSystemOct.Entities.Author;
import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {

        authorRepository.save(author);

        return author.getAuthorName() + " has been added into author Table";
    }

    public List<String> getallAuthorsName(){
        List<Author> authors = authorRepository.findAll();
        List<String> authorName = new ArrayList<>();

        for(Author author : authors){
            authorName.add(author.getAuthorName());
        }
        return authorName;
    }

    public Author getAuthorById(Integer authorId) throws Exception {

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            throw new Exception("Author Id is invalid");
        }

        Author author = optionalAuthor.get();
        return author;
    }

    public List<String> getBookNames(Integer authorId){

        List<String> bookNames = new ArrayList<>();

        Author author = authorRepository.findById(authorId).get();
        List<Book> bookList = author.getBookList();

        for(Book book:bookList) {
            bookNames.add(book.getBookName());
        }
        return bookNames;
    }
}
