import javax.swing.JOptionPane;

/* Classe responsavel por verificar o campo Email, quando o usuario for se cadastrar.
 * Informa o erro, caso exista e é chamada pela classe Confirmacao_Cadastro. 
 */

public class ValidacaoEmail {
	
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}
	
	/*	Metodo: emailValido.
	Descricao: 
		Essa funcao retorna em booleano se o campo email é valido ou nao.	
	Parametros:
 		String email: Campo onde o usuario coloca o email.
 	Valor retornado:
		A funcao retorna true ou false por meio da variavel validacaoEmail. True, caso
		o email contenha arroba e ponto. False, caso contrário. 
	 */

	public boolean emailValido(String email) {
		boolean validacaoEmail = true;
		
		// Variaveis que contam o numero de pontos,arrobas e letras.
		int i, contA = 0, contP = 0,contL=0;
		
		for (i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				contA++;
			}
			if (email.charAt(i) == '.') {
				contP++;
			}
			if ((email.charAt(i) >= 'A' && email.charAt(i) <= 'Z')
						|| (email.charAt(i) >= 'a' && email.charAt(i) <= 'z')) {
					contL++;
			}
		}
	
		if (contA != 1 || contP <= 0 || contL<=5) {
			validacaoEmail = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Email", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		
		if (email.equals(comparacao) || email.equals("Email")) {
			validacaoEmail=false;
			JOptionPane.showMessageDialog(null, "Erro no campo Email", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		
		return validacaoEmail;
	}
}
