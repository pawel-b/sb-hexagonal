package pl.pawelb.library;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawelb.utils.Identifiable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
@Data @NoArgsConstructor
class Book implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;

    private String name;
    private Double price;
    private BookState state;
    private Date rentDate;

    public Book(BookDto bookDto) {
        this.id = bookDto.getBookId();
        this.author = new Author(bookDto.getAuthorName());
        this.name = bookDto.getBookName();
        this.price = bookDto.getPrice();
        this.state = BookState.AVAILABLE;
        this.rentDate = bookDto.getRentDate();
    }

}