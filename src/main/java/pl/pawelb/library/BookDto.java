package pl.pawelb.library;

import java.util.Objects;

public class BookDto {
    private final Long id;
    private final String authorName;
    private final String bookName;
    private final String bookState;
    private final Double price;

    public BookDto(Long id, String authorName, String bookName, Double price) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookState = BookState.AVAILABLE.name();
        this.price = price;
    }

    public BookDto(Book book) {
        this.id = book.getId();
        this.authorName = book.getAuthor().getName();
        this.bookName = book.getName();
        this.bookState = book.getState().name();
        this.price = book.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookState() {
        return bookState;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) &&
                Objects.equals(authorName, bookDto.authorName) &&
                Objects.equals(bookName, bookDto.bookName) &&
                Objects.equals(bookState, bookDto.bookState) &&
                Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, bookName, bookState, price);
    }
}
