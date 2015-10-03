import javax.swing.JOptionPane;

public class ValidacaoEmail {
	
	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}

	public boolean emailValidoo(String email) {
		boolean validacaoEmail = true;
		
		int i, contA = 0, contP = 0,contL=0;// Variavel que conta o numero de pontos,
									// arrobas e letras.

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
		
		System.out.println(contL);

		if (contA != 1 || contP <= 0 || contL<=5) {
			validacaoEmail = false;
		}
		
		if (email.equals(comparacao) || email.equals("Email")) {
			validacaoEmail=false;
			JOptionPane.showMessageDialog(null, "Erro no campo Email", "ERRO", JOptionPane.WARNING_MESSAGE);
		}
		
		return validacaoEmail;
	}
}
