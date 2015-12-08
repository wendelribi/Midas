package Controle.ConfirmacaoCadastro;

public class ValidacaoSexo {

	public boolean CampoSexo(char sexo) {

		if (sexo == 'm' || sexo == 'f') {
			return true;
		}
		return false;
	}
}
