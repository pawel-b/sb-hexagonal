package pl.pawelb.library;

import pl.pawelb.utils.BaseRepository;
import pl.pawelb.utils.Identifiable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryJpaRepository<T extends Identifiable<Long>> implements BaseRepository<T, Long> {

    private ConcurrentHashMap<Long, T> repo = new ConcurrentHashMap<>();

    @Override
    public List<T> findAll() {
        return repo.values().stream().collect(Collectors.toList());
    }

    @Override
    public T findOne(Long paramID) {
        return repo.get(paramID);
    }

    @Override
    public <S extends T> S save(S paramS) {
        repo.put(paramS.getId(), paramS);
        return (S) repo.get(paramS.getId());
    }
}
