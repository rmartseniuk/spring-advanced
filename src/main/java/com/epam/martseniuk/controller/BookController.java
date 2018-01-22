package com.epam.martseniuk.controller;

import com.epam.martseniuk.entity.Book;
import com.epam.martseniuk.service.business.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Roman_Martseniuk
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

}
