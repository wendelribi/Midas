package Controle.ConfirmacaoCadastro;

public class ValidacaoNome {

	boolean validacaoNome;
	int i;

	public boolean CampoNome(String nome) {
		validacaoNome = true;

		if(nome != null){
			for (i = 0; i < nome.length(); i++) {
	
				if (nome.charAt(i) >= '0' && nome.charAt(i) <= '9') {
					validacaoNome = false;
				}
			}
			if (nome.length() < 3) {
				validacaoNome = false;
			}
		}
		else{
			validacaoNome = false;
		}

		return validacaoNome;
	}
}
