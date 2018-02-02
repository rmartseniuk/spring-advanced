package com.epam.martseniuk.service.business;

import com.epam.martseniuk.aspect.Audit;
import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.repository.BookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Roman_Martseniuk
 */
@Setter
@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

//    @Audit
    public Book buyBook(Long bookId) throws IOException {
        Book book = bookRepository.findOne(bookId);
        if (Objects.isNull(book) || book.getCount() == 0) {
            throw new RuntimeException();
        }
        book.setCount(book.getCount() - 1);
        bookRepository.save(book);
        if (0 == 0) {
            throw new IOException();
        }

        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
