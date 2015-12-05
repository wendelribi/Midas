package midas.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import midas.util.JPAUtil;

public abstract class GenericDAO<T, V> {
	
	public boolean inserir(T entidade) {
		try {	
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.persist(entidade);
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(RollbackException | EntityExistsException e) {
			return false;
		}
	}
	
	public boolean remover(T entidade) {
		try {
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.remove(entidade);
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public boolean atualizar(T entidade) {
		try {
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.merge(entidade);
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public abstract T recuperar(V atributo);
	
	public abstract List<T> recuperarTodos();
	
}
