package confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoEmail;

public class TesteValidacaoEmail {
	ValidacaoEmail emailValidacao = new ValidacaoEmail();
	
	@Test
	public void test() {
		// Email válidos
		assertTrue(emailValidacao.CampoEmail("abc@a.com"));
		assertTrue(emailValidacao.CampoEmail("123@aluno.unb.br"));
		assertTrue(emailValidacao.CampoEmail("54325@unb.br"));
		assertTrue(emailValidacao.CampoEmail("qwerty@gmail.com"));
				
		// Email inválidos
		assertFalse(emailValidacao.CampoEmail("@gmail.com"));
		assertFalse(emailValidacao.CampoEmail("qwe@.com"));
		assertFalse(emailValidacao.CampoEmail("qwe @gmail.com"));
		assertFalse(emailValidacao.CampoEmail("qwe@ gmail.com"));
		assertFalse(emailValidacao.CampoEmail("qwe@gmail .com"));
		assertFalse(emailValidacao.CampoEmail(""));
	}
}
