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
    public void saveAuthor(AuthorDto authorDto) {
        libraryService.saveAuthor(authorDto);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return libraryService.findAllAuthors();
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
    public BookDto findById(Long id) {
        return libraryService.findById(id);
    }

    @Override
    public BookDto findByName(String name) {
        return libraryService.findByName(name);
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
