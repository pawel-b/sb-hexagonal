package pl.pawelb.utils;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T, ID extends Serializable> {

    List<T> findAll();

    T findOne(ID paramID);

    <S extends T> S save(S paramS);

}
