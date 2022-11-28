package masterCloudApps.web.bookReviews.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {

    private int id;
    private User user;
    private String comment;
    private int points;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                "user=" + user +
                ", comment='" + comment + '\'' +
                ", points=" + points +
                '}';
    }
}
