package com.epam.martseniuk.repository;

import com.epam.martseniuk.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
