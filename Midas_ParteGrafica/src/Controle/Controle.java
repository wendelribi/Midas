package Controle;

import javax.swing.*;
import InterfaceGrafica.Botao_Usuario;

public class Controle {

	private final int CADASTRO_INVALIDO=-1;
	private final int CADASTRO_PENDENTE=0;
	private final int JANELA_USUARIO=1;
	private final int JANELA_ADMIN = 2;
	
	public Controle() {
		
		Botao_Usuario buttonFrame = new Botao_Usuario(this);
	}
	
	/*
	 * Envia o cadastro para o banco de dados e retorna true - para cadastro enviado com sucesso
	 * 													false - para falha ao enviar o cadastro
	 */
	public boolean enviarCadastro(NovoUsuario novoUsuario){
		// TODO return inserir(novoUsuario);
		return true;
	}
	
	/*
	 * Confere o login com o banco de dados
	 */
	public int realizarLogin(LoginUsuario login){
		Usuario usuario = recuperar(login.getLogin());
		if(usuario == null){
			return CADASTRO_INVALIDO;
		} else if(usuario.getNivelDeAcesso() == 0) {
			return CADASTRO_PENDENTE;
		} else if(usuario.getNivelDeAcesso() == 1) {
			return JANELA_USUARIO;
		} else if(usuario.getNivelDeAcesso() == 2) {
			return JANELA_ADMIN;
		}
	}
}
