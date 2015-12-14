package midas.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midas.dao.ImagemProcessadaDAO;
import midas.entidades.ImagemProcessada;

@WebServlet("/imagensProcessadas/*")
public class ProcessamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ImagemProcessadaDAO imagemProcessadaDAO;
    
    public ProcessamentoServlet() {
    	imagemProcessadaDAO = new ImagemProcessadaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgId = request.getParameter("id");
		
		if (imgId == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		ImagemProcessada imagem = imagemProcessadaDAO.recuperar(Long.parseLong(imgId));
		
		if (imagem == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		ImageInputStream in = ImageIO.createImageInputStream(imagem.getImagemProcessada());
		BufferedImage bi = ImageIO.read(in);
		
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		
	}

}
