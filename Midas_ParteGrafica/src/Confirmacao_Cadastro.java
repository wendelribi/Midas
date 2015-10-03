public class Confirmacao_Cadastro {

	// CLASSE QUE VERIFICA SE TODOS OS CAMPOS DOS CADASTROS ESTÃO VÁLIDAS

	Confirmacao valida = new Confirmacao();
	ValidacaoCpf cpfValido = new ValidacaoCpf();//CLASSE QUE VERIFICA O CPF
	ValidacaoEmail emailValido = new ValidacaoEmail(); // CLASSE QUE VERIFICA EMAIL
	

	public boolean confirmacao(String senha, String senha2, String nome, String sobrenome, String email, String cpf,
			boolean masc, boolean fem) {

		if (valida.confirmacaoSenha(senha, senha2) == true & valida.camposValidos(nome, sobrenome, email, cpf) == true
				& valida.campoGenero(masc, fem) & cpfValido.cpfValidacao(cpf) & emailValido.emailValidoo(email)) {
			return true;
		} else {

			return false;
		}
	}
}
