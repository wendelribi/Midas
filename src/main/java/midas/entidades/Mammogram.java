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
	private Long mammogramId;
	@Column(name="image")
	private byte[] imagem;
	@ManyToOne
	@JoinColumn(name = "studyId")
	private Study study;
	@OneToMany(mappedBy = "mammogram")
	private List<Historico> historicos;
	
	public Mammogram() {
		
	}
	public Mammogram(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public Long getMammogramId() {
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
	public void adicionaHistorico(Historico historico) {
		historicos.add(historico);
	}
	public List<Historico> getHistoricos() {
		return historicos;
	}
	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
	
}
