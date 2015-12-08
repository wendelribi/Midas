package Controle;

import java.sql.Date;

import midas.dao.HistoricoDAO;
import midas.entidades.Historico;
import midas.entidades.Mammogram;
import midas.spring.mvc.controller.LoginController;

public class HistoricoController {
	public Mammogram mammogram;
	
	public HistoricoController(Mammogram mammogram){
		this.mammogram = mammogram;
		insereHistorico();
	}
	
	public void insereHistorico(){
		Historico historico = new Historico();
		HistoricoDAO DAOHistorico = new HistoricoDAO();
		historico.setMammogram(mammogram);
		historico.setData_hora(new Date(System.currentTimeMillis()));
		historico.setUsuario(LoginController.usuario);
		DAOHistorico.inserir(historico);
	}
}
