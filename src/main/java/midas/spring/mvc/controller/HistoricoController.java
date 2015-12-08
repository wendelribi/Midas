package midas.spring.mvc.controller;

import java.sql.Date;

import midas.entidades.Historico;
import midas.entidades.Mammogram;

public class HistoricoController {
	public Mammogram mammogram;
	
	public HistoricoController(Mammogram mammogram){
		this.mammogram = mammogram;
		insereHistorico();
	}
	
	public void insereHistorico(){
		Historico historico = new Historico();
		historico.setMammogram(mammogram);
		historico.setData_hora(new Date(System.currentTimeMillis()));
		historico.setUsuario(LoginController.usuario);
	}
}
