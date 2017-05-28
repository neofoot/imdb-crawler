package com.fsoft.z8.ip.dao;

import java.util.List;

public interface ImdbGenericDAO<T> {
    public void saveOrUpdate(T object);

    public List<T> getAll();

    public void delete(T object);
}
