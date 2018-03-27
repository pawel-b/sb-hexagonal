package pl.pawelb.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner init(JpaAuthorRepository authorRepository, JpaBookRepository bookRepository) {
		return (evt) -> Stream.of("Dukaj-Lód", "Tolkien-Hobbit", "Homer-Odyseja", "Cyceron-Anegdoty")
				.map(n -> new BookDto(null, n.split("-")[0], n.split("-")[1], new BigDecimal(new Random().nextDouble() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(), BookState.AVAILABLE.name(), null))
				.forEach(b -> saveBook(authorRepository, bookRepository, b));
	}

	private Book saveBook(JpaAuthorRepository authorRepository, JpaBookRepository bookRepository, BookDto b) {
		Author author = authorRepository.save(new Author(b.getAuthorName()));
		Book book = new Book(b);
		book.setAuthor(author);
		return bookRepository.save(book);
	}
}
