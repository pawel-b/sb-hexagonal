package pl.pawelb.library

import spock.lang.Specification

class LibrarySpec extends Specification {

    def service = new LibraryConfiguration().libraryService(new InMemoryBookRepository());
    def lord = new BookDto(1L, "Tolkien", "Lord of the rings", 12.34d)
    def ice = new BookDto(2L, "Dukaj", "Ice", 34.10d)

    def "should add book and find it by name" () {
        given: "we add a book"
            service.addBook(lord)

        expect: "system has this book"
            service.findByName(lord.bookName) == lord
    }

    def "should find book by id" () {
        given: "we add a book"
            service.addBook(lord)

        expect: "system can find this book by id"
            service.findById(lord.id) == lord
    }

    def "should list books" () {
        given: "we have two books"
            service.addBook(lord)
            service.addBook(ice)

        when: "we ask for books"
            List<BookDto> books = service.findAll();

        then: "system show us books we have added"
            books.contains(lord)
            books.contains(ice)
    }

    def "happy renting scenario" () {
        given: "we have a book"
            service.addBook(lord)

        when: "we ask for books"
            service.rentBook(lord.id)

        then: "system has this book rented"
            service.findByName(lord.bookName).bookState == "RENTED"
    }
}