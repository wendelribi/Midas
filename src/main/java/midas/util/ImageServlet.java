package midas.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midas.dao.MammogramDAO;
import midas.entidades.Mammogram;

@WebServlet("/imagens/*")
public class ImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MammogramDAO mammogramDAO;
	
	public void init() throws ServletException {
		this.mammogramDAO = new MammogramDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mammoId = req.getParameter("id");
		
		if (mammoId == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		Mammogram mammogram = mammogramDAO.recuperar(Long.parseLong(mammoId));
		
		if (mammogram == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		BufferedImage imagem = ImageUtil.converte(mammogram);
		
		if (imagem == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		OutputStream out = resp.getOutputStream();
		ImageIO.write(imagem, "jpg", out);
	}
	
}
