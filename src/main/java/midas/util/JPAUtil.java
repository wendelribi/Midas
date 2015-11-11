package midas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPAUtil {
	public static EntityManagerFactory emf = null;
	public static EntityManager em = null;
	public static EntityTransaction tx = null;
	
	public static void comecarOperacoes() {
		emf = Persistence.createEntityManagerFactory("Midas");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
	}
	public static void finalizarOperacoes(){
		tx.commit();
		em.close();
		emf.close();
	}
}
