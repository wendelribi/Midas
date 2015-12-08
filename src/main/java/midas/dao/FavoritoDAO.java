
package midas.dao;

import java.util.Date;
import java.util.List;

import midas.entidades.Favorito;
import midas.util.JPAUtil;

public class FavoritoDAO extends GenericDAO<Favorito, Integer> {
	@Override
	public Favorito recuperar(Integer favoritoId){
		try {
			return JPAUtil.em.find(Favorito.class, favoritoId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public List<Favorito> recuperarTodos() {
		return JPAUtil.em.createQuery("select u from Favorito u").getResultList();
	}



}
