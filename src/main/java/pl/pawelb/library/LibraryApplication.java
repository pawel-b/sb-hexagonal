package pl.pawelb.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner init(JpaAuthorRepository authorRepository, JpaBookRepository bookRepository) {
		return (evt) -> Stream.of("Lód", "Hobbit").map(n -> new BookDto(null, "Author " + n, "Book " + n, new Random().nextDouble())).forEach(b -> saveBook(authorRepository, bookRepository, b));
	}

	private Book saveBook(JpaAuthorRepository authorRepository, JpaBookRepository bookRepository, BookDto b) {
		Author author = authorRepository.save(new Author(b.getAuthorName()));
		Book book = new Book(b);
		book.setAuthor(author);
		return bookRepository.save(book);
	}
}
