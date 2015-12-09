package Controle.ConfirmacaoCadastro;
import javax.swing.JOptionPane;
public class ValidacaoSenha {
	
	//Verifica as senhas 
	public boolean CampoSenha(String Senha1, String Senha2) {

		boolean validacaoSenha = true;
		int i, contadorDeLetras = 0;
		if (!Senha1.equals(Senha2) || Senha1.length() < 6) {
			validacaoSenha = false;
		} else {
			for (i = 0; i < Senha1.length(); i++) {
				if ((Senha1.charAt(i) >= 'A' && Senha1.charAt(i) <= 'Z')
						|| (Senha1.charAt(i) >= 'a' && Senha1.charAt(i) <= 'z')) {
					contadorDeLetras++;
				}
			}
			if (Senha1.length() == contadorDeLetras) {
				validacaoSenha = false;
			}
		}
		return validacaoSenha;
	}
}