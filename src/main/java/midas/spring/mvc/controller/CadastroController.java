package midas.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		System.out.println("1");
		ConfirmacaoCadastro validaCadastro = new ConfirmacaoCadastro();
		System.out.println("2");
		Controle controle = new Controle();
		System.out.println("3");
		boolean valida;

		usuario.setNome(request.getParameter("nome") + " " + request.getParameter("sobrenome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setDataNascimento(request.getParameter("dataNascimento"));
		usuario.setSexo(request.getParameter("sexo").charAt(0));
		usuario.setProfissao(request.getParameter("profissao"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setNivelDeAcesso(0);

		System.out.println(usuario.getNome() + "\n" + usuario.getCpf() + "\n" + usuario.getDataNascimento() + "\n"
				+ usuario.getEmail() + "\n" + usuario.getSenha() + "\n" + usuario.getProfissao() + "\n"
				+ usuario.getSexo() + "\n" + usuario.getNivelDeAcesso() + "\n");

		valida = validaCadastro.confirmacao(usuario.getSenha(), request.getParameter("confirmacaoSenha"),
				usuario.getNome(), usuario.getDataNascimento(), usuario.getEmail(), usuario.getCpf(),
				usuario.getSexo());
		
//		valida = true;
		
		if(valida){
			if(controle.enviarCadastro(usuario))
				System.out.println("Cadastro enviado com sucesso");
			else
				System.out.println("Falha ao enviar o cadastro");
		}
		else{
			System.out.println("Nao foi possivel realizar o cadastro. Tente novamente");
		}
	}
}
