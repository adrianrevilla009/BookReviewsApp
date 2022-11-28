package masterCloudApps.web.bookReviews.utils;

import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.models.LibraryFactory;
import org.springframework.stereotype.Component;

@Component
public class BookUtils {
    public int getNextFreeId() {
        Library library = LibraryFactory.getLibrary();
        int id = 0;
        for (Book book : library.getBookList()) {
            if (book.getId() > id) {
                id = book.getId();
            }
        }
        return id + 1;
    }
}
