package Controle;

/*
 * Armazena as informações do novo usuário, recebidas pela interface gráfica que
 * serão passadas para o banco de dados
 */
public class NovoUsuario {
	private String nome, sobrenome, email, cpf, senha, senhaValidacao, profissao;
	private boolean opcaoMasc, opcaoFem;
	
	
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaValidacao() {
		return senhaValidacao;
	}
	public void setSenhaValidacao(String senhaValidacao) {
		this.senhaValidacao = senhaValidacao;
	}
	public boolean isOpcaoMasc() {
		return opcaoMasc;
	}
	public void setOpcaoMasc(boolean opcaoMasc) {
		this.opcaoMasc = opcaoMasc;
	}
	public boolean isOpcaoFem() {
		return opcaoFem;
	}
	public void setOpcaoFem(boolean opcaoFem) {
		this.opcaoFem = opcaoFem;
	}
}
