package midas.dao;

import java.awt.List;
import java.util.ArrayList;
import javax.persistence.*;
import midas.entidades.Usuario;

public class UsuarioDAO {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
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
	
	public boolean inserir(Usuario usuario) {
		try{
			em.persist(usuario);
			return true;
		} catch(EntityExistsException e) {
			return false;
		}
	}
	
	public boolean remover(String cpf_usuario) {
		return false;
	}
	
	public List listarNaoAutorizado() {
		Query q = em.createQuery("select u.CPF from Usuario u where u.nivelDeAcesso = 0", Usuario.class);
		List lista = (List) q.getResultList();
		return lista;
	}
	
	public boolean autorizar(String cpf_usuario) {
		Usuario usuario = recuperar(cpf_usuario);
		if(usuario != null) {
			usuario.setNivelDeAcesso(1);
			return true;
		} else {
			return false;
		}
	}
	public Usuario recuperar(String cpf_usuario){
		try {
			return em.find(Usuario.class, cpf_usuario);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
}
