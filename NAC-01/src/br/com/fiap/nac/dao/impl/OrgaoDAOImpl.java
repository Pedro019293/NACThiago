package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.OrgaoDAO;
import br.com.fiap.nac.entity.Orgao;

public class OrgaoDAOImpl extends GenericDAOImpl<Orgao, Integer> implements OrgaoDAO{

	public OrgaoDAOImpl(EntityManager em) {
		super(em);
	}

}
