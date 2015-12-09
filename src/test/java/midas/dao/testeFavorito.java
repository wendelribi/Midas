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

public class testeFavorito {

	@Test
	public void testFavorito(){
		JPAUtil.comecarOperacoes();
		Favorito favorito = new Favorito();
		FavoritoDAO DAOFavorito = new FavoritoDAO();
		UsuarioDAO DAOUsuario = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Mammogram mammogram = new Mammogram();
		MammogramDAO DAOMammogram = new MammogramDAO();
		
		//mammogram = DAOMammogram.recuperar();
		usuario = DAOUsuario.recuperar("12345678901");
		
		
		favorito.setUsuario(usuario);
		favorito.setMammogram(mammogram);
		
		DAOFavorito.inserir(favorito);
		
	}

}






