package midas.confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoProfissao;

public class TesteValidacaoProfissao {
	ValidacaoProfissao profissaoValidacao = new ValidacaoProfissao();
	
	@Test
	public void test() {
		// Profissões válidos
		assertTrue(profissaoValidacao.CampoProfissao("Médico"));
		assertTrue(profissaoValidacao.CampoProfissao("Estudante"));
		assertTrue(profissaoValidacao.CampoProfissao("Professor"));

		
		// Profissões inválidos
		assertFalse(profissaoValidacao.CampoProfissao("Mé4dico"));
		assertFalse(profissaoValidacao.CampoProfissao("46"));
	}

}
