package pl.pawelb.library;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDto> getBooks() {
        return libraryService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) {
        return libraryService.findById(bookId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBook(@RequestBody BookDto dto) {
        libraryService.addBook(dto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rent/{bookId}")
    public void rentBook(@PathVariable Long bookId) {
        libraryService.rentBook(bookId);
    }

}