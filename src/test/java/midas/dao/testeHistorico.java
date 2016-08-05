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
import midas.util.JPAUtil;

public class testeHistorico {

	
	public void testInserirHistorico(){
	
		
		Mammogram mammogram = new Mammogram();
		MammogramDAO DAOMammogram = new MammogramDAO();
		
		mammogram = DAOMammogram.recuperar((long) 1);
	}

	@Test
	public void testRecuperaHistorico(){
		JPAUtil.comecarOperacoes();
		MammogramDAO DAOMammogram = new MammogramDAO();
		DAOMammogram.recuperaPorUsuario();
		JPAUtil.finalizarOperacoes();
	}
}






