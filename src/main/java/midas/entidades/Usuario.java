package midas.entidades;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name = "usuarioId")
	private long id;
	@Column(nullable = false,unique = true)
	private String cpf;
	@Column(nullable = false)
	private String nome; // Nome completo
	@Column(nullable = false)
	private String profissao;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private String email; 
	@Column(nullable = false)
	private char sexo;
	@Column(nullable = false)
	private int nivelDeAcesso;
	@Column
	private String dataNascimento;
	// Ordem certa a ser inserida: aaaa-mm-dd
	@OneToMany(mappedBy = "usuario")
	private List<Historico> historicos;
	
	public Usuario() {
		
	}
	public Usuario(String cpf, String nome, String profissao, String senha, String email, char sexo, int nivelDeAcesso) {
		this.cpf = cpf;
		this.nome = nome;
		this.profissao = profissao;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.nivelDeAcesso = nivelDeAcesso;
	}
	
	// GETS e SETS
	public long getId() {
		return id;
	}
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
	public String getDataNascimento(){
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento){
		this.dataNascimento = dataNascimento;
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
