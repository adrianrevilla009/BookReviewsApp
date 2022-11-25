package masterCloudApps.web.bookReviews;

import masterCloudApps.web.bookReviews.models.Book;
import masterCloudApps.web.bookReviews.models.Library;
import masterCloudApps.web.bookReviews.models.LibraryBuilder;
import masterCloudApps.web.bookReviews.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class BookReviewsApplication {

	private static Library library;

	public static void main(String[] args) {
		initializeMockData();
		SpringApplication.run(BookReviewsApplication.class, args);
	}

	private static void initializeMockData() {
		Library library = new LibraryBuilder()
				.book(new Book(1, "Title 1", "Description 1", new User("Name 1", "Surname 1"),
						"Editorial 1", LocalDate.now(), new ArrayList<>()))
				.book(new Book(2, "Title 2", "Description 2", new User("Name 2", "Surname 2"),
						"Editorial 2", LocalDate.now(), new ArrayList<>()))
				.build();
		BookReviewsApplication.library = library;
	}

	public static Library getLibrary() {
		return library;
	}
}
