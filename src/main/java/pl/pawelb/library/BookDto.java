package pl.pawelb.library;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawelb.utils.JsonDateSerializer;

import java.util.Date;

@Data
@NoArgsConstructor
public class BookDto {
    Long bookId;
    Long authorId;
    String authorName;
    String bookName;
    String bookState;
    Double price;
    @JsonSerialize(using=JsonDateSerializer.class)
    Date rentDate;

    public BookDto(Long bookId, String authorName, String bookName, Double price, String bookState, Date rentDate) {
        this.bookId = bookId;
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookState = bookState;
        this.price = price;
        this.rentDate = rentDate;
    }

    public BookDto(Book book) {
        this.bookId = book.getId();
        this.authorId = book.getAuthor().getId();
        this.authorName = book.getAuthor().getName();
        this.bookName = book.getName();
        this.bookState = book.getState().name();
        this.price = book.getPrice();
        this.rentDate = book.getRentDate();
    }

}
