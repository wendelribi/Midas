package midas.entidades;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Historico {
	@Id
	private Date data_hora;
	
	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "mammogramId")
	private Mammogram mammogram;
	
	public Historico() {}
	
	public Historico(Date data_hora) {
		this.data_hora = data_hora;
	}
	
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
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
}

