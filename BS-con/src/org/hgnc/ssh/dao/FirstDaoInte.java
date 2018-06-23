package org.hgnc.ssh.dao;

import java.util.List;

public interface FirstDaoInte <T>{
	public void add(T t);
	public void delete(String id);
	public void update(T t);
	public T getById(String id);
	public List<T> getAll();
}
