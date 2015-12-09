package midas.dao;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.junit.Before;
import org.junit.Test;

import midas.dao.MammogramDAO;
import midas.entidades.Mammogram;
import midas.util.ImageUtil;

public class testeImagem {

	Mammogram teste_IMG;
	MammogramDAO bd;
	@Before
	public void setUp() throws Exception {
		teste_IMG = new Mammogram();
		bd = new MammogramDAO();
	}

//	@Test
//	public void test() {
//		bd.inserir();
//	}	
	
	@Test
	public void recuperar(){
		teste_IMG = bd.recuperar((long) 15);
		BufferedImage imgB = ImageUtil.converte(teste_IMG);
	}
}
