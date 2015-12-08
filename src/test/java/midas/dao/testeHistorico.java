package midas.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import midas.dao.FavoritoDAO;
import midas.dao.MammogramDAO;
import midas.dao.UsuarioDAO;
import midas.entidades.Favorito;
import midas.entidades.Mammogram;
import midas.entidades.Usuario;

public class testeHistorico {

	@Test
	public void testInserirHistorico(){
	
		
		Mammogram mammogram = new Mammogram();
		MammogramDAO DAOMammogram = new MammogramDAO();
		
		mammogram = DAOMammogram.recuperar(1);

		
	}

}






