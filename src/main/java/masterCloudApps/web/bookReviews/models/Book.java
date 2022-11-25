package masterCloudApps.web.bookReviews.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String resume;
    private User author;
    private String editorial;
    private LocalDate publicationDate;
    private List<Comment> commentList;

    // TODO delete this mock constructor
    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", author=" + author +
                ", editorial='" + editorial + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }
}
