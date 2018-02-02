package pl.pawelb.library;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;

    private String name;
    private Double price;
    private BookState state;

    public Book() {
    }

    public Book(BookDto bookDto) {
        this.id = bookDto.getId();
        this.author = new Author(bookDto.getAuthorName());
        this.name = bookDto.getBookName();
        this.price = bookDto.getPrice();
        this.state = BookState.AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(author, book.author) &&
                Objects.equals(name, book.name) &&
                Objects.equals(price, book.price) &&
                Objects.equals(state, book.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, price, state);
    }
}