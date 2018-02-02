package pl.pawelb.library;

import org.springframework.data.jpa.repository.JpaRepository;

interface JpaBookRepository extends BookRepository, JpaRepository<Book, Long> {
}
