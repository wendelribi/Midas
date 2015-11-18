package midas.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/")
public class ImagemController {
	
	
	@RequestMapping ("/controller")
	public ModelAndView informacao()
	{
		return new ModelAndView("/info/informacao");
	}

}
