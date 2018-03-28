package com.epam.martseniuk.config;

import com.epam.martseniuk.repository.BookRepository;
import com.epam.martseniuk.repository.UserRepository;
import com.epam.martseniuk.service.business.BookService;
import com.epam.martseniuk.service.security.UserDetailsServiceImpl;
import com.epam.martseniuk.util.CertificateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class ServiceConfig {

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
        return bookService;
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository,
                                                 CertificateUtils certificateUtils,
                                                 HttpServletRequest httpServletRequest) {
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        userDetailsService.setUserRepository(userRepository);
        userDetailsService.setCertificateUtils(certificateUtils);
        userDetailsService.setHttpServletRequest(httpServletRequest);
        return userDetailsService;
    }
}
