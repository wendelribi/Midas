package midas.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import midas.entidades.ImagemProcessada;
import midas.entidades.Usuario;
import midas.util.JPAUtil;

public class ImagemProcessadaDAO extends GenericDAO<ImagemProcessada, Long>  {
	public ImagemProcessada recuperar(Long id) {
		List<ImagemProcessada> imagemProc = JPAUtil.em.createQuery("SELECT u FROM ImagemProcessada u WHERE id = :tituloParam").setParameter("tituloParam", id).getResultList();
		return imagemProc.size() == 1 ? imagemProc.get(0): null;
	}
	public List<ImagemProcessada> recuperarTodos() {
		Query q = JPAUtil.em.createQuery("select u from ImagemProcessada u");
		@SuppressWarnings("unchecked")
		List<ImagemProcessada> lista = q.getResultList();
		return lista;
	}
	public List<ImagemProcessada> recuperarIdOriginal(Long mammogramId) {
		try {
			Query q = JPAUtil.em.createQuery("select u from ImagemProcessada u where u.mammogram.id = :nomeParam").setParameter("nomeParam", mammogramId);
			@SuppressWarnings("unchecked")
			List<ImagemProcessada> lista = q.getResultList();
			return lista;
		} catch (IllegalArgumentException | NoResultException e) {
			return null;
		}
	}
}
