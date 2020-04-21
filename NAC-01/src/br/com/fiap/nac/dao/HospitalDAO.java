package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.nac.entity.Hospital;

public interface HospitalDAO extends GenericDAO<Hospital, Integer>{

	void create(List<Hospital> listaHospital);

}
