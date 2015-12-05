package midas.dao;

import java.util.Date;
import java.util.List;
import midas.entidades.Historico;
import midas.entidades.Patient;
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
}
