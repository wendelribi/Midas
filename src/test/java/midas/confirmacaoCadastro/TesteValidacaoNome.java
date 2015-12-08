package confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoNome;

public class TesteValidacaoNome {
	ValidacaoNome nomeValidacao = new ValidacaoNome();
	
	@Test
	public void test() {
		// Nomes válidos
		assertTrue(nomeValidacao.CampoNome("Gustavo Carvalho"));
		assertTrue(nomeValidacao.CampoNome("Ismaelzão"));
						
		// Nomes inválidos
		assertFalse(nomeValidacao.CampoNome("qwert123etq"));
		assertFalse(nomeValidacao.CampoNome(""));
	}

}
