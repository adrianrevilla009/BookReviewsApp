package masterCloudApps.web.bookReviews.services;

import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.models.LibraryFactory;
import masterCloudApps.web.bookReviews.models.User;
import masterCloudApps.web.bookReviews.utils.BookUtils;
import masterCloudApps.web.bookReviews.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class BookService {

    private UserUtils utils;

    private BookUtils bookUtils;

    public BookService(UserUtils utils, BookUtils bookUtils) {
        this.utils = utils;
        this.bookUtils = bookUtils;
    }

    public Library getBooks() {
        return LibraryFactory.getLibrary();
    }

    public Book getBookById(int bookId) {
        return LibraryFactory.getById(bookId);
    }

    public Book createBook(String title, String resume, String author, String editorial, String publicationDate) {
        User user = this.utils.convertFromStringToUser(author);
        Book book = new Book(this.bookUtils.getNextFreeId(), title, resume, user, editorial, LocalDate.parse(publicationDate), new ArrayList<>());
        LibraryFactory.addBook(book);

        return book;
    }

}
