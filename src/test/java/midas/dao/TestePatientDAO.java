package midas.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import midas.entidades.Patient;
import midas.util.JPAUtil;

public class TestePatientDAO extends TestCase {
	PatientDAO daoPatient;
	
	@Before
	public void setUp() {
		JPAUtil.comecarOperacoes();
		daoPatient = new PatientDAO();
	}
	
	@Test
	public void testeInserir() {
		Patient patient = new Patient();
		patient.setBirthday("15/04/95");
		patient.setPatientHistory("Historico de cancer de mama na familia.");
		assertTrue(daoPatient.inserir(patient));
	}
	
	@After
	public void finish() {
		JPAUtil.finalizarOperacoes();
	}
}
