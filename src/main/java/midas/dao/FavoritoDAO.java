
package midas.dao;

import java.util.Date;
import java.util.List;
import midas.entidades.Favorito;
import midas.processamentoDeImagens.Processamento;
import midas.spring.mvc.controller.LoginController;
import midas.util.JPAUtil;

public class FavoritoDAO extends GenericDAO<Favorito, Integer> {
	@Override
	public Favorito recuperar(Integer favoritoId) {
		try {
			return JPAUtil.em.find(Favorito.class, favoritoId);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public List<Favorito> recuperarTodos() {
		return JPAUtil.em.createQuery("select u from Favorito u").getResultList();
	}

	public List<Favorito> recuperaPorProcessamento(Processamento processamento) {
		return JPAUtil.em
				.createQuery(
						"select u from Mammogram u, Study y where u.studyId = y.studyId AND y.findings LIKE tituloParam1")
				.setParameter("tituloParam", processamento).getResultList();
	}

	public List<Favorito> recuperaFavoritosProcessados() {
		try {
			JPAUtil.comecarOperacoes();
			List<Favorito> favorito = JPAUtil.em
					.createQuery(
							"select u from Favorito u where u.usuario =:tituloParam AND u.processamento is not null ")
					.setParameter("tituloParam", LoginController.usuario).getResultList();
			JPAUtil.finalizarOperacoes();
			return favorito;
		} catch (Exception e) {
			System.out.println("Deu ruim");
			return null;
		}
	}

	public List<Favorito> recuperaPorUsuario() {
		try {
			JPAUtil.comecarOperacoes();
			List<Favorito> favorito = JPAUtil.em.createQuery("select u from Favorito u where u.usuario =:tituloParam")
					.setParameter("tituloParam", LoginController.usuario).getResultList();
			JPAUtil.finalizarOperacoes();
			return favorito;
		} catch (Exception e) {
			System.out.println("deu ruim");
			return null;
		}
	}

}
