package confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoSenha;

public class TesteValidacaoSenha {
	ValidacaoSenha senhaValidacao = new ValidacaoSenha();
	
	@Test
	public void test() {
		// Profissões válidos
		assertTrue(senhaValidacao.CampoSenha("123456", "123456"));
		assertTrue(senhaValidacao.CampoSenha("asdfAjf432", "asdfAjf432"));
		assertTrue(senhaValidacao.CampoSenha("fdsaq23fda", "fdsaq23fda"));
		assertTrue(senhaValidacao.CampoSenha("!@#$%ˆ&*()", "!@#$%ˆ&*()"));
		assertTrue(senhaValidacao.CampoSenha("jdsa1fkg", "jdsa1fkg"));

		
		// Profissões inválidos
		assertFalse(senhaValidacao.CampoSenha("123456", "654321"));
		assertFalse(senhaValidacao.CampoSenha("123456", "122456"));
		assertFalse(senhaValidacao.CampoSenha("123456", "122456"));
		assertFalse(senhaValidacao.CampoSenha("123", "123"));
		assertFalse(senhaValidacao.CampoSenha("qwe", "qwe"));
	}
}
