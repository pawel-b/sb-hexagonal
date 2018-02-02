package pl.pawelb.utils;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T, ID extends Serializable> {

    List<T> findAll();

    abstract T findOne(ID paramID);

    abstract <S extends T> S save(S paramS);

}
