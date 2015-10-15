package midas.entidades;

import java.sql.Date;

import javax.persistence.*;

@Entity(name = "Usuario")
public class Usuario {
	@Id
	@Column(name="CPF", nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String nome; // Nome completo
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String profissao;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String email; 
	
	@Column(nullable = false)
	private char sexo;
	
	@Column(name="idAcesso",nullable = false)
	private int nivelDeAcesso;
	
	@Column (nullable = false)
	private Date dataNascimento;
	// Ordem certa a ser inserida: aaaa-mm-dd
	
	// GETS e SETS
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getProfissao(){
		return profissao;
	}
	public void setProfissao(String profissao){
		this.profissao = profissao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getNivelDeAcesso() {
		return nivelDeAcesso;
	}
	public void setNivelDeAcesso(int nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}
	public Date getDataNascimento(){
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	
}
