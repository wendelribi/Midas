package midas.entidades;

import midas.processamentoDeImagens.Processamento;
import javax.persistence.*;

@Entity
public class ImagemProcessada {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Processamento processamento;
	@ManyToOne
	private Mammogram mammogram;
	@Column
	private byte[] imagemProcessada;
	
	public ImagemProcessada() {	}
	public ImagemProcessada(Processamento processamento, byte[] imagemProcessada, Mammogram mammogram) {
		this.processamento = processamento;
		this.imagemProcessada = imagemProcessada;
		this.mammogram = mammogram;
	}
	
	public Long getId() {
		return id;
	}
	public Processamento getProcessamento() {
		return processamento;
	}
	public void setProcessamento(Processamento processamento) {
		this.processamento = processamento;
	}
	public Mammogram getMammogram() {
		return mammogram;
	}
	public void setMammogram(Mammogram mammogram) {
		this.mammogram = mammogram;
	}
	public byte[] getImagemProcessada() {
		return imagemProcessada;
	}
	public void setImagemProcessada(byte[] imagemProcessada) {
		this.imagemProcessada = imagemProcessada;
	}
}
