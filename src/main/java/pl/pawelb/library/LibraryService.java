package pl.pawelb.library;

import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://pl.pawelb.library/", name = "LibraryService")
public interface LibraryService {

    void saveAuthor(String authorName);

    List<AuthorDto> findAllAuthors();

    AuthorDto findAuthorById(Long id);

    List<AuthorDto> findAuthorsByName(String name);

    void saveBook(BookDto book);

    List<BookDto> findAllBooks();

    BookDto findBookById(Long id);

    List<BookDto> findBooksByName(String name);

    void rentBook(Long bookId);

    void returnBook(Long bookId);
}
