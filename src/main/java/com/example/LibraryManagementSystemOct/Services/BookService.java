package com.example.LibraryManagementSystemOct.Services;


import com.example.LibraryManagementSystemOct.Entities.Author;
import com.example.LibraryManagementSystemOct.Entities.Book;
import com.example.LibraryManagementSystemOct.Exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystemOct.Repository.AuthorRepository;
import com.example.LibraryManagementSystemOct.Repository.BookRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    AuthorRepository authorRepository;


    public String addBook(Book book, Integer authorId) throws AuthorNotFoundException {

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if ((!optionalAuthor.isPresent())){
            throw new AuthorNotFoundException("Author Id is invalid");
        }

        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.getBookList().add(book);

        authorRepository.save(author);

        return book.getBookName() + " book has been added to the DB";
    }
}
