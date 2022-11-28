package masterCloudApps.web.bookReviews.utils;

import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Comment;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.models.LibraryFactory;
import org.springframework.stereotype.Component;

@Component
public class CommentUtils {
    public int getNextFreeId(int bookid) {
        Library library = LibraryFactory.getLibrary();
        Book book = library.getById(bookid);
        int id = 0;
        for (Comment comment : book.getCommentList()) {
            if (comment.getId() > id) {
                id = comment.getId();
            }
        }
        return id + 1;
    }
}
