package midas.dao;

import java.util.List;
import javax.persistence.*;
import midas.entidades.Patient;
import midas.util.JPAUtil;

public class PatientDAO implements GenericDAO<Patient, Long> {
	@Override
	public boolean inserir(Patient paciente) {
		try{
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.persist(paciente);
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(RollbackException e) {
			return false;
		}
	}
	
	@Override
	public boolean remover(Long patientId) {
		try {
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.remove(recuperar(patientId));
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(RollbackException e) {
			return false;
		}
	}
	
	@Override
	public Patient recuperar(Long patientId){
		try {
			return JPAUtil.em.find(Patient.class, patientId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	@Override
	public List<Patient> recuperarTodos() {
		Query q = JPAUtil.em.createQuery("select u from Usuario u");
		@SuppressWarnings("unchecked")
		List<Patient> lista = q.getResultList();
		return lista;
	}
	
	@Override
	public boolean atualizar(Long patientId){
		try {
			JPAUtil.em.getTransaction().begin();
			JPAUtil.em.merge(recuperar(patientId));
			JPAUtil.em.getTransaction().commit();
			return true;
		} catch(RollbackException e) {
			return false;
		}
	}
	
}
