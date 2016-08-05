
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import Controle.HistoricoController;

public class MammogramDAO {
	private BufferedImage image;
	public boolean inserir() {
		try{
			JPAUtil.comecarOperacoes();
			JPAUtil.em.getTransaction().begin();
			Mammogram mamo = new Mammogram();
			image = ImageIO.read(new File("/Users/victordantas/Dropbox/MIDAS/Exemplo.jpg"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			mamo.setImagem(baos.toByteArray());
			baos.close();
			JPAUtil.em.persist(mamo);
			JPAUtil.em.getTransaction().commit();
			JPAUtil.finalizarOperacoes();
			return true;
		} catch(IOException | EntityExistsException ex) {
			return false;
		}
	}
	public Mammogram recuperar(Long mamoId) {
		
		
		try {
			JPAUtil.comecarOperacoes();
			Mammogram mamo = JPAUtil.em.find(Mammogram.class, mamoId);
			return mamo;
		} catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public List<Mammogram> search(String procura){
		return JPAUtil.em.createQuery("select u from Mammogram u, Study y where u.studyId = y.studyId AND y.findings LIKE :tituloParam")
				.setParameter("tituloParam", procura).getResultList();
	}

	public List<Mammogram> recuperaPorUsuario(){
		JPAUtil.comecarOperacoes();
		List<Historico> historico = new ArrayList<Historico>(); 
				historico = JPAUtil.em.createQuery("select u from Historico u where u.usuarioid = tituloParam").setParameter("tituloParam", LoginController.usuario.getId()).getResultList();
		JPAUtil.finalizarOperacoes();
		if(historico.isEmpty()){
			System.out.println("deu ruim");
		}
		
		List<Mammogram> mammogram = new ArrayList<>();
		for(int i = 0; i < historico.size()-1; i++){
			System.out.println(""+historico.get(i).getMammogram().getMammogramId());
			mammogram.add(recuperar(historico.get(i).getMammogram().getMammogramId()));
		
		}

		return mammogram;
	}	
	public List<Mammogram> recuperaTudo(){
		
		try {
			JPAUtil.comecarOperacoes();
			List<Mammogram> mamograma = new ArrayList<Mammogram>();
			mamograma =  JPAUtil.em.createQuery("FROM Mammogram").getResultList();
			JPAUtil.finalizarOperacoes();
			return mamograma;
		}catch (Exception e) {
			return null;
		}
		
	}
}
