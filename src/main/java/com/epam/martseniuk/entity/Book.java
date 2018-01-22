package com.epam.martseniuk.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;

    private String title;

    private String price;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "author_book",
//            joinColumns = {@JoinColumn(name = "bookId")},
//            inverseJoinColumns = {@JoinColumn(name = "authorId")})
//    private List<Author> authors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    public Book(String title, String price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    //    public void addAuthor(Author a) {
//        this.authors.add(a);
//        a.getBooks().add(this);
//    }
//
//    public void removeAuthor(Author a) {
//        this.authors.remove(a);
//        a.getBooks().remove(this);
//    }
}
