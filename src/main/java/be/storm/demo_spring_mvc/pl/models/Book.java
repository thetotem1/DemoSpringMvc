package be.storm.demo_spring_mvc.pl.models;

public record Book(
        String isbn,
        String name,
        String author
) {
}
