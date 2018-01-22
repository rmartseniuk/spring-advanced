package com.epam.martseniuk.repository;

import com.epam.martseniuk.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
