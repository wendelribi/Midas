package Controle.ConfirmacaoCadastro;

public class ValidacaoData {

	String comparacao;

	public void Confirmacao() {
		comparacao = "";
	}

	public boolean CampoData(String data) {

		boolean validacaodata = true;

		// Variaveis que contam o numero barras na data.
		int i, contbarra = 0, contNNum = 0, contNBarra = 0, contNumero = 0;

		for (i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '/') {
				contbarra++;
			}
			/* Vê se tem correto de numeros */
			if (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7 || i == 8 || i == 9) {
				if (data.charAt(i) >= '0' && data.charAt(i) <= '9')
					contNNum++;
			}	
			
			/* Vê se a barra está nas posicoes correta */
			if (i == 2 || i == 5) {
				if (data.charAt(i) == '/') {
					contNBarra++;
				}
			}
		}
		
		System.out.println(contNNum);
		

		if (contbarra != 2 || contNBarra != 2 || contNNum != 8 || data.length()!=10){
			validacaodata = false;
		}

		if (data.equals(comparacao)) {
			validacaodata = false;
		}

		return validacaodata;
	}
}