package masterCloudApps.web.bookReviews.services;

import masterCloudApps.web.bookReviews.models.*;
import masterCloudApps.web.bookReviews.utils.CommentUtils;
import masterCloudApps.web.bookReviews.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CommentService {

    private UserUtils utils;

    private CommentUtils commentUtils;

    public CommentService(UserUtils utils, CommentUtils commentUtils) {
        this.utils = utils;
        this.commentUtils = commentUtils;
    }

    public Comment createComment(int bookId, String owner, String comment, int points) {
        Library library = LibraryFactory.getLibrary();

        User user = this.utils.convertFromStringToUser(owner);

        Book book = library.getById(bookId);
        Comment createdComment = new Comment(commentUtils.getNextFreeId(bookId), user, comment, points);
        book.addComment(createdComment);

        return createdComment;
    }

    public Comment deleteComment(int commentId, int bookId) {
        Library library = LibraryFactory.getLibrary();

        Iterator<Book> bookIterator = library.getBookList().iterator();
        Book foundBook = null;
        while (bookIterator.hasNext()) {
            Book bookToRemove = bookIterator.next();
            if (bookToRemove.getId() == bookId) {
                foundBook = bookToRemove;
            }
        }

        assert foundBook != null;
        Iterator<Comment> commentIterator = foundBook.getCommentList().iterator();
        Comment foundComment = null;
        while (commentIterator.hasNext()) {
            Comment commentToRemove = commentIterator.next();
            if (commentToRemove.getId() == commentId) {
                foundComment = commentToRemove;
                commentIterator.remove();
            }
        }

        return foundComment;
    }
}
