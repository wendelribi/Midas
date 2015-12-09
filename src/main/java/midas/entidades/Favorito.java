package midas.entidades;

import java.util.Date;
import javax.persistence.*;

import midas.processamentoDeImagens.Processamento;

@Entity
public class Favorito {
	@Id
	@GeneratedValue
	@Column(name = "favoritoId")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Processamento processamento;
	
	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "mammogramId")
	private Mammogram mammogram;
	
	public Favorito() {}
	
	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Mammogram getMammogram() {
		return mammogram;
	}
	public void setMammogram(Mammogram mammogram) {
		this.mammogram = mammogram;
	}
	public Processamento getProcessamento (){
		return processamento;
	}
	public void setProcessamento(Processamento processamento){
		this.processamento = processamento;
	}
	
}

