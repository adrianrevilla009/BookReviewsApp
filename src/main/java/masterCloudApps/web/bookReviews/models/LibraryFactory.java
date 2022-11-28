package masterCloudApps.web.bookReviews.models;

import masterCloudApps.web.bookReviews.BookReviewsApplication;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryFactory {
    private static Library library;

    public static void initializeMockData() {
        Library library = new LibraryBuilder()
                .book(new Book(1, "Title 1", "Description 1", new User("Name 1", "Surname 1"),
                        "Editorial 1", LocalDate.now(), new ArrayList<>()))
                .book(new Book(2, "Title 2", "Description 2", new User("Name 2", "Surname 2"),
                        "Editorial 2", LocalDate.now(), new ArrayList<>()))
                .build();
        LibraryFactory.library = library;
    }

    public static Library getLibrary() {
        return library;
    }

    public static void addBook(Book book) {
        LibraryFactory.getLibrary().addBook(book);
    }

    public static Book getById(int bookId) {
        return LibraryFactory.getLibrary().getById(bookId);
    }
}
