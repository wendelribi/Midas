package midas.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.Query;

import midas.entidades.Patient;
import midas.entidades.Usuario;
import midas.util.JPAUtil;

public class PatientDAO {
	public boolean inserir(Patient paciente) {
		try{
			JPAUtil.em.persist(paciente);
			return true;
		} catch(EntityExistsException e) {
			return false;
		}
	}
	
	public boolean remover(int patientId) {
		try {
			JPAUtil.em.remove(recuperar(patientId));
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	public Patient recuperar(int patientId){
		try {
			return JPAUtil.em.find(Patient.class, patientId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public Patient update(int patientId){
		return JPAUtil.em.merge(recuperar(patientId));
		
	}
	
}
