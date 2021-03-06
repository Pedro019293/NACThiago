package br.com.fiap.nac.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.nac.dao.PacienteDAO;
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
		
		// Instanciar um hospital
		List<Hospital> listaHospital = new ArrayList<Hospital>();
		listaHospital.add(new Hospital("S�rio L�banes", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));
		listaHospital.add(new Hospital("Albert Ainstein", "S�o Paulo", Calendar.getInstance(), Calendar.getInstance()));
		
		// Instanciar um doador
		Doador doador = new Doador("Marcelo", "Pulm�o", "S�o Paulo", Calendar.getInstance());
		
		//Instanciar um convenio
		Convenio convenio = new Convenio("Amil","888888888","Gold",listaHospital);
		
		//Instanciar um paciente
		Paciente paciente = new Paciente("Marcelo",Calendar.getInstance(),Genero.MASCULINO,"S�o Paulo",null, convenio);
		paciente.addOrgao(new Orgao("Thiago Toshiyuki",doador));
		
		//Criar um paciente
		dao.create(paciente);

		try {
            dao.commit();    
            System.out.println("Sucesso!");
        }catch(FailedCommitException e) {
            System.out.println("Erro!");
        }

		em.close();
		fabrica.close();

	}

}
