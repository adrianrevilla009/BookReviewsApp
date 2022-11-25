package masterCloudApps.web.bookReviews;

import masterCloudApps.web.bookReviews.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class BookReviewsApplication {

	public static void main(String[] args) {
		LibraryFactory.initializeMockData();
		SpringApplication.run(BookReviewsApplication.class, args);
	}
}
