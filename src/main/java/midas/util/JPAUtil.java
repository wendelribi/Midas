package midas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.postgresql.util.PSQLException;

public class JPAUtil {
	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;

	public static void comecarOperacoes() {
		emf = Persistence.createEntityManagerFactory("Midas");
		em = emf.createEntityManager();
		
	}

	public static void finalizarOperacoes() {
		em.close();
		emf.close();
	}
}
