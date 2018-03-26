package pl.pawelb.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends BookRepository, JpaRepository<Book, Long> {
}
