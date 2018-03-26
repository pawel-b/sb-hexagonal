package pl.pawelb.library;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/author")
    public List<AuthorDto> getAuthors() {
        return libraryService.findAllAuthors();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/author")
    public void addAuthor(@RequestBody AuthorDto dto) {
        libraryService.addAuthor(dto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book")
    public List<BookDto> getBooks() {
        return libraryService.findAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) {
        return libraryService.findById(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book")
    public void addBook(@RequestBody BookDto dto) {
        libraryService.addBook(dto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book/rent/{bookId}")
    public void rentBook(@PathVariable Long bookId) {
        libraryService.rentBook(bookId);
    }

}