package pl.pawelb.library;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/library")
class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(value = "/author")
    public List<AuthorDto> getAuthors(@RequestParam(value = "authorName", required = false) String authorName) {
        return StringUtils.isEmpty(authorName) ? libraryService.findAllAuthors() : libraryService.findAuthorsByName(authorName);
    }

    @PostMapping(value = "/author")
    public void addAuthor(@RequestBody String authorName) {
        libraryService.saveAuthor(authorName);
    }

    @GetMapping(value = "/author/{authorId}")
    public AuthorDto getAuthorById(@PathVariable Long authorId) {
        return libraryService.findAuthorById(authorId);
    }

    @GetMapping(value = "/book")
    public List<BookDto> getBooks() {
        return libraryService.findAllBooks();
    }

    @GetMapping(value = "/book/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) {
        return libraryService.findBookById(bookId);
    }

    @PostMapping(value = "/book")
    public void addBook(@RequestBody BookDto dto) {
        libraryService.saveBook(dto);
    }

    @PutMapping(value = "/book/{bookId}/rent")
    public void rentBook(@PathVariable Long bookId) {
        libraryService.rentBook(bookId);
    }

    @DeleteMapping(value = "/book/{bookId}/rent")
    public void returnBook(@PathVariable Long bookId) {
        libraryService.returnBook(bookId);
    }

}