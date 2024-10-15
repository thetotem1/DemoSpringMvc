package be.storm.demo_spring_mvc.pl.models;

import lombok.Data;

@Data
public class BookForm {

    private String isbn;
    private String title;
    private String author;

    public BookForm() {
    }

    public BookForm(String title) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
