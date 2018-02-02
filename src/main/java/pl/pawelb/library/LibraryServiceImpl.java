package pl.pawelb.library;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    private BookRepository bookRepository;

    public LibraryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(BookDto bookDto) {
        Book book = new Book(bookDto);
        bookRepository.save(book);
    }

    @Override
    public BookDto findById(Long id) {
        return Stream.of(bookRepository.findOne(id)).map(BookDto::new).findFirst().orElse(null);
    }

    @Override
    public BookDto findByName(String name) {
        return Stream.of(bookRepository.findByName(name)).map(BookDto::new).findFirst().orElse(null);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Override
    public void rentBook(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        book.setState(BookState.RENTED);
        bookRepository.save(book);
    }

}
