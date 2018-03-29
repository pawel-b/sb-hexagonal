package pl.pawelb.library;

import org.springframework.data.jpa.repository.Query;
import pl.pawelb.utils.BaseRepository;

import java.util.List;

interface BookRepository extends BaseRepository<Book, Long> {

    List<Book> findByName(String name);

    @Query("select b from Book b join fetch b.author")
    List<Book> findAll();
}
