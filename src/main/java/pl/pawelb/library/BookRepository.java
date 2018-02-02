package pl.pawelb.library;

import pl.pawelb.utils.BaseRepository;

interface BookRepository extends BaseRepository<Book, Long> {

    Book findByName(String name);
}
