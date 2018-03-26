package pl.pawelb.library;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void addAuthor(AuthorDto authorDto) {
        Author entity = new Author(authorDto);
        authorRepository.save(entity);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return authorRepository.findAll().stream().map(AuthorDto::new).collect(Collectors.toList());
    }

    @Override
    public void addBook(BookDto bookDto) {
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
        bookRepository.save(book);
    }

}
