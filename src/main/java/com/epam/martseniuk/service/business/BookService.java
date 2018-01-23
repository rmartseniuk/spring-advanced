package com.epam.martseniuk.service.business;

import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.repository.AuthorRepository;
import com.epam.martseniuk.repository.BookRepository;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Roman_Martseniuk
 */
@Setter
public class BookService {

    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Transactional
    public Book buyBook(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        if (Objects.isNull(book) && book.getCount() != 0) {
            throw new RuntimeException();
        }
        book.setCount(book.getCount() - 1);
        bookRepository.save(book);
        return book;
    }
}
