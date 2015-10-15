package midas.testes;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import midas.dao.UsuarioDAO;
import midas.entidades.Usuario;

@RunWith(JUnit4.class)
public class testePersistencia {

	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	private UsuarioDAO bd;

	@Before 
	public void setUp(){
		user = new Usuario();
		user.setCpf("11111111111");
		user.setEmail("pepeca_colorida@gmail.com");
		user.setEndereco("De baixo da ponte");
		user.setNivelDeAcesso(0);
		user.setSenha("alvinlelek");
		user.setProfissao("engenheiro");
		user.setNome("Ismael");
		user.setSexo('M');
		user.setDataNascimento("");
		
		bd = new UsuarioDAO();
	}
	
	public void comecarOperacoes(){
		UsuarioDAO.comecarOperacoes();
	}
	public void finalizarOperacoes(){
		UsuarioDAO.finalizarOperacoes();
	}

	
	
	@Test
	public void testRemover(){
		comecarOperacoes();
		bd.remover("11111111110");
		finalizarOperacoes();
	}
	
	@Test
	public void testInsere() {

		comecarOperacoes();
		bd.inserir(user);
		finalizarOperacoes();
	}
	@Test
	public void testRecupera(){
		comecarOperacoes();
		user2 = bd.recuperar(user.getCpf());
		//System.out.println("CPF DO USER: "+ user2.getCpf());
		finalizarOperacoes();
	}
	//@Test
	//public void testListarNaoAutorizados(){
	//	comecarOperacoes();
	//	List nao_autorizados = bd.listarNaoAutorizado();
	//	finalizarOperacoes();
	//}
	@Test
	public void testLogin(){
		
	}
	
	@Test
	public void testAutorizar(){
		comecarOperacoes();
		
		boolean acesso = bd.autorizar("11111111110");
		if (acesso == true)
			System.out.println("Nivel de acesso: 1");
		else
			System.out.println("Nivel de acessso: 0");
		
		
		finalizarOperacoes();
		
	}
}
