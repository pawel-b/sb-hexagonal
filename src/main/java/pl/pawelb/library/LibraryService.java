package pl.pawelb.library;

import java.util.List;

public interface LibraryService {

    void addBook(BookDto book);

    BookDto findById(Long id);

    BookDto findByName(String name);

    List<BookDto> findAll();

    void rentBook(Long bookId);
}
