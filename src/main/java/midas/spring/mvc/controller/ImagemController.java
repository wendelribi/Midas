package midas.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import midas.processamentoDeImagens.ProcessamentoDeImagens;
import midas.processamentoDeImagens.ProcessamentodeImagensMarvin;
@RequestMapping("/imagem")
public class ImagemController {
	
	ProcessamentodeImagensMarvin processador;
	
	@RequestMapping ("/info")
	public ModelAndView informacao()
	{
		//TODO Adicionar view da imagem com botao de fazer o gradiente
		return new ModelAndView("/info/informacao");
	}

}
