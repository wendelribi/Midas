package Controle;

import java.sql.Date;

import midas.dao.FavoritoDAO;
import midas.entidades.Favorito;
import midas.entidades.Historico;
import midas.entidades.Mammogram;
import midas.spring.mvc.controller.LoginController;

public class FavoritoController {
	public Mammogram mammogram;
	public FavoritoDAO DAOFavorito;
	
	public FavoritoController(Mammogram mammogram){
		this.mammogram = mammogram;
		insereFavorito();
	}
	
	public void insereFavorito(){
		Favorito favorito = new Favorito();
		favorito.setMammogram(mammogram);
		favorito.setUsuario(LoginController.usuario);
		
		DAOFavorito = new FavoritoDAO();
		DAOFavorito.inserir(favorito);
		
	}
}

