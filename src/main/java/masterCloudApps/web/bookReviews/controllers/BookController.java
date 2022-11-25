package masterCloudApps.web.bookReviews.controllers;

import masterCloudApps.web.bookReviews.BookReviewsApplication;
import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String getBooks(Model model) {

        Library library = this.bookService.getBooks();

        model.addAttribute("bookList", library.getBookList());

        logger.debug("Getting books!");
        return "main";
    }

    @GetMapping("/details/{id}")
    public String bookDetail(Model model, @PathVariable("id") int bookId) {
        Book book = this.bookService.getBookById(bookId);

        model.addAttribute("book", book);

        logger.debug("Getting book " + bookId + " details!");
        return "books/book_detail";
    }

    @GetMapping("/createForm")
    public String createBookForm() {
        logger.debug("Accessing to create book form!");
        return "books/create_book";
    }

    @PostMapping("/create")
    public RedirectView createBook(@RequestParam String title, @RequestParam String resume, @RequestParam String author,
                             @RequestParam String editorial, @RequestParam String publicationDate) {
        Book book = this.bookService.createBook(title, resume, author, editorial, publicationDate);

        logger.debug("Creating book " + book.toString() + " !");
        return new RedirectView("/book/list");
    }

}
