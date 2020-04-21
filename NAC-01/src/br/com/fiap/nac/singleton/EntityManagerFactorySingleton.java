package br.com.fiap.nac.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// Definir o atributo que armazena a única instancia
	private static EntityManagerFactory emf;

	// Construtor privado:
	// não é possivel fazer new EntityManagerFactorySingleton();
	private EntityManagerFactorySingleton() {
	}

	// Método que gerencia a única instancia
	public static EntityManagerFactory getInstance() {
		// Verifica se é necessário instanciar a fabrica
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("oracle");
		}
		return emf;
	}
}
