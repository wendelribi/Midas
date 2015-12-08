package midas.dao;

import midas.entidades.Historico;
import midas.entidades.Mammogram;
import midas.entidades.Usuario;
import midas.spring.mvc.controller.HistoricoController;
import midas.util.JPAUtil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.EntityExistsException;

public class MammogramDAO {
	private BufferedImage image;
	public boolean inserir() {
		try{
			try{
				JPAUtil.comecarOperacoes();
				Mammogram mamo = new Mammogram();
				image = ImageIO.read(new File("/Users/alvarovieira/Dropbox/MIDAS/teste.jpg"));
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.flush();
				mamo.setImagem(baos.toByteArray());
				
				baos.close();
				JPAUtil.em.persist(mamo);
				JPAUtil.finalizarOperacoes();
				return true;
			} catch(IOException ex) {
				return false;
			}
		} catch(EntityExistsException e) {
			return false;
		}
	}
	public Mammogram recuperar(int mamoId) {
		

		new Date(System.currentTimeMillis());
		
		try {
			JPAUtil.comecarOperacoes();
			Mammogram mamo = JPAUtil.em.find(Mammogram.class, mamoId);
			JPAUtil.em.find(Mammogram.class, mamoId);
			new HistoricoController(mamo);
			return JPAUtil.em.find(Mammogram.class, mamoId);
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
}
