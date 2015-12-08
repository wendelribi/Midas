package Controle.ConfirmacaoCadastro;

public class ValidacaoNome {

	boolean validacaoNome;
	int i;

	public boolean CampoNome(String nome) {
		validacaoNome = true;

		int contL = 0;
		if(nome != null){
			for (i = 0; i < nome.length(); i++) {
	
				if ((nome.charAt(i) >= 'A' && nome.charAt(i) <= 'Z') || (nome.charAt(i) >= 'a' && nome.charAt(i) <= 'z') || (nome.charAt(i) == ' ')) {
					contL++;
				}
			}
			if (contL != nome.length() || nome.length() < 3) {
				validacaoNome = false;
			}
		}
		else{
			validacaoNome = false;
		}

		return validacaoNome;
	}
}
