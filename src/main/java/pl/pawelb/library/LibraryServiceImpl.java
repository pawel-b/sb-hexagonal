package pl.pawelb.library;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public LibraryServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveAuthor(String authorName) {
        Author entity = new Author(authorName);
        authorRepository.save(entity);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    @Override
    public void saveBook(BookDto bookDto) {
        Book entity = new Book(bookDto);
        bookRepository.save(entity);
    }

    @Override
    public List<BookDto> findAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
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
    public void rentBook(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        book.setState(BookState.RENTED);
        book.setRentDate(new Date());
        bookRepository.save(book);
    }

    @Override
    public void returnBook(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        book.setState(BookState.AVAILABLE);
        book.setRentDate(null);
        bookRepository.save(book);
    }
}
