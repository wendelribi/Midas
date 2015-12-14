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
import midas.dao.ImagemProcessadaDAO;
import midas.dao.MammogramDAO;
import midas.dao.UsuarioDAO;
import midas.entidades.*;
import midas.processamentoDeImagens.ProcessamentodeImagensMarvin;
import midas.util.JPAUtil;

@Controller
@RequestMapping("/usuario/login")
@Transactional(dontRollbackOn = { JPAUtil.class })
public class LoginController {

	public List<Mammogram> listMammogram = new ArrayList<Mammogram>();
	public List<Favorito> listFavorito = new ArrayList<Favorito>();
	public List<Historico> listHistorico = new ArrayList<Historico>();
	public List<Favorito> listProcessadas = new ArrayList<Favorito>();
	public ArrayList<Long> mammogramId;
	public Mammogram mammogram;
	public Favorito favorito;
	public static Usuario usuario;
	public MammogramDAO mammogramDAO = new MammogramDAO();
	public HistoricoDAO historicoDAO = new HistoricoDAO();
	public FavoritoDAO favoritoDAO = new FavoritoDAO();
	public ImagemProcessadaDAO imagemProcessadaDAO = new ImagemProcessadaDAO();
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

		if (usuario == null) {
			System.err.println("Login ou senha incorreto(s)!");
			return new ModelAndView(new RedirectView("../login/controller.html"), "loginIncorreto", true);

		} else if (usuario.getNivelDeAcesso() == 0) {

			System.err.println("Usuario pendente!");
			return new ModelAndView(new RedirectView("../login/controller.html"), "loginPendente", true);

		} else if (usuario.getNivelDeAcesso() == 1 && (usuario.getSenha().equals(login.getSenha()))) {
			
			System.out.println("Login realizado!\n Tipo de conta: Usuario");
			
			listMammogram = mammogramDAO.recuperaTudo();
			ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
			mammogramId = new ArrayList<>();
			if(listMammogram != null){
				if(listMammogram.size() == 0){
					request.setAttribute("mammogramVazio", "true");
				}
				for(Mammogram arrayList:listMammogram){
					mammogramId.add(arrayList.getMammogramId());
				}
			}
			model.addObject("usuario", usuario);
			model.addObject("mammogramId", mammogramId);
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
		System.out.println("Pesquisa: " + request.getParameter("search"));
		ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/inicio")
	public ModelAndView inicio(HttpServletRequest request) {
		mammogramId = new ArrayList<>();
		if(listMammogram != null){
			if(listMammogram.size() == 0){
				request.setAttribute("mammogramVazio", "true");
			}
			for(Mammogram arrayList:listMammogram){
				mammogramId.add(arrayList.getMammogramId());
			}
		}
		ModelAndView model = new ModelAndView("/login/loginUsuario/UserHub");
		model.addObject("mammogramId", mammogramId);
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/favoritos")
	public ModelAndView favoritos(HttpServletRequest request) {
		mammogramId = new ArrayList<>();
		listFavorito = favoritoDAO.recuperaPorUsuario();
		
		if(listFavorito != null){
			if(listFavorito.size() == 0){
				request.setAttribute("mammogramVazio", "true");
			}
			for(Favorito arrayList:listFavorito)
				mammogramId.add(arrayList.getMammogram().getMammogramId());
		}
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewFavoritos");
		model.addObject("mammogramId", mammogramId);
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/historico")
	public ModelAndView historico(HttpServletRequest request) {
		mammogramId = new ArrayList<>();
		listHistorico = historicoDAO.recuperaPorUsuario();
		if(listHistorico != null){
			if(listHistorico.size() == 0){
				request.setAttribute("mammogramVazio", "true");
			}
			for(Historico arrayList:listHistorico)
				mammogramId.add(arrayList.getMammogram().getMammogramId());
		}
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewHistorico");
		model.addObject("mammogramId", mammogramId);
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping("/imagemProc")
	public ModelAndView imagensProcessadas(HttpServletRequest request) {
		
		mammogramId = new ArrayList<>();
		listProcessadas = favoritoDAO.recuperaFavoritosProcessados();
		if(listProcessadas != null){
			if(listProcessadas.size() == 0){
				request.setAttribute("mammogramVazio", "true");
			}
			for(Favorito arrayList:listProcessadas)
				mammogramId.add(arrayList.getMammogram().getMammogramId());
		}
		
		
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImgProc");
		model.addObject("usuario", usuario);
		model.addObject("mammogramId", mammogramId);
		return model;
	}
	
	@RequestMapping(value = "/imagem", method = RequestMethod.GET)
	public ModelAndView getImagem(@RequestParam("mammogramId") Long id,HttpServletRequest request) {	
		
		int i=0;
		for(;id != listMammogram.get(i).getMammogramId();i++);
		new HistoricoController(listMammogram.get(i));
		request.setAttribute("processar","false");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/filtroBordas",  method = RequestMethod.GET)
	public ModelAndView filtroBordas(@RequestParam("mammogramId") Long id,HttpServletRequest request){

		List<ImagemProcessada> imagens = imagemProcessadaDAO.recuperarIdOriginal(id);
		
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("imageId",imagens.get(0).getId());
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/filtroPrewitt", method = RequestMethod.GET)
	public ModelAndView filtroPrewitt(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/filtroRoberts", method = RequestMethod.GET)
	public ModelAndView filtroRoberts(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}

	@RequestMapping(value = "/filtroSobel", method = RequestMethod.GET)
	public ModelAndView filtroSobel(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/filtroNegativo", method = RequestMethod.GET)
	public ModelAndView filtroNegativo(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/favoritar",method = RequestMethod.GET)
	public ModelAndView favoritar(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		favorito = new Favorito();
		favorito.setUsuario(usuario);
		int i=0;
		for(;id != listMammogram.get(i).getMammogramId();i++);
		favorito.setMammogram(listMammogram.get(i));
		favoritoDAO.inserir(favorito);
		
		request.setAttribute("processar","false");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
	@RequestMapping(value = "/salvar",method = RequestMethod.GET)
	public ModelAndView salvar(@RequestParam("mammogramId") Long id,HttpServletRequest request){
		request.setAttribute("processar","true");
		ModelAndView model = new ModelAndView("/login/loginUsuario/viewImagem");
		model.addObject("mammogramId",id);
		model.addObject("usuario", usuario);
		return model;
	}
	
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