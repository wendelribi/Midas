package midas.spring.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Controle.LoginUsuario;
import midas.dao.UsuarioDAO;
import midas.entidades.*;
import midas.util.JPAUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	private ArrayList<Usuario> arrayUsuario;
	
	@RequestMapping("/controller")
	public ModelAndView login() {

		return new ModelAndView("/login/view");
	}

	@RequestMapping("/controle")
	public ModelAndView fazerLogin(HttpServletRequest request){

		LoginUsuario login = new LoginUsuario();
		login.setLogin(request.getParameter("nome"));
		login.setSenha(request.getParameter("senha"));
		System.out.println(login.getLogin() + " " + login.getSenha());
		
		UsuarioDAO bancoDeDadosUsuario = new UsuarioDAO();
		JPAUtil.comecarOperacoes();
		Usuario usuario = bancoDeDadosUsuario.recuperar(login.getLogin());
		JPAUtil.finalizarOperacoes(); 
		
		if (usuario == null) {
			System.out.println("Nao existe!");
		} 
		else if (usuario.getNivelDeAcesso() == 0) {
			System.out.println("Nao tem acesso");
		} 
		else if (usuario.getNivelDeAcesso() == 1 && (usuario.getSenha().equals(login.getSenha()))) {
			System.out.println("login");
			return new ModelAndView("/login/loginUsuario/viewUsuario");
		} 
		else if (usuario.getNivelDeAcesso() == 2 && (usuario.getSenha().equals(login.getSenha()))) {
			System.out.println("admin");
			// Obtem a lista de Usuarios Pendentes		
//			arrayUsuario  = controle.getUsuariosPendentes();
		
			arrayUsuario.add(usuario);
			return new ModelAndView("/login/loginAdmin/viewAdmin","arrayUsuario",arrayUsuario);
		}
		return new ModelAndView("/login/loginAdmin/viewAdmin","arrayUsuario",arrayUsuario);
	}
	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView delete(@RequestParam("arrayUsuario") Usuario arrayUsuario) {
////		Retirar o usuario
//		return this.list(arrayUsuario);
//		
}
	
