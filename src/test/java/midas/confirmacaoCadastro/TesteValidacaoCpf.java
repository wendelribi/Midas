package confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoCpf;

public class TesteValidacaoCpf {
	ValidacaoCpf cpfValidacao = new ValidacaoCpf();
	
	@Test
	public void test() {
		// Cpf válidos
		assertTrue(cpfValidacao.CampoCpf("00000000000"));
		assertTrue(cpfValidacao.CampoCpf("12345678900"));
		assertTrue(cpfValidacao.CampoCpf("56745623543"));
		assertTrue(cpfValidacao.CampoCpf("98765968601"));
		assertTrue(cpfValidacao.CampoCpf("34556789986"));
		
		// Cpf inválidos
		assertFalse(cpfValidacao.CampoCpf(""));
		assertFalse(cpfValidacao.CampoCpf("3455678998A"));
		assertFalse(cpfValidacao.CampoCpf("xxxxxxxxxxx"));
		assertFalse(cpfValidacao.CampoCpf("           "));
		assertFalse(cpfValidacao.CampoCpf("123.456.789-00"));
	}

}
