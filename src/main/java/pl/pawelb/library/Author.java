package pl.pawelb.library;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pawelb.utils.Identifiable;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data @NoArgsConstructor
class Author implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author(AuthorDto authorDto) {
        this.id = authorDto.getAuthorId();
        this.name = authorDto.getAuthorName();
    }

}
