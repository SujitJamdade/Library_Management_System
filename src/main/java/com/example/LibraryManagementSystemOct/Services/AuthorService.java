package com.example.LibraryManagementSystemOct.Services;

import com.example.LibraryManagementSystemOct.Entities.Author;
import com.example.LibraryManagementSystemOct.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Author getAuthorById(Integer id) throws Exception {

        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(!optionalAuthor.isPresent()){
            throw new Exception("Author Id is invalid");
        }

        Author author = optionalAuthor.get();
        return author;
    }
}
