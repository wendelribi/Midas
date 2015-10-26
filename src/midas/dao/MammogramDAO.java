package midas.dao;

import midas.entidades.Mammogram;
import midas.entidades.Usuario;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityExistsException;
import midas.dao.UsuarioDAO;

public class MammogramDAO {
	private BufferedImage image;
	public boolean inserir() {
		try{
			try{
				UsuarioDAO.comecarOperacoes();
				Mammogram mamo = new Mammogram();
				image = ImageIO.read(new File("/Users/alvarovieira/Dropbox/MIDAS/teste.jpg"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.flush();
				mamo.setImagem(baos.toByteArray());
				
				baos.close();
				UsuarioDAO.em.persist(mamo);
				UsuarioDAO.finalizarOperacoes();
				return true;
			} catch(IOException ex) {
				return false;
			}
		} catch(EntityExistsException e) {
			return false;
		}
	}
	public Mammogram recuperar(int mamoId) {
		try {
			UsuarioDAO.comecarOperacoes();
			Mammogram mamo = UsuarioDAO.em.find(Mammogram.class, mamoId);
			UsuarioDAO.em.find(Mammogram.class, mamoId);
			return UsuarioDAO.em.find(Mammogram.class, mamoId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
}
