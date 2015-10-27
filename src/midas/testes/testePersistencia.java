package midas.testes;

import static org.junit.Assert.*;
import java.util.List;
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
	private UsuarioDAO bd;
	private List nao_autorizados;

	@Before 
	public void setUp(){
		user = new Usuario();
		user.setCpf("11111111111");
		user.setEmail("wow@gmail.com");
		user.setEndereco("Av. Joaquim Neto");
		user.setNivelDeAcesso(2);
		user.setSenha("victor123");
		user.setProfissao("engenheiro");
		user.setNome("Victor");
		user.setSexo('M');
		user.setDataNascimento("07.03.1997");
		
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
		bd.remover("12345678926");
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
		assertEquals(user2.getCpf(), user.getCpf());
		finalizarOperacoes();
	}
	@Test
	public void testListarNaoAutorizados(){
		comecarOperacoes();
		List<Usuario> nao_autorizados =  bd.listarNaoAutorizado();
		assertEquals(0, nao_autorizados.size());
		finalizarOperacoes();
	}
	
	@Test
	public void testLogin(){
		comecarOperacoes();
		boolean cadastrado = bd.login("03915432105", "alvinlelek");

		if (cadastrado == true)
			System.out.println("Usuario e senha são corretas");
		else{
			System.out.println("Usuario e senha não batem");
			fail("usuario e senhas diferentes");
		}
	}
	
	@Test
	public void testAutorizar(){
		comecarOperacoes();
		
		boolean acesso = bd.autorizar("03915432105");
		if (acesso == true)
			System.out.println("Nivel de acesso: 1");
		else
			System.out.println("Nivel de acessso: 0");
		
		
		finalizarOperacoes();
		
	}
	@Test
	public void testVeirificaUsuario(){
		comecarOperacoes();
		

		if(null != bd.recuperar("03915432105"))
			System.out.println("Usuario existe");
		else{
			System.out.println("Usuario não existe");
			fail("Usuario nao existe");
		}
		
		finalizarOperacoes();
	}
	
}
