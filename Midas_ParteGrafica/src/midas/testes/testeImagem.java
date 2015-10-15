package midas.testes;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import javax.swing.*;

import org.junit.Before;
import org.junit.Test;

import midas.dao.MammogramDAO;
import midas.entidades.Mammogram;

public class testeImagem {

	Mammogram teste_IMG;
	MammogramDAO bd;
	@Before
	public void setUp() throws Exception {
		teste_IMG = new Mammogram();
		bd = new MammogramDAO();
	}

	@Test
	public void test() {
		bd.inserir();
	}
	
	@Test
	public void test_mostra_imagem() {
		BufferedImage im_buIm;
		byte[] im_byVe;
		Mammogram mamo;
		
		mamo = bd.recuperar(1);
		im_byVe = mamo.getImagem();
		im_buIm = mamo.converte(im_byVe);
		
		JFrame frame = new JFrame();
		JPanel painel = new JPanel();
		painel.add(new JLabel(new ImageIcon(im_buIm)));
		frame.add(new JScrollPane(painel));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,200);
		frame.setVisible(true);
	}
	
}
