package Controle;

import javax.swing.*;
import InterfaceGrafica.Botao_Usuario;

public class Controle {	
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
	
	public void enviarLogin(LoginUsuario usuario){
		//TODO conferir no banco de dados, caso exista, realiza o login e caso não exista mostra menssagem de erro
	}
}
