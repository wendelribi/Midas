package midas.dao;

import java.util.List;
import javax.persistence.*;
import midas.entidades.Usuario;
import midas.util.JPAUtil;

public class UsuarioDAO {
	public boolean inserir(Usuario usuario) {
		try{
			JPAUtil.em.persist(usuario);
			return true;
		} catch(EntityExistsException e) {
			return false;
		}
	}
	
	public boolean remover(String cpf_usuario) {
		try {
			JPAUtil.em.remove(recuperar(cpf_usuario));
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public List<Usuario> listarNaoAutorizado() {
		Query q = JPAUtil.em.createQuery("select u from Usuario u where u.nivelDeAcesso = 0");
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
			return JPAUtil.em.find(Usuario.class, cpf_usuario);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	public boolean login(String cpf_usuario, String senha){
		try {
			Query q = JPAUtil.em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class );
			q.setParameter("cpf_usuario",cpf_usuario);
			Usuario usuario = (Usuario) q.getSingleResult();

			return usuario.getSenha().equals(senha) ? true : false;
			
		} catch(IllegalArgumentException e){
			return false;
		}
	}
	public boolean verificaExisteUsuario(String cpf_usuario){
		Query q = JPAUtil.em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class );
		q.setParameter("cpf_usuario",cpf_usuario);
		String cpf_encontrado = (String) q.getSingleResult();
		
		return (cpf_encontrado != null) ? true : false;

	}
}
