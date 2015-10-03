import javax.swing.JOptionPane;

/*CLASSE RESPONSAVEL PELA VERIFICAÇÃO DO CAMPO CPF NA TELA DO USUÁRIO*/

public class ValidacaoCpf {
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}

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
				validacaoCpf = false; // Caso a senha não possua Caracteres ou
										// Numeros
				JOptionPane.showMessageDialog(null, "Erro no campo CPF, digite apenas numeros", "ERRO",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return validacaoCpf;
	}
}
