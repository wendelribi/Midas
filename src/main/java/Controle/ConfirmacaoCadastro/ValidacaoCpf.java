package Controle.ConfirmacaoCadastro;
import javax.swing.JOptionPane;

/* Classe responsavel por verificar o campo Cpf, quando o usuario for se cadastrar.
 * Informa o erro, caso exista e � chamada pela classe Confirmacao_Cadastro.
 */

public class ValidacaoCpf {
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}
	
	/*	Metodo: cpfValidacao.
	Descricao: 
		Essa funcao retorna em booleano se o campo cpf � valido ou nao.	
	Parametros:
 		String cpf: Campo onde o usuario coloca o cpf.
 	Valor retornado:
		A funcao retorna true ou false por meio da variavel validacaoCpf. True, caso
		o cpf tenha 11 numeros. False, caso contr�rio. 
	 */
	
	public boolean cpfValidacao(String cpf) {
		boolean validacaoCpf = true;
		int contadorDeNumeros = 0, i, tamanhoCpf;

		if (cpf.equals(comparacao) || cpf.equals("CPF") || ((tamanhoCpf = cpf.length()) != 11)) {
			validacaoCpf = false;
			System.err.println("Erro no campo CPF");
		}

		if (cpf.length() == 11) {

			for (i = 0; i < cpf.length(); i++) {
				if (cpf.charAt(i) >= '0' && cpf.charAt(i) <= '9') {
					contadorDeNumeros++;
				}
			}

			if (cpf.length() != contadorDeNumeros) {
				validacaoCpf = false; // Caso a senha não possua Caracteres ou
										// Numeros
				System.err.println("Erro no campo CPF. Digite só numeros!");
			}
		}

		return validacaoCpf;
	}
}
