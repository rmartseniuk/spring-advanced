package com.epam.martseniuk.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long authorId;

    private String name;

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy="authors")
//    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

//    public void addBook(Book b) {
//        this.books.add(b);
//        b.getAuthors().add(this);
//    }
//
//    public void removeBook(Book b) {
//        this.books.remove(b);
//        b.getAuthors().remove(this);
//    }
}
