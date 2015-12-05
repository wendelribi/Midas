package midas.dao;

import java.util.List;
import javax.persistence.*;
import midas.entidades.Patient;
import midas.util.JPAUtil;

public class PatientDAO extends GenericDAO<Patient, Long> {
	
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
		return JPAUtil.em.createQuery("select u from Patient u").getResultList();
	}
	
}