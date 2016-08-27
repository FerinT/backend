package com.ferin.services;

import java.util.Set;

/**
 * Created by student on 2016/08/21.
 */
public interface Service <E,ID>{
    E create(E entity);
    E readById(ID id);
    Set<E> readAll();
    E update(E entity);
    void delete(E entity);
}
