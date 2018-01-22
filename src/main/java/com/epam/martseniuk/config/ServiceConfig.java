package com.epam.martseniuk.config;

import com.epam.martseniuk.repository.AuthorRepository;
import com.epam.martseniuk.repository.BookRepository;
import com.epam.martseniuk.service.business.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public BookService bookService(BookRepository bookRepository,
                                   AuthorRepository authorRepository) {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
//        bookService.setAuthorRepository();
        return bookService;
    }

}
