package midas.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Controle.Controle;
import Controle.ConfirmacaoCadastro.ConfirmacaoCadastro;
import midas.entidades.Usuario;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

	@RequestMapping("/controller")
	public ModelAndView cadastrar() {
		return new ModelAndView("/cadastro/cadastrar");
	}

	@RequestMapping("/validacao")
	public ModelAndView validacao(HttpServletRequest request) {

		Usuario usuario = new Usuario();
		ConfirmacaoCadastro validaCadastro = new ConfirmacaoCadastro();
		Controle controle = new Controle();
		boolean valida[];
		
		;
		try {
			usuario.setNome(request.getParameter("nome") + " " + request.getParameter("sobrenome"));
			usuario.setCpf(request.getParameter("cpf"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setDataNascimento(request.getParameter("dataNascimento"));
			usuario.setProfissao(request.getParameter("profissao"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setNivelDeAcesso(0);
			if(request.getParameter("sexo").equals("masculino") || request.getParameter("sexo").equals("feminino")){
				usuario.setSexo(request.getParameter("sexo").charAt(0));
			}
			else{
				usuario.setSexo('n');
			}
		} catch (StringIndexOutOfBoundsException | NullPointerException e) {
			
			System.err.println("Você deixou algum dos campos em branco.");
			System.err.println("Nao foi possivel realizar o cadastro. Tente novamente.");
			return new ModelAndView("/cadastro/cadastrar");
		}
		
		System.out.println(usuario.getNome() + "\n" + usuario.getCpf() + "\n" + usuario.getDataNascimento() + "\n"
				+ usuario.getEmail() + "\n" + usuario.getSenha() + "\n" + usuario.getProfissao() + "\n"
				+ usuario.getSexo() + "\n" + usuario.getNivelDeAcesso() + "\n");

		valida = validaCadastro.confirmacao(usuario.getSenha(), request.getParameter("confirmacaoSenha"),
				usuario.getNome(), usuario.getDataNascimento(), usuario.getEmail(), usuario.getCpf(), usuario.getSexo(),
				usuario.getProfissao());

		if (validaCadastro.confirmaCadastro(valida)) {
			if (controle.enviarCadastro(usuario)) {
				
				System.out.println("Cadastro enviado com sucesso");
				return new ModelAndView(new RedirectView("../"));
				
			} else {
				
				System.err.println("Falha ao enviar o cadastro");
				return new ModelAndView(new RedirectView("./controller.html"));
			}
			
		} else {
			
			System.err.println("Nao foi possivel realizar o cadastro. Tente novamente.");
			return new ModelAndView("/cadastro/cadastrar","valida",valida);
		}
	}
}
