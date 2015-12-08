package Controle.ConfirmacaoCadastro;
import javax.swing.JOptionPane;

/* Classe responsavel por verificar o campo Email, quando o usuario for se cadastrar.
 * Informa o erro, caso exista e � chamada pela classe Confirmacao_Cadastro. 
 */

public class ValidacaoEmail {
	
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}
	
	/*	Metodo: emailValido.
	Descricao: 
		Essa funcao retorna em booleano se o campo email � valido ou nao.	
	Parametros:
 		String email: Campo onde o usuario coloca o email.
 	Valor retornado:
		A funcao retorna true ou false por meio da variavel validacaoEmail. True, caso
		o email contenha arroba e ponto. False, caso contr�rio. 
	 */

	public boolean CampoEmail(String email) {
		boolean validacaoEmail = true;
		
		// Variaveis que contam o numero de pontos,arrobas e letras.
		int i, contA = 0, contP = 0,contL=0;
		
		for (i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@' && email.charAt(i+1) != '@' && i != 0) {
				contA++;
			}
			if (email.charAt(i) == '.' && email.charAt(i+1) != '.' && email.charAt(i-1) != '@' && i > 2) {
				contP++;
			}
			if ((email.charAt(i) >= 'A' && email.charAt(i) <= 'Z')
						|| (email.charAt(i) >= 'a' && email.charAt(i) <= 'z')) {
					contL++;
			}
			if(email.charAt(i) == ' ') {
				validacaoEmail = false;
			}
		}
	
		if (contA != 1 || contP < 1 || contL < 3) {
			validacaoEmail = false;
		}
		
		if (email.equals(comparacao) || email.equals("Email")) {
			validacaoEmail=false;
		}
		
		return validacaoEmail;
	}
}
