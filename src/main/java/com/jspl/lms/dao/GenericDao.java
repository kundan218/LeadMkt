package com.jspl.lms.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable,K extends Serializable> {
	public T findById(K id);
    public List<T> findAll();
    public T saveOrUpdate(T object);
    public void delete(T object);
}
