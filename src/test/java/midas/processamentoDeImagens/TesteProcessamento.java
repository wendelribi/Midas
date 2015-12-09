package midas.processamentoDeImagens;


import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class TesteProcessamento {

	@Test
	public void test() {
		BufferedImage imagem = null;
		BufferedImage res = null;
		try {
			imagem = ImageIO.read(new File("C:/Users/Lucas Rezende/Dropbox/MIDAS/Exemplo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessamentodeImagensMarvin processador = new ProcessamentodeImagensMarvin();
		res = null;
		res = processador.processa(imagem, Processamento.BORDASCOMUM);
		assertNotNull(res);
		res = null;
		res = processador.processa(imagem, Processamento.PREWITT);
		assertNotNull(res);
		res = null;
		res = processador.processa(imagem, Processamento.ROBERTS);
		assertNotNull(res);
		res = null;
		res = processador.processa(imagem, Processamento.SOBEL);
		assertNotNull(res);
		res = null;
		res = processador.processa(imagem, Processamento.NEGATIVO);
		assertNotNull(res);
	}

}
