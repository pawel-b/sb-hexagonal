package pl.pawelb.library;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AuthorDto {
    Long id;
    String authorName;

    public AuthorDto(Author author) {
        this.id = author.getId();
        this.authorName = author.getName();
    }
}
