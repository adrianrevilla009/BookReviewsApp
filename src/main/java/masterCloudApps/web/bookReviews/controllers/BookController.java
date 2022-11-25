package masterCloudApps.web.bookReviews.controllers;

import masterCloudApps.web.bookReviews.BookReviewsApplication;
import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.models.LibraryFactory;
import masterCloudApps.web.bookReviews.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/list")
    public String bookList(Model model) {
        Library library = LibraryFactory.getLibrary();

        model.addAttribute("bookList", library.getBookList());

        return "main";
    }

    @GetMapping("/details/{id}")
    public String bookDetail(Model model, @PathVariable("id") int bookId) {
        Book book = LibraryFactory.getById(bookId);

        model.addAttribute("book", book);

        return "books/book_detail";
    }

    @GetMapping("/createForm")
    public String createBookForm() {
        return "books/create_book";
    }

    @PostMapping("/create")
    public RedirectView createBook(@RequestParam String title, @RequestParam String resume, @RequestParam String author,
                             @RequestParam String editorial, @RequestParam String publicationDate) {
        // TODO ser user and publication date
        User authorUser = new User(author, "");
        Book book = new Book(3, title, resume, authorUser, editorial, LocalDate.now(), new ArrayList<>());
        LibraryFactory.addBook(book);
        System.out.println("Created" + title + resume + author + editorial + publicationDate);
        return new RedirectView("/book/list");
    }

}
