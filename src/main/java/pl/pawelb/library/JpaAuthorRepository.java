package pl.pawelb.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAuthorRepository extends AuthorRepository, JpaRepository<Author, Long> {
}
