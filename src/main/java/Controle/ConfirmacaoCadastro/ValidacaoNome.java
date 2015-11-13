package Controle.ConfirmacaoCadastro;

public class ValidacaoNome {

	boolean validacaoNome, validacaoSobrenome;
	int i;

	public boolean CampoNome(String nome) {
		validacaoNome = true;

		int contL = 0;

		for (i = 0; i < nome.length(); i++) {

			if ((nome.charAt(i) >= 'A' && nome.charAt(i) <= 'Z') || (nome.charAt(i) >= 'a' && nome.charAt(i) <= 'z')) {
				contL++;
			}
		}

		if (contL != nome.length() || nome.length() < 3) {
			validacaoNome = false;
		}

		return validacaoNome;
	}

	public boolean CampoSobrenome(String sobrenome) {
		validacaoSobrenome = true;

		int contValidos = 0;

		for (i = 0; i < sobrenome.length(); i++) {

			if ((sobrenome.charAt(i) >= 'A' && sobrenome.charAt(i) <= 'Z')
					|| (sobrenome.charAt(i) >= 'a' && sobrenome.charAt(i) <= 'z' || sobrenome.charAt(i) == ' ')) {
				contValidos++;
			}
		}

		if (contValidos != sobrenome.length() || sobrenome.length() < 2) {
			validacaoSobrenome = false;
		}

		return validacaoSobrenome;
	}
}
