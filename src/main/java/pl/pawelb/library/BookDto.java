package pl.pawelb.library;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    Long bookId;
    Long authorId;
    String authorName;
    String bookName;
    String bookState;
    Double price;

    public BookDto(Long bookId, Long authorId, String bookName, Double price) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.bookName = bookName;
        this.bookState = BookState.AVAILABLE.name();
        this.price = price;
    }

    public BookDto(Long bookId, String authorName, String bookName, Double price) {
        this.bookId = bookId;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookState = BookState.AVAILABLE.name();
        this.price = price;
    }

    public BookDto(Book book) {
        this.bookId = book.getId();
        this.authorId = book.getAuthor().getId();
        this.authorName = book.getAuthor().getName();
        this.bookName = book.getName();
        this.bookState = book.getState().name();
        this.price = book.getPrice();
    }

}
