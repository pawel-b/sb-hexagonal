package pl.pawelb.library;

import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://pl.pawelb.library/", name = "LibraryService")
public interface LibraryService {

    void addAuthor(AuthorDto authorDto);

    List<AuthorDto> findAllAuthors();

    void addBook(BookDto book);

    List<BookDto> findAllBooks();

    BookDto findById(Long id);

    BookDto findByName(String name);

    void rentBook(Long bookId);

}
