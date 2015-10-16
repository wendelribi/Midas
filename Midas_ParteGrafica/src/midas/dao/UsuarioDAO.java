package midas.dao;

import java.util.List;

import javax.persistence.*;

import midas.entidades.Usuario;

public class UsuarioDAO {
	private static EntityManagerFactory emf;
	static EntityManager em;
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
		try {
			em.remove(recuperar(cpf_usuario));
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public List<Usuario> listarNaoAutorizado() {
		Query q = em.createQuery("select u from Usuario u where u.nivelDeAcesso = 0");
		@SuppressWarnings("unchecked")
		List<Usuario> lista = q.getResultList();
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
	public boolean login(String cpf_usuario, String senha){
		try {
			Query q = em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class );
			q.setParameter("cpf_usuario",cpf_usuario);
			Usuario usuario = (Usuario) q.getSingleResult();

			return usuario.getSenha().equals(senha) ? true : false;
			
		} catch(IllegalArgumentException e){
			return false;
		}
	}
	public boolean verificaExisteUsuario(String cpf_usuario){
		Query q = em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class );
		q.setParameter("cpf_usuario",cpf_usuario);
		String cpf_encontrado = (String) q.getSingleResult();
		
		return (cpf_encontrado != null) ? true : false;

	}
}
