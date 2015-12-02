package midas.dao;

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
}
