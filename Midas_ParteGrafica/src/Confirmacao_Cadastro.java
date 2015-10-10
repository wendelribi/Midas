/* Classe que verifica se todos os campos que o usuario digitou, na hora de fazer o
 * cadastro, estão corretos ou válidos. Essa classe é chamada pela classe Usuario. 
 */

public class Confirmacao_Cadastro {

	Confirmacao valida = new Confirmacao(); //Cria um objeto da classe Confirmacao
	ValidacaoCpf cpfValido = new ValidacaoCpf();//Cria um objeto da classe ValidacaoCpf
	ValidacaoEmail emailValido = new ValidacaoEmail();//Cria um objeto da classe ValidacaoEmail
	
	/*	Metodo: confirmacao.
	Descricao: 
		Essa funcao retorna em booleano se todos os campos de cadastro estao corretos ou nao.	
	Parametros:
 		String senha1,senha2: Campos onde o usuario coloca a senha e a confirmacao da senha.
 		String nome, sobrenome: Campos onde o usuario coloca o nome e o sobrenome.
 		String cpf, email: Campos onde o usuario coloca o cpf e o email.
 	Valor retornado:
		A funcao retorna true, caso todos os campos estejam corretos. False, caso 
		algum dos campos esteja incorreto. 
	 */

	public boolean confirmacao(String senha, String senha2, String nome, String sobrenome, String email, String cpf,
			boolean masc, boolean fem) {

		if (valida.confirmacaoSenha(senha, senha2) == true & valida.camposValidos(nome, sobrenome) == true
				& valida.campoGenero(masc, fem) & cpfValido.cpfValidacao(cpf) & emailValido.emailValido(email)) {
			return true;
		} else {

			return false;
		}
	}
}
