package be.storm.demo_spring_mvc.pl.controllers;

import be.storm.demo_spring_mvc.pl.models.Book;
import be.storm.demo_spring_mvc.pl.models.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {


    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("123", "Le Livre", "L'auteur"));
        books.add(new Book("456", "The Book", "The Author"));
        books.add(new Book("789", "Jeoffrey", "Nico"));
    }


    @GetMapping("/book/{isbn}")
    public String getOne(
            @PathVariable
            String isbn,
            Model model
    ) {
        for (Book book : books) {
            if (book.isbn().equals(isbn)) {
                model.addAttribute("book", book);
                return "book";
            }
        }
        return "error";

    }

    @GetMapping("/book")
    public String books(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/add")    // ici je crée deja un livre vide
    public String addBook(Model model) {
        model.addAttribute("book", new BookForm());
        return "add";
    }

    @PostMapping("/book/add")   // et ici je change les infos du livre
    public String addBook(
            @ModelAttribute
            BookForm book,
            Model model) {
        books.add(new Book(book.getIsbn(), book.getTitle(), book.getAuthor()));
        return "redirect:/book";
    }

    @GetMapping("/filter")
    public String filterBooks(
            @RequestParam(name = "title", required = false, defaultValue = "Default")
            String title,
            Model model
    ) {
        return "";
    }

}