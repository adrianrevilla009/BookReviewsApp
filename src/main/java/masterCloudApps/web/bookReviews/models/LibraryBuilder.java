package masterCloudApps.web.bookReviews.models;

import java.util.ArrayList;
import java.util.List;

public class LibraryBuilder {
    private List<Book> bookList;

    public LibraryBuilder() {
        this.bookList = new ArrayList<>();
    }

    public Library build() {
        Library library = new Library();
        library.setBookList(bookList);
        return library;
    }

    public LibraryBuilder book(Book book) {
        this.bookList.add(book);
        return this;
    }
}
