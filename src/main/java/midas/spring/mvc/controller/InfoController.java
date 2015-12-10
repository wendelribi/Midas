package midas.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		System.out.println("Email: "+request.getParameter("email")+"\nMensagem: "+request.getParameter("mensagem"));
		request.getParameter("email");
		request.getParameter("mensagem");
		return new ModelAndView("/info/suporte");
	}
}
