package midas.confirmacaoCadastro;

import static org.junit.Assert.*;

import org.junit.Test;

import Controle.ConfirmacaoCadastro.ValidacaoData;

public class TesteValidacaoData {
	ValidacaoData dataValidacao = new ValidacaoData();
	
	@Test
	public void test() {
		// Datas válidos
		assertTrue(dataValidacao.CampoData("31/01/2015"));
		assertTrue(dataValidacao.CampoData("28/02/2015"));
		assertTrue(dataValidacao.CampoData("31/03/2015"));
		assertTrue(dataValidacao.CampoData("30/04/2015"));
		assertTrue(dataValidacao.CampoData("31/05/2015"));
		assertTrue(dataValidacao.CampoData("30/06/2015"));
		assertTrue(dataValidacao.CampoData("31/07/2015"));
		assertTrue(dataValidacao.CampoData("31/08/2015"));
		assertTrue(dataValidacao.CampoData("30/09/2015"));
		assertTrue(dataValidacao.CampoData("31/10/2015"));
		assertTrue(dataValidacao.CampoData("30/11/2015"));
		assertTrue(dataValidacao.CampoData("31/12/2015"));

				
		// Datas inválidos
		assertFalse(dataValidacao.CampoData("//"));
		assertFalse(dataValidacao.CampoData("12/122/015"));
		assertFalse(dataValidacao.CampoData("xx/xx/xxxx"));
		assertFalse(dataValidacao.CampoData("10102010"));
		assertFalse(dataValidacao.CampoData("10 10 2015"));
		assertFalse(dataValidacao.CampoData("10\10\2015"));
		assertFalse(dataValidacao.CampoData(""));
	}

}
