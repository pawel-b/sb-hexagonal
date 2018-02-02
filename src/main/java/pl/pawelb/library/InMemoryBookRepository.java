package pl.pawelb.library;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryBookRepository implements BookRepository {

    private ConcurrentHashMap<Long, Book> repo = new ConcurrentHashMap<>();

    @Override
    public Book findByName(String name) {
        return repo.values().stream().filter(e -> Objects.equals(e.getName(), name)).findFirst().orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return repo.values().stream().collect(Collectors.toList());
    }

    @Override
    public Book findOne(Long paramID) {
        return repo.get(paramID);
    }

    @Override
    public <S extends Book> S save(S paramS) {
        repo.put(paramS.getId(), paramS);
        return (S) repo.get(paramS.getId());
    }
}
