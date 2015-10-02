public class Confirmacao_Cadastro {

	Confirmacao valida = new Confirmacao();

	public boolean confirmacao(String senha, String senha2, String nome
	, String sobrenome,String email,String cpf,boolean masc,boolean fem) {

		if (valida.confirmacaoSenha(senha, senha2) == true
				& valida.camposValidos(nome, sobrenome, email, cpf) == true 
				& valida.campoGenero(masc,fem)) {
			return true;
		} else {
			
			return false;
		}
	}
}
