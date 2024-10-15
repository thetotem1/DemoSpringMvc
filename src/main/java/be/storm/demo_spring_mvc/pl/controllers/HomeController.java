package be.storm.demo_spring_mvc.pl.controllers;

import be.storm.demo_spring_mvc.pl.models.Book;
import be.storm.demo_spring_mvc.pl.models.BookForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



    @GetMapping("/") //  url
    public String home() {
        return "home";  // path vers html (depuis template)
    }

    @GetMapping("/hello/{name}")
    public String hello(
            @PathVariable
            String name,
            Model model) {
        String sentence = "Hello " + name + "!";
        model.addAttribute("sentence", sentence);
        return "Hello";
    }

    

}
