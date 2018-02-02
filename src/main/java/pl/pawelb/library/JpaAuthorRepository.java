package pl.pawelb.library;

import org.springframework.data.jpa.repository.JpaRepository;

interface JpaAuthorRepository extends AuthorRepository, JpaRepository<Author, Long> {
}
