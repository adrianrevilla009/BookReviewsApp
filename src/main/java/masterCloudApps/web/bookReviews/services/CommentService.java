package masterCloudApps.web.bookReviews.services;

import masterCloudApps.web.bookReviews.models.*;
import masterCloudApps.web.bookReviews.utils.UserUtils;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private UserUtils utils;

    public CommentService(UserUtils utils) {
        this.utils = utils;
    }

    public Comment createComment(int id, String owner, String comment, int points) {
        Library library = LibraryFactory.getLibrary();

        User user = this.utils.convertFromStringToUser(owner);

        Book book = library.getById(id);
        Comment createdComment = new Comment(user, comment, points);
        book.addComment(createdComment);

        return createdComment;
    }
}
