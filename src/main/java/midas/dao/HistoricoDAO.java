package midas.dao;

import java.util.Date;
import java.util.List;
import midas.entidades.Historico;
import midas.entidades.Patient;
import midas.spring.mvc.controller.LoginController;
import midas.util.JPAUtil;

public class HistoricoDAO extends GenericDAO<Historico, Date> {
	@Override
	public Historico recuperar(Date data){
		try {
			return JPAUtil.em.find(Historico.class, data);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public List<Historico> recuperarTodos() {
		return JPAUtil.em.createQuery("select u from Historico u").getResultList();
	}
	
	public List<Historico> recuperaPorUsuario(){
	try{
		JPAUtil.comecarOperacoes();
		List<Historico> historico = JPAUtil.em.createQuery("select u from Historico u where u.usuario = tituloParam").setParameter("tituloParam", LoginController.usuario.getId()).getResultList();
		JPAUtil.finalizarOperacoes();
		return historico;
	}catch (Exception e) {
		return null;
	}
	}
}
