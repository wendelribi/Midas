package Controle.ConfirmacaoCadastro;
import javax.swing.JOptionPane;

/* Classe que verifica os campos nome,sobrenome,genero,senha e confirmacao de senha
 * quando o usuario for se cadastrar. E informa o erro de cada campo, se existir. 
 * Essa classe � chamda pela classe Confirmacao_Cadastro.
 */

public class Confirmacao {
	boolean validacaoSenha, validacaoCampos, sexoValido;
	String comparacao;

	public Confirmacao() {
		comparacao = "";
	}
	
	/*	Metodo: confirmacaoSenha.
	Descricao: 
		Essa funcao retorna em booleano se o campo de confirmacao da senha est� correto ou nao.	
	Parametros:
 		String senha1: Primeiro campo que o usuario coloca como senha.
 		String senha2: Segundo campo que o usuario coloca como confirmacao da senha.
 	Valor retornado:
		A funcao retorna true ou false por meio da variavel validacaoSenha. True, caso
		as Strings da senha e confirmacao da senha forem iguais. False, caso contr�rio. 
	 */

	public boolean confirmacaoSenha(String Senha1, String Senha2) {
		validacaoSenha = true;
		int i, contadorDeLetras = 0;

		if (Senha1.equals(comparacao) || Senha1.equals("****")) {
			validacaoSenha = false;// Caso a senha esteja em branco
			JOptionPane.showMessageDialog(null, "Erro no campo Senha", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		if (!(Senha1.equals(Senha2))) {

			validacaoSenha = false; // Caso as senhas sejam iguais, retorna true
			JOptionPane.showMessageDialog(null, "Erro no campo confirmacao da senha", "ERRO",
					JOptionPane.WARNING_MESSAGE);
		}
		if (Senha1.length() < 6) {
			validacaoSenha = false; // Caso a senha seja muito curta
			JOptionPane.showMessageDialog(null, "A senha deve conter no minimo 6 digitos, incluido caracteres", "ERRO",
					JOptionPane.WARNING_MESSAGE);
		} else {
			for (i = 0; i < Senha1.length(); i++) {
				if ((Senha1.charAt(i) >= 'A' && Senha1.charAt(i) <= 'Z')
						|| (Senha1.charAt(i) >= 'a' && Senha1.charAt(i) <= 'z')) {
					contadorDeLetras++;
				}
			}

			if (Senha1.length() == contadorDeLetras) {
				validacaoSenha = false; // Caso a senha nao possua Caracteres ou
										// Numeros
				JOptionPane.showMessageDialog(null, "A senha deve conter Caracteres '.,!#' ou Numeros '123' ", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return validacaoSenha;
	}

	/*	Metodo: camposValidos.
	Descricao: 
		Essa funcao retorna em booleano se os campos nome e sobrenome estao corretos ou nao.	
	Parametros:
 		String nome: Campos onde o usuario coloca o nome.
 		String  sobrenome: Campo onde o usuario coloca o sobrenome.
 	Valor retornado:
		A funcao retorna true, caso os dois campos estejam corretos. False, caso 
		algum dos campos esteja incorreto. 
	 */

	public boolean camposValidos(String nome, String sobrenome) {
		validacaoCampos = true;
		if (nome.equals(comparacao) || nome.equals("Primeiro Nome")) {
			validacaoCampos = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Primeiro Nome", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		if (sobrenome.equals(comparacao) || sobrenome.equals("Ultimo Nome")) {
			validacaoCampos = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Ultimo Nome", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		return validacaoCampos;
	}
	
	/*	Metodo: campoGenero.
	Descricao: 
		Essa funcao retorna em booleano se o campo Genero foi selecionado em Masculino ou Feminino.	
	Parametros:
 		boolean masc: Variavel que recebe true caso esteja selecionada em masculino.
 		boolean fem: Variavel que recebe true caso esteja selecionada em feminino.
 	Valor retornado:
		A funcao retorna true, caso algum dos campos estejam selecionados. False, 
		caso contrario. 
	 */

	public boolean campoGenero(boolean masc, boolean fem) {

		sexoValido = true;

		if ((!masc) & (!fem)) {
			sexoValido = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Genero", "ERRO", JOptionPane.WARNING_MESSAGE);

		}
		return sexoValido;
	}
}
