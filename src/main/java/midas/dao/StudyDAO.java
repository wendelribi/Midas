package midas.dao;

import java.util.List;

import midas.dao.GenericDAO;
import midas.entidades.Patient;
import midas.entidades.Study;
import midas.util.JPAUtil;

public class StudyDAO extends GenericDAO<Study, Long> {
	
	@Override
	public Study recuperar(Long studyId) {
		try {
			return JPAUtil.em.find(Study.class, studyId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public List<Study> recuperarTodos() {
		return JPAUtil.em.createQuery("select u from Study u").getResultList();
	}
}
