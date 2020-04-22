package br.com.fiap.nac.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.nac.dao.HospitalDAO;
import br.com.fiap.nac.dao.PacienteDAO;
import br.com.fiap.nac.dao.impl.HospitalDAOImpl;
import br.com.fiap.nac.dao.impl.PacienteDAOImpl;
import br.com.fiap.nac.entity.Convenio;
import br.com.fiap.nac.entity.Doador;
import br.com.fiap.nac.entity.Genero;
import br.com.fiap.nac.entity.Hospital;
import br.com.fiap.nac.entity.Orgao;
import br.com.fiap.nac.entity.Paciente;
import br.com.fiap.nac.exception.FailedCommitException;

public class View {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um PacienteDAOImpl
		PacienteDAO dao = new PacienteDAOImpl(em);
		
		// Instanciar um doador
		Doador doador = new Doador("Marcelo Shibuya", "Pulm�o", "S�o Paulo", Calendar.getInstance());		
		
		// Instanciar um orgao
		Orgao orgao = new Orgao("Cora��o", doador);
		
		// Instanciar um paciente
		Paciente paciente = new Paciente("Gustavo Neri","Pulm�o",Calendar.getInstance(),Genero.MASCULINO,"S�o Paulo",null);

		//Instanciar 1 conv�nio e adicionar no paciente
		paciente.addConvenio(new Convenio(1111,"Amil","M�e do Gustavo","Criar um Enum"));
		
		// Instanciar um hospital
		List<Hospital> listaHospital = new ArrayList<Hospital>();
		listaHospital.add(new Hospital("S�rio L�banes", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));
		listaHospital.add(new Hospital("Albert Ainstein", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));

		//Setar a lista de convenio no post
		paciente.getListaConvenio().get(0).setListaHospital(listaHospital);	
		
		// Cadastrar paciente
		dao.create(paciente);
		
		try {
			dao.commit();
			System.out.println("Sucesso");
		}catch(FailedCommitException e) {
			System.out.println("Erro");
		}
		
		em.close();
		fabrica.close();

	}

}
