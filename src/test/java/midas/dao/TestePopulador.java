package midas.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.junit.Test;

import midas.entidades.ImagemProcessada;
import midas.entidades.Mammogram;
import midas.processamentoDeImagens.Processamento;
import midas.processamentoDeImagens.ProcessamentodeImagensMarvin;
import midas.util.ImageUtil;
import midas.util.JPAUtil;

public class TestePopulador {

	@Test
	public void test() {
		MammogramDAO mammogramDAO = new MammogramDAO();
		ImagemProcessadaDAO imagemProcessadaDAO = new ImagemProcessadaDAO();
		ProcessamentodeImagensMarvin processador = new ProcessamentodeImagensMarvin();
		
		List<Mammogram> mamogramas = new ArrayList<>();
		List<ImagemProcessada> imagens = new ArrayList<>();
		
		mamogramas = mammogramDAO.recuperaTudo();
		ImagemProcessada imagem;
		BufferedImage bin;
		BufferedImage bout;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for(Mammogram mammogram : mamogramas) {
			imagem = new ImagemProcessada();
			imagem.setMammogram(mammogram);
			bin = ImageUtil.converte(mammogram);
			bout = processador.processa(bin, Processamento.BORDASCOMUM);
			try {
				ImageIO.write(bout, "jpg", baos);
				baos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagem.setImagemProcessada(baos.toByteArray());
			imagem.setProcessamento(Processamento.BORDASCOMUM);
			JPAUtil.comecarOperacoes();
			imagemProcessadaDAO.inserir(imagem);

			bin = ImageUtil.converte(mammogram);
			bout = processador.processa(bin, Processamento.ROBERTS);
			try {
				ImageIO.write(bout, "jpg", baos);
				baos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagem.setImagemProcessada(baos.toByteArray());
			imagem.setProcessamento(Processamento.ROBERTS);
			imagemProcessadaDAO.inserir(imagem);
			
			bin = ImageUtil.converte(mammogram);
			bout = processador.processa(bin, Processamento.SOBEL);
			try {
				ImageIO.write(bout, "jpg", baos);
				baos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagem.setImagemProcessada(baos.toByteArray());
			imagem.setProcessamento(Processamento.SOBEL);
			imagemProcessadaDAO.inserir(imagem);
			
			bin = ImageUtil.converte(mammogram);
			bout = processador.processa(bin, Processamento.NEGATIVO);
			try {
				ImageIO.write(bout, "jpg", baos);
				baos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagem.setImagemProcessada(baos.toByteArray());
			imagem.setProcessamento(Processamento.NEGATIVO);
			imagemProcessadaDAO.inserir(imagem);
			
			bin = ImageUtil.converte(mammogram);
			bout = processador.processa(bin, Processamento.PREWITT);
			try {
				ImageIO.write(bout, "jpg", baos);
				baos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			imagem.setImagemProcessada(baos.toByteArray());
			imagem.setProcessamento(Processamento.PREWITT);
			imagemProcessadaDAO.inserir(imagem);
			JPAUtil.finalizarOperacoes();
		}
	}

}
