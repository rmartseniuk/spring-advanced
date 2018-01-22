package com.epam.martseniuk.service.business;

import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.repository.AuthorRepository;
import com.epam.martseniuk.repository.BookRepository;
import lombok.Setter;

import java.util.List;

/**
 * @author Roman_Martseniuk
 */
@Setter
public class BookService {

    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
