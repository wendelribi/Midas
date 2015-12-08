package midas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.postgresql.util.PSQLException;

import midas.entidades.Usuario;
import midas.util.JPAUtil;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, String>{
	public static EntityTransaction tx = null;
	
	@Transactional
	public boolean inserir(Usuario usuario, HttpServletRequest request) {
		try {
			tx = JPAUtil.em.getTransaction();
			tx.begin();
			request.setAttribute("cpfExiste","false");
			JPAUtil.em.persist(usuario);
			tx.commit();
			return true;
		} catch (RollbackException e) {
			request.setAttribute("cpfExiste","true");
			return false;
		}
	}

	@Transactional
	public boolean remover(String cpf_usuario) {
		return this.remover(recuperar(cpf_usuario));
	}

	public List<Usuario> listarNaoAutorizado() {
		Query q = JPAUtil.em.createQuery("select u from Usuario u where u.nivelDeAcesso = 0");
		@SuppressWarnings("unchecked")
		List<Usuario> lista = q.getResultList();
		return lista;
	}

	@Transactional
	public boolean autorizar(String cpf_usuario) {
		tx = JPAUtil.em.getTransaction();
		tx.begin();
		Usuario usuario = recuperar(cpf_usuario);
		if (usuario != null) {
			usuario.setNivelDeAcesso(1);
			tx.commit();
			return true;
		} else {
			tx.rollback();
			return false;
		}
	}

	@Override
	@Transactional
	public Usuario recuperar(String cpf_usuario) {
		try {
			Query q = JPAUtil.em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class);
			q.setParameter("cpf_usuario", cpf_usuario);
			return (Usuario) q.getSingleResult();
		} catch (IllegalArgumentException | NoResultException e) {
			return null;
		}
	}

	public boolean login(String cpf_usuario, String senha) {
		try {
			Query q = JPAUtil.em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class);
			q.setParameter("cpf_usuario", cpf_usuario);
			Usuario usuario = (Usuario) q.getSingleResult();

			return usuario.getSenha().equals(senha) ? true : false;

		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public boolean verificaExisteUsuario(String cpf_usuario) {
		Query q = JPAUtil.em.createQuery("select u from Usuario u where u.cpf = :cpf_usuario", Usuario.class);
		q.setParameter("cpf_usuario", cpf_usuario);
		String cpf_encontrado = (String) q.getSingleResult();

		return (cpf_encontrado != null) ? true : false;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperarTodos() {
		return JPAUtil.em.createQuery("select u from Usuario u").getResultList();
	}
	
	
}
