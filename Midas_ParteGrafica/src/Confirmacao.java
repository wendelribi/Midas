import javax.swing.JOptionPane;

public class Confirmacao {
	boolean validacaoSenha, validacaoCampos, sexoValido, emailValido, cpfValidacao;
	String comparacao;
	int tamanhoCpf;

	public Confirmacao() {
		comparacao = "";
	}

	public boolean confirmacaoSenha(String Senha1, String Senha2) {
		validacaoSenha = true;
		int i, contadorDeLetras = 0;

		if (Senha1.equals(comparacao) || Senha1.equals("****")) {
			validacaoSenha = false;// Caso a senha esteja em branco
			JOptionPane.showMessageDialog(null, "Erro no campo Senha", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		if (!(Senha1.equals(Senha2))) {

			validacaoSenha = false; // Caso as senhas sejam iguais, retorna true
			JOptionPane.showMessageDialog(null, "Erro no campo confirmação da senha", "ERRO",
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
				validacaoSenha = false; // Caso a senha não possua Caracteres ou
										// Numeros
				JOptionPane.showMessageDialog(null, "A senha deve conter Caracteres '.,!#' ou Numeros '123' ", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return validacaoSenha;
	}

	public boolean camposValidos(String nome, String sobrenome, String email, String cpf) {
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

	public boolean campoGenero(boolean masc, boolean fem) {

		sexoValido = true;

		if ((!masc) & (!fem)) {
			sexoValido = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Gênero", "ERRO", JOptionPane.WARNING_MESSAGE);

		}
		return sexoValido;
	}
}
