package pl.pawelb.library;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AuthorDto {
    Long authorId;
    String authorName;

    public AuthorDto(String authorName) {
        this.authorName = authorName;
    }

    public AuthorDto(Author author) {
        this.authorId = author.getId();
        this.authorName = author.getName();
    }
}
