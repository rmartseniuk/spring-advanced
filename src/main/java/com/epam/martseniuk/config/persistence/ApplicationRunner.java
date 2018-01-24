package com.epam.martseniuk.config.persistence;

import com.epam.martseniuk.entity.Author;
import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.entity.User;
import com.epam.martseniuk.repository.AuthorRepository;
import com.epam.martseniuk.repository.BookRepository;
import com.epam.martseniuk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        Author remark = new Author("Remark");
        Author tolstoi = new Author("Lev Tolstoi");
        remark = authorRepository.save(remark);
        tolstoi = authorRepository.save(tolstoi);

        Book western = new Book("On the Western front without changes", "121", remark, 2);
        Book three_friends = new Book("Three friends", "212", remark, 2);
        Book war_and_peace = new Book("War and Peace", "300", tolstoi, 1);
        Book anna_karenina = new Book("Anna Karenina", "250", tolstoi, 0);

        western = bookRepository.save(western);
        three_friends = bookRepository.save(three_friends);
        war_and_peace = bookRepository.save(war_and_peace);
        anna_karenina = bookRepository.save(anna_karenina);

        User user = new User("test", "test", "5a57407d");
        userRepository.save(user);
    }

}
