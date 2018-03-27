package pl.pawelb.library

import pl.pawelb.utils.InMemoryJpaRepository
import spock.lang.Specification

class InMemoryAuthorRepository extends InMemoryJpaRepository<Author> implements AuthorRepository {}

class InMemoryBookRepository extends InMemoryJpaRepository<Book> implements BookRepository {

    Book findByName(String name) {
        return findAll().stream().filter{e -> Objects.equals(e.getName(), name)}.findFirst().orElse(null);
    }
}

class LibrarySpec extends Specification {

    def service = new LibraryConfiguration().libraryService(new InMemoryAuthorRepository(), new InMemoryBookRepository());
    def lord = new BookDto(1L, "Tolkien", "Lord of the rings", 12.34d, BookState.AVAILABLE.name(), null)
    def ice = new BookDto(2L, "Dukaj", "Ice", 34.10d, BookState.AVAILABLE.name(), null)
    def odyssey = new BookDto(3L, "Homer", "Odyssey", 3123.10d, BookState.RENTED.name(), new Date())

    def "should add book and find it by name" () {
        given: "we add a book"
            service.saveBook(lord)

        expect: "system has this book"
            service.findByName(lord.bookName) == lord
    }

    def "should find book by id" () {
        given: "we add a book"
            service.saveBook(lord)

        expect: "system can find this book by bookId"
            service.findById(lord.bookId) == lord
    }

    def "should list books" () {
        given: "we have two books"
            service.saveBook(lord)
            service.saveBook(ice)

        when: "we ask for books"
            List<BookDto> books = service.findAllBooks();

        then: "system show us books we have added"
            books.contains(lord)
            books.contains(ice)
    }

    def "happy renting scenario" () {
        given: "we have a book"
            service.saveBook(lord)

        when: "we ask for books"
            service.rentBook(lord.bookId)

        then: "system has this book rented"
            def result = service.findById(lord.bookId)
            result.bookState == "RENTED"
            result.rentDate != null
    }

    def "happy returning scenario" () {
        given: "we have rented a book"
            service.saveBook(odyssey)

        when: "we ask for books"
            service.returnBook(odyssey.bookId)

        then: "system has this book rented"
            def result = service.findById(odyssey.bookId)
            result.bookState == "AVAILABLE"
            result.rentDate == null
    }

}