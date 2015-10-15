import javax.swing.JOptionPane;

/* Classe responsavel por verificar o campo Cpf, quando o usuario for se cadastrar.
 * Informa o erro, caso exista e é chamada pela classe Confirmacao_Cadastro.
 */

public class ValidacaoCpf {
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}
	
	/*	Metodo: cpfValidacao.
	Descricao: 
		Essa funcao retorna em booleano se o campo cpf é valido ou nao.	
	Parametros:
 		String cpf: Campo onde o usuario coloca o cpf.
 	Valor retornado:
		A funcao retorna true ou false por meio da variavel validacaoCpf. True, caso
		o cpf tenha 11 numeros. False, caso contrário. 
	 */
	
	public boolean cpfValidacao(String cpf) {
		boolean validacaoCpf = true;
		int contadorDeNumeros = 0, i, tamanhoCpf;

		if (cpf.equals(comparacao) || cpf.equals("CPF") || ((tamanhoCpf = cpf.length()) != 11)) {
			validacaoCpf = false;
			JOptionPane.showMessageDialog(null, "Erro no campo CPF", "ERRO", JOptionPane.WARNING_MESSAGE);
		}

		if (cpf.length() == 11) {

			for (i = 0; i < cpf.length(); i++) {
				if (cpf.charAt(i) >= '0' && cpf.charAt(i) <= '9') {
					contadorDeNumeros++;
				}
			}

			if (cpf.length() != contadorDeNumeros) {
				validacaoCpf = false; // Caso a senha nÃ£o possua Caracteres ou
										// Numeros
				JOptionPane.showMessageDialog(null, "Erro no campo CPF, digite apenas numeros", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return validacaoCpf;
	}
}
