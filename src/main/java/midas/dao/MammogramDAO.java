
package midas.dao;

import midas.entidades.Historico;
import midas.entidades.Mammogram;
import midas.entidades.Usuario;
import midas.spring.mvc.controller.LoginController;
import midas.util.JPAUtil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityExistsException;

import Controle.HistoricoController;

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
	
	public List<Mammogram> search(String procura){
		return JPAUtil.em.createQuery("select u from Mammogram u, Study y where u.studyId = y.studyId AND y.findings LIKE :tituloParam")
				.setParameter("tituloParam", procura).getResultList();
	}
	
	public List<Mammogram> recuperaPorUsuario(){
		List<Historico> historico = JPAUtil.em.createQuery("selec u from Historico u where u.usuarioId =: TituloParam").setParameter("TituloParam",LoginController.usuario.getId()).getResultList();
		List<Mammogram> mammogram = null;
		for(int i = 0; i < historico.size(); i++){
			mammogram.add(recuperar(historico.get(i).getMammogram().getMammogramId()));
		}	
		return mammogram;
	}
}


