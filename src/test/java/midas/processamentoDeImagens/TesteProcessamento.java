package midas.processamentoDeImagens;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class TesteProcessamento {

	@Test
	public void test() {
		MarvinImage imagem = MarvinImageIO.loadImage("C:/Users/Lucas Rezende/Dropbox/MIDAS/Exemplo.jpg");
		ProcessamentodeImagensMarvin processador = new ProcessamentodeImagensMarvin();
		processador.detectarBordas(imagem);
		assertTrue(true);
		processador.prewitt(imagem);
		assertTrue(true);
		processador.sobel(imagem);
		assertTrue(true);
		processador.roberts(imagem);
		assertTrue(true);
	}

}
