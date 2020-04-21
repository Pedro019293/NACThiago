package br.com.fiap.nac.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.nac.entity.Convenio;
import br.com.fiap.nac.entity.Doador;
import br.com.fiap.nac.entity.Genero;
import br.com.fiap.nac.entity.Hospital;
import br.com.fiap.nac.entity.Orgao;
import br.com.fiap.nac.entity.Paciente;

public class View {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		
		
		
		// Instanciar um hospital
		
		List<Hospital> listaHospital = new ArrayList<Hospital>();
		listaHospital.add(new Hospital("Sírio Líbanes", "São Paulo", Calendar.getInstance(), Calendar.getInstance()));
		listaHospital.add(new Hospital("Albert Ainstein", "São Paulo", Calendar.getInstance(), Calendar.getInstance()));

		// Instanciar um doador
		Doador doador = new Doador("Marcelo Shybuia", "Pulmão", "São Paulo", Calendar.getInstance());
		// Instanciar um orgao
		Orgao orgao = new Orgao("Coração", doador);
		// Instanciar um paciente
		Paciente paciente = new Paciente("Gustavo Neri Santos", "Pulmão", Calendar.getInstance(), Genero.MASCULINO,
				"São Paulo", "Amil", null, orgao);
		//Instanciar um convenio
		Convenio convenio = new Convenio("Amil", "97585-8549", "Gold", paciente, listaHospital );

		// Cadastrar paciente
		em.persist(paciente);
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();	

		em.close();
		fabrica.close();

	}

}
