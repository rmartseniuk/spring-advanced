package com.epam.martseniuk.controller;

import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.service.business.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman_Martseniuk
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String findAllBook(@ModelAttribute("model") ModelMap model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/buy/{bookId}", method = RequestMethod.POST)
    public RedirectView buyBook(@PathVariable Long bookId) throws IOException {
        bookService.buyBook(bookId);
        return new RedirectView("/books");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
