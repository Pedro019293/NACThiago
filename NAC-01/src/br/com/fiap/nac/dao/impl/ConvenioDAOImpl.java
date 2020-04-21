package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.ConvenioDAO;
import br.com.fiap.nac.entity.Convenio;

public class ConvenioDAOImpl extends GenericDAOImpl<Convenio, Integer> implements ConvenioDAO{

	public ConvenioDAOImpl(EntityManager em) {
		super(em);
	
	}

}
