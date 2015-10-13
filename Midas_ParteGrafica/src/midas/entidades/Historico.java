package midas.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Historico {
	@Id
	private Date data_hora;
	@Column
	private String cpf_usuario;
	@Column
	private int pacienteId;
	
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	public String getCpf_usuario() {
		return cpf_usuario;
	}
	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
}
