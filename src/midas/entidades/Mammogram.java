package midas.entidades;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.*;

@Entity(name = "Mammogram")
public class Mammogram {
	@Id
	@GeneratedValue
	@Column(nullable=false)
	private int mammogramId;
	@Column(name="image")
	private byte[] imagem;
	@ManyToOne
	@JoinColumn(name = "studyId")
	private Study study;
	
	public Mammogram() {
		
	}
	public Mammogram(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public int getMammogramId() {
		return mammogramId;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public BufferedImage converte(byte[] vetorByte) {
		try {
			return ImageIO.read(new ByteArrayInputStream(vetorByte));
		} catch (IOException e) {
			return null;
		}
	}

}
