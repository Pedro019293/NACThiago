package br.com.fiap.nac.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// Definir o atributo que armazena a �nica instancia
	private static EntityManagerFactory emf;

	// Construtor privado:
	// n�o � possivel fazer new EntityManagerFactorySingleton();
	private EntityManagerFactorySingleton() {
	}

	// M�todo que gerencia a �nica instancia
	public static EntityManagerFactory getInstance() {
		// Verifica se � necess�rio instanciar a fabrica
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("oracle");
		}
		return emf;
	}
}
