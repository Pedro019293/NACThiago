package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.DoadorDAO;
import br.com.fiap.nac.entity.Doador;

public class DoadorDAOImpl extends GenericDAOImpl<Doador, Integer> implements DoadorDAO{

	public DoadorDAOImpl(EntityManager em) {
		super(em);
	}

}
