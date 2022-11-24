package masterCloudApps.web.bookReviews.controllers;

import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/list")
    public String bookList(Model model) {

        // TODO fetch data from local H2 database
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(
                1,
                "Title 1",
                "Description 1",
                new User("Adrian", "Revilla"),
                "Editorial 1",
                LocalDate.of(2022, 11, 24),
                new ArrayList<>()
        ));
        bookList.add(new Book(2,"Title 2"));
        bookList.add(new Book(3,"Title 3"));
        bookList.add(new Book(4,"Title 4"));

        model.addAttribute("bookList", bookList);

        return "main";
    }

    @GetMapping("/details/{id}")
    public String bookDetail(Model model, @PathVariable("id") int bookId) {
        // TODO fetch data from local H2 database
        Book book = new Book(
                1,
                "Title 1",
                "Description 1",
                new User("Adrian", "Revilla"),
                "Editorial 1",
                LocalDate.of(2022, 11, 24),
                new ArrayList<>()
        );
        model.addAttribute("book", book);

        return "books/book_detail";
    }

    @GetMapping("/createForm")
    public String createBookForm() {
        return "books/create_book";
    }

    @PostMapping("/create")
    public String createBook(@RequestParam String title, @RequestParam String resume, @RequestParam String author,
                             @RequestParam String editorial, @RequestParam String publicationDate) {
        System.out.println("Created" + title + resume + author + editorial + publicationDate);
        return "main";
    }

}
