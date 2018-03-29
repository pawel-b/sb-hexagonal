package pl.pawelb.library;

import java.util.List;

@javax.jws.WebService(serviceName = "LibraryService", portName = "LibraryService",
        targetNamespace = "http://pl.pawelb.library/",
        endpointInterface = "pl.pawelb.library.LibraryService")
public class LibraryWsServiceImpl implements LibraryService {

    private LibraryService libraryService;

    public LibraryWsServiceImpl() {
    }

    public LibraryWsServiceImpl(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void saveAuthor(String authorName) {
        libraryService.saveAuthor(authorName);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return libraryService.findAllAuthors();
    }

    @Override
    public AuthorDto findAuthorById(Long id) {
        return libraryService.findAuthorById(id);
    }

    @Override
    public List<AuthorDto> findAuthorsByName(String name) {
        return libraryService.findAuthorsByName(name);
    }

    @Override
    public void saveBook(BookDto book) {
        libraryService.saveBook(book);
    }

    @Override
    public List<BookDto> findAllBooks() {
        return libraryService.findAllBooks();
    }

    @Override
    public BookDto findBookById(Long id) {
        return libraryService.findBookById(id);
    }

    @Override
    public List<BookDto> findBooksByName(String name) {
        return libraryService.findBooksByName(name);
    }

    @Override
    public void rentBook(Long bookId) {
        libraryService.rentBook(bookId);
    }

    @Override
    public void returnBook(Long bookId) {
        libraryService.returnBook(bookId);
    }
}
