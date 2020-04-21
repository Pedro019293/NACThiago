package br.com.fiap.nac.dao;

import br.com.fiap.nac.exception.FailedCommitException;
import br.com.fiap.nac.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void create(T entity);
	
	T read(K key) throws KeyNotFoundException;
	
	void update(T entity);
	
	void delete(K key) throws KeyNotFoundException;
	
	void commit() throws FailedCommitException;
	
}