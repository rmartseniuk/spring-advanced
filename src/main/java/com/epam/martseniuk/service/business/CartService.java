package com.epam.martseniuk.service.business;

import com.epam.martseniuk.entity.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman_Martseniuk
 */
@Service
public class CartService {

    private Map<Book, Integer> basket = new HashMap<>();

    public void add(Book book, Integer count) {
        basket.put(book, count);
    }
}
