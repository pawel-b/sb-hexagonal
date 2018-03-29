package pl.pawelb.utils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryJpaRepository<T extends Identifiable<Long>> implements BaseRepository<T, Long> {

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
        if (paramS.getId() == null) {
            paramS.setId(new Random().nextLong());
        }
        repo.put(paramS.getId(), paramS);
        return (S) repo.get(paramS.getId());
    }
}
