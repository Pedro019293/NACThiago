package br.com.fiap.nac.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.GenericDAO;
import br.com.fiap.nac.exception.FailedCommitException;
import br.com.fiap.nac.exception.KeyNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	//Atributo para armazenar o .class da entidade utilizada
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		//Recuperar o class de T que foi utilizado
		clazz = (Class<T>) ((ParameterizedType) 
			getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public T read(K key) throws KeyNotFoundException {
		T entity = em.find(clazz, key);
		if (entity == null) {
			throw new KeyNotFoundException();
		}
		return entity;
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	
	@Override
	public void delete(K key) throws KeyNotFoundException {
		T entity = read(key);
		em.remove(entity);
	}

	@Override
	public void commit() throws FailedCommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new FailedCommitException();
		}
	}

}
