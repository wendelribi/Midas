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
	@Column
	@OneToMany 
	private List<Study> studyId;
	
	public int getMammogramId() {
		return mammogramId;
	}
	public void setMammogramId(int mammogramId) {
		this.mammogramId = mammogramId;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public BufferedImage converte(byte[] vetorByte) {
		try {
			return ImageIO.read(new ByteArrayInputStream(vetorByte));
		} catch (IOException e) {
			return null;
		}
	}

}