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
	
	/*
	 * Confere o login com o banco de dados
	 */
	public void realizarLogin(LoginUsuario login){
		Usuario usuario = recuperar(login.getLogin());
		if(usuario == null){
			JOptionPane.showMessageDialog(null, "Cadastro não encontrado");
		} else if(usuario.getNivelDeAcesso() == 0) {
			JOptionPane.showMessageDialog(null, "Cadastro ainda não autorizado");
		} else if(usuario.getNivelDeAcesso() == 1) {
			//TODO janela de usuário normal
		} else if(usuario.getNivelDeAcesso() == 2) {
			// TODO janela de administrador
		}
	}
}
