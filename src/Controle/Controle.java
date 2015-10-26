package Controle;

import java.util.ArrayList;
import midas.dao.*;
import javax.swing.*;
import InterfaceGrafica.Botao_Usuario;
import midas.entidades.Usuario;

public class Controle {

	private final int CADASTRO_INVALIDO=-1;
	private final int CADASTRO_PENDENTE=0;
	private final int JANELA_USUARIO=1;
	private final int JANELA_ADMIN = 2;
	private UsuarioDAO bancoDeDadosUsuario;
	
	public Controle() {
		bancoDeDadosUsuario = new UsuarioDAO();
		//UsuarioDAO.comecarOperacoes();
		Botao_Usuario buttonFrame = new Botao_Usuario(this);
	}
	
	
	
	/*
	 * Envia o cadastro para o banco de dados e retorna true - para cadastro enviado com sucesso
	 * 													false - para falha ao enviar o cadastro
	 */
	public boolean enviarCadastro(Usuario novoUsuario){
		UsuarioDAO.comecarOperacoes();
		boolean sucesso = bancoDeDadosUsuario.inserir(novoUsuario);
		UsuarioDAO.finalizarOperacoes();
		return sucesso;
	}
	
	
	
	/*
	 * Confere o login com o banco de dados
	 */
	public int realizarLogin(LoginUsuario login){
		UsuarioDAO.comecarOperacoes();
		Usuario usuario = bancoDeDadosUsuario.recuperar(login.getLogin());
		UsuarioDAO.finalizarOperacoes();
		if(usuario == null){
			return CADASTRO_INVALIDO;
		} else if(usuario.getNivelDeAcesso() == 0) {
			return CADASTRO_PENDENTE;
		} else if(usuario.getNivelDeAcesso() == 1 && (usuario.getSenha().equals(login.getSenha()))) {
			return JANELA_USUARIO;
		} else if(usuario.getNivelDeAcesso() == 2 && (usuario.getSenha().equals(login.getSenha()))) {
			return JANELA_ADMIN;
		}
	
		return CADASTRO_INVALIDO;
	}
	
	
	
	/*
	 * Retorna uma lista com os usuários pendentes no banco de dados
	 */
	public ArrayList<Usuario> getUsuariosPendentes(){
		UsuarioDAO.comecarOperacoes();
		ArrayList<Usuario> retorno =  new ArrayList<Usuario>(bancoDeDadosUsuario.listarNaoAutorizado());
		UsuarioDAO.finalizarOperacoes();
		return retorno;
	}
	
	
	
	/*
	 *  Atualiza o nível de acesso dos usuários autorizados e retira os usuarios negados do banco de dados
	 */
	public void atualizarAutorizacoes(ArrayList<Usuario> autorizados, ArrayList<Usuario> negados){
		UsuarioDAO.comecarOperacoes();
		for(Usuario usuario : autorizados){
			bancoDeDadosUsuario.autorizar(usuario.getCpf());
		}
		
		for(Usuario usuario : negados){
			bancoDeDadosUsuario.remover(usuario.getCpf());
		}
		UsuarioDAO.finalizarOperacoes();
	}
	
}
