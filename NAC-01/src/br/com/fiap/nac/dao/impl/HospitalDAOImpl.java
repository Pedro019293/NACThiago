package br.com.fiap.nac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.HospitalDAO;
import br.com.fiap.nac.entity.Hospital;

public class HospitalDAOImpl extends GenericDAOImpl<Hospital, Integer> implements HospitalDAO{

	public HospitalDAOImpl(EntityManager em) {
		super(em);

	}

	@Override
	public void create(List<Hospital> listaHospital) {
		// TODO Auto-generated method stub
		
	}

}
