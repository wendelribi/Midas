package midas.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import Controle.Email;
import Controle.ConfirmacaoCadastro.ValidacaoEmail;
import midas.entidades.Usuario;
	
	
@Controller
@RequestMapping("/info")
public class InfoController {
	
	@RequestMapping("/controller")
	public ModelAndView informacao() {
		return new ModelAndView("/info/informacao");
	}

	@RequestMapping("/controle")
	public ModelAndView suporte() {

		return new ModelAndView("/info/suporte");
	}
	
	@RequestMapping(value = "/contato",method = RequestMethod.POST)
	public ModelAndView post(HttpServletRequest request, HttpServletResponse resp) {
		
		request.getParameter("email");
		request.getParameter("mensagem");
		
		ValidacaoEmail valido = new ValidacaoEmail();
		boolean email_enviado;
		
		if(valido.CampoEmail(request.getParameter("email")))
		{
			email_enviado = Email.enviarEmail("grupomidas2015@gmail.com","SUPORTE DO USUARIO :"+request.getParameter("email"),"Mensagem: " + request.getParameter("mensagem")+"\n\n"+"Enviado por : "+request.getParameter("email"));
			request.setAttribute("emailEnviado", email_enviado);
			request.setAttribute("emailInvalido", false);
		}
		else
		{
			request.setAttribute("emailInvalido",true);
		}
		return new ModelAndView("/info/suporte");	
	}
}
