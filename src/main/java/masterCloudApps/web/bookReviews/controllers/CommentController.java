package masterCloudApps.web.bookReviews.controllers;

import masterCloudApps.web.bookReviews.models.*;
import masterCloudApps.web.bookReviews.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;
    Logger logger = LoggerFactory.getLogger(BookController.class);

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create/{id}")
    public RedirectView createComment(@PathVariable("id") int id, @RequestParam String owner,
                                      @RequestParam String comment, @RequestParam int points) {

        Comment createdComment = this.commentService.createComment(id, owner, comment, points);

        logger.debug("Creating comment " + createdComment.toString() + " !");

        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/book/details/{id}");
        return rv;
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteComment(@PathVariable("id") int commentId, @RequestParam int bookId) {

        Comment deletedComment = this.commentService.deleteComment(commentId, bookId);

        logger.debug("Deleting comment " + deletedComment.toString() + " !");

        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/book/details/" + bookId);
/*        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView();*/
        return rv;
    }
}
