import javax.swing.JOptionPane;

public class Confirmacao {
	boolean validacaoSenha, validacaoCampos, sexoValido, emailValido;
	String comparacao;
	int tamanhoCpf;

	public Confirmacao() {
		comparacao = "";
	}

	public boolean confirmacaoSenha(String Senha1, String Senha2) {
		validacaoSenha = true;
		if (Senha1.equals(comparacao) || Senha1.equals("****")) {
			validacaoSenha = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Senha", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		if (!(Senha1.equals(Senha2))) {

			validacaoSenha = false; // Caso as senhas sejam iguais, retorna true
			JOptionPane.showMessageDialog(null, "Erro no campo confirmação da senha", "ERRO",
					JOptionPane.WARNING_MESSAGE);
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
		if (email.equals(comparacao) || email.equals("Email") || !emailValido(email)) {
			validacaoCampos = false;
			JOptionPane.showMessageDialog(null, "Erro no campo Email", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		if (cpf.equals(comparacao) || cpf.equals("CPF") || ((tamanhoCpf = cpf.length()) != 11)) {
			validacaoCampos = false;
			JOptionPane.showMessageDialog(null, "Erro no campo CPF", "ERRO", JOptionPane.WARNING_MESSAGE);
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

	public boolean emailValido(String email) {
		boolean validacaoEmail = false;
		int i, contA = 0, contP = 0;// Variavel que conta o numero de pontos e
									// arrobas.

		for (i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				contA++;
			}
			if (email.charAt(i) == '.') {
				contP++;
			}
		}

		if (contA == 1 & contP >= 1) {
			validacaoEmail = true;
		}
		return validacaoEmail;
	}

}
