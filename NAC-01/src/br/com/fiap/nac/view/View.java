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
		
		PacienteDAO dao = new PacienteDAOImpl(em);
		HospitalDAO daoh = new HospitalDAOImpl(em);
		
//		// Instanciar um hospital
//		List<Hospital> listaHospital = new ArrayList<Hospital>();
//		listaHospital.add(new Hospital("S�rio L�banes", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));
//		listaHospital.add(new Hospital("Albert Ainstein", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));
		
		//Instanciar Hospital
		Hospital hospital = new Hospital("S�rio L�banes", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance());
		
		// Instanciar um doador
		Doador doador = new Doador("Marcelo Shybuia", "Pulm�o", "S�o Paulo", Calendar.getInstance());
		// Instanciar um orgao
		Orgao orgao = new Orgao("Cora��o", doador);
		// Instanciar um paciente
		Paciente paciente = new Paciente("Pedro", "Pulm�o", Calendar.getInstance(), Genero.MASCULINO,
				"S�o Paulo", "Amil", null, orgao);
		
		//Instanciar um convenio
//		Convenio convenio = new Convenio("Amil", "97585-8549", "Gold", paciente, listaHospital );
		
		
		
		dao.create(paciente);
//		daoh.create(listaHospital);
		
		try {
            dao.commit();
            
            System.out.println("Sucesso!");
            
        }catch(FailedCommitException e) {
            System.out.println("Erro!");
        }
		
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();	

		em.close();
		fabrica.close();

	}

}
