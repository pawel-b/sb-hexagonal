package pl.pawelb.library;

import pl.pawelb.utils.BaseRepository;

import java.util.List;

interface AuthorRepository extends BaseRepository<Author, Long> {

    List<Author> findByName(String name);
}
