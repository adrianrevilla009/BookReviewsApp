package masterCloudApps.web.bookReviews.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Library {
    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        Iterator<Book> bookIterator = this.bookList.iterator();
        while (bookIterator.hasNext()) {
            Book bookToRemove = bookIterator.next();
            if (bookToRemove.getId() == book.getId()) {
                bookIterator.remove();
            }
        }
    }

    public Book getById(int bookId) {
        Iterator<Book> bookIterator = this.bookList.iterator();
        while (bookIterator.hasNext()) {
            Book bookToFind = bookIterator.next();
            if (bookToFind.getId() == bookId) {
                return bookToFind;
            }
        }
        return null;
    }
}
