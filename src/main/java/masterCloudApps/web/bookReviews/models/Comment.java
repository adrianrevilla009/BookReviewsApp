package masterCloudApps.web.bookReviews.models;

import lombok.Data;

@Data
public class Comment {
    private User user;
    private String comment;
    private int points;
}
