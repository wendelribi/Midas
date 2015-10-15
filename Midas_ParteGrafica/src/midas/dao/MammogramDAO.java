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
	public boolean inserir() {
		try{
			try{
				Mammogram mamo = new Mammogram();
				BufferedImage image = ImageIO.read(new File("./images.jpg"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.flush();
				mamo.setImagem(baos.toByteArray());
				mamo.setMammogramId(1);
				baos.close();
				UsuarioDAO.em.persist(mamo);
				return true;
			} catch(IOException ex) {
				return false;
			}
		} catch(EntityExistsException e) {
			return false;
		}
	}
	public Mammogram recuperar(String mamoId) {
		try {
			return UsuarioDAO.em.find(Mammogram.class, mamoId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
}
