package com.epam.martseniuk.repository;

import com.epam.martseniuk.entity.Author;
import com.epam.martseniuk.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorRepository.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        Author remark = new Author("Remark");
        Author tolstoi = new Author("Lev Tolstoi");


        Book western = new Book("On the Western front without changes", "121", remark, 2);
//        western.setAuthors(Collections.singletonList(remark));
        Book three_friends = new Book("Three friends", "212", remark, 2);
//        three_friends.setAuthors(Collections.singletonList(remark));
        Book war_and_peace = new Book("War and Peace", "300", tolstoi, 1);
//        war_and_peace.setAuthors(Collections.singletonList(tolstoi));
        Book anna_karenina = new Book("Anna Karenina", "250", tolstoi, 0);
//        anna_karenina.setAuthors(Collections.singletonList(tolstoi));

        western = bookRepository.save(western);
        three_friends = bookRepository.save(three_friends);
        war_and_peace = bookRepository.save(war_and_peace);
        anna_karenina = bookRepository.save(anna_karenina);

        authorRepository.save(remark);
        authorRepository.save(tolstoi);

//        remark.addBook(western);
//        remark.addBook(three_friends);
//        tolstoi.addBook(war_and_peace);
//        tolstoi.addBook(anna_karenina);
//        authorRepository.saveAll(Arrays.asList(remark, tolstoi));
    }

    @Test
    public void testFindAllAuthors() {
        Iterable<Author> allAuthors = authorRepository.findAll();
        for (Author author: allAuthors) {
            LOG.info(author.toString());
        }
    }

    @Test
    public void testFindAllBook() {
        Iterable<Book> allBook = bookRepository.findAll();
        for (Book book: allBook) {
            LOG.info(book.toString());
        }
    }

}