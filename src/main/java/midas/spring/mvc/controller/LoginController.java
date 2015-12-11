package midas.spring.mvc.controller;

import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Controle.*;
import midas.dao.FavoritoDAO;
import midas.dao.HistoricoDAO;
import midas.dao.MammogramDAO;
import midas.dao.UsuarioDAO;
import midas.entidades.*;
import midas.util.JPAUtil;

@Controller
@RequestMapping("/usuario/login")
@Transactional(dontRollbackOn = { JPAUtil.class })
public class LoginController {

	public List<Mammogram> Listmammogram = new ArrayList<>();
	public Mammogram mammogram;
	public static Usuario usuario;
	public MammogramDAO mammogramDAO;
	public HistoricoDAO historicoDAO;
	public FavoritoDAO favoritoDAO;
	ArrayList<Usuario> arrayUsuario;
	UsuarioDAO bancoDeDadosUsuario = new UsuarioDAO();
	LoginUsuario login = new LoginUsuario();
	Controle controle = new Controle();

	@RequestMapping("/controller")
	public ModelAndView login() {

		return new ModelAndView("/login/view");
	}

	@RequestMapping("/controle")
	public ModelAndView fazerLogin(HttpServletRequest request) {

		login.setLogin(request.getParameter("nome"));
		login.setSenha(request.getParameter("senha"));
		System.out.println(login.getLogin() + " " + login.getSenha());

		JPAUtil.comecarOperacoes();
		usuario = bancoDeDadosUsuario.recuperar(login.getLogin());
		JPAUtil.em.close();

		if (usuario == null) {
			System.err.println("Login ou senha incorreto(s)!");
			return new ModelAndView(new RedirectView("../login/controller.html"), "loginIncorreto", true);

		} else if (usuario.getNivelDeAcesso() == 0) {

			System.err.println("Usuario pendente!");
			return new ModelAndView(new RedirectView("../login/controller.html"), "loginPendente", true);

		} else if (usuario.getNivelDeAcesso() == 1 && (usuario.getSenha().equals(login.getSenha()))) {

			System.out.println("Login realizado!\n Tipo de conta: Usuario");
//			Listmammogram = mammogramDAO.recuperaPorUsuario();
			ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
			model.addObject("usuario", usuario);
			model.addObject("mammogram", Listmammogram);
			return model;

		} else if (usuario.getNivelDeAcesso() == 2 && (usuario.getSenha().equals(login.getSenha()))) {

			System.out.println("Login realizado!\n Tipo de conta: Administrador");

			// Obtem a lista de Usuarios Pendentes
			arrayUsuario = controle.getUsuariosPendentes();
			return new ModelAndView("/login/loginAdmin/viewAdmin", "arrayUsuario", arrayUsuario);
		} else {
			System.err.println("Login ou senha incorreto(s)!");
			return new ModelAndView(new RedirectView("../login/controller.html"), "loginIncorreto", true);
		}
	}
	
	@RequestMapping("/submit")
	public ModelAndView search(HttpServletRequest request) {
		System.out.println("Pesquisa: "+request.getParameter("search"));
		
		ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/favoritos")
	public ModelAndView favoritos() {
		// List<Favorito> favorito = favoritoDAO.recuperaPorUsuario();
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewFavoritos");
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/historico")
	public ModelAndView historico() {
		// List<Historico> historico = historicoDAO.recuperaPorUsuario();
		// historico.get(0).getMammogram();
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewHistorico");
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/imagemProc")
	public ModelAndView imagensProcessadas() {
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImgProc");
		model.addObject("usuario", usuario);
		return model;
	}

	// @RequestMapping("/imagem")
	// public ModelAndView imagem(HttpServletRequest request,
	// HttpServletResponse response)throws ServletException, IOException {
	//
	// // Get ID from request.
	// String imageId = request.getParameter("id");
	//
	// // Checando o id da imagem
	// if (imageId == null) {
	// response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	// }
	//
	//
	// Image image = imageDAO.find(imageId);
	//
	// // Caso a imagem não abra
	// if (image == null) {
	// response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	// return null;
	// }
	//
	// // Init servlet response.
	// response.reset();
	// response.setContentType(image.getContentType());
	// response.setContentLength(image.getContent().length);
	//
	// // Write image content to response.
	// response.getOutputStream().write(image.getContent());
	//
	// ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
	// model.addObject("usuario", usuario);
	// return model;
	// }

	@RequestMapping(value = "/recusar", method = RequestMethod.GET)
	public ModelAndView recusar(@RequestParam("cpfRecusado") String cpf) {

		// Retirar o usuario
		JPAUtil.comecarOperacoes();
		boolean sucesso = bancoDeDadosUsuario.remover(cpf);
		JPAUtil.finalizarOperacoes();

		if (sucesso) {
			System.out.println("Cpf retirado: " + cpf);
		} else {
			System.err.println("Nao foi possivel recusar o cpf: " + cpf);
		}
		arrayUsuario = controle.getUsuariosPendentes();
		return new ModelAndView("/login/loginAdmin/viewAdmin", "arrayUsuario", arrayUsuario);
	}

	@RequestMapping(value = "/autorizar", method = RequestMethod.GET)
	public ModelAndView autorizar(@RequestParam("cpfAutorizado") String cpf) {

		JPAUtil.comecarOperacoes();
		boolean sucesso = bancoDeDadosUsuario.autorizar(cpf);
		JPAUtil.finalizarOperacoes();

		if (sucesso) {
			JPAUtil.comecarOperacoes();
			Email.enviarEmail((bancoDeDadosUsuario.recuperar(cpf)).getEmail(), "Cadastro MIDAS",
					"Usuário " + (bancoDeDadosUsuario.recuperar(cpf)).getNome()
							+ "\n, seu cadastro foi aprovado com sucesso. A partir de agora "
							+ " você podera acessar o nosso sistema com as seguintes credencias \n\n Usuario: " + cpf
							+ "\n Senha: "
							+ bancoDeDadosUsuario.recuperar(
									cpf).getSenha()
					+ "\n\nAtenciosamente,\n\n Grupo MIDAS 2015 \n\n OBSERVAÇÃO: Por favor, não responder este email. Mensagem gerada automaticamente.");
			System.out.println("Cpf autorizado: " + cpf);
		} else {
			System.err.println("Nao foi possivel recusar o cpf: " + cpf);
		}

		arrayUsuario = controle.getUsuariosPendentes();
		return new ModelAndView("/login/loginAdmin/viewAdmin", "arrayUsuario", arrayUsuario);
	}
}