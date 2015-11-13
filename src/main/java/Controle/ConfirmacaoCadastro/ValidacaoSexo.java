package Controle.ConfirmacaoCadastro;

public class ValidacaoSexo {

	public boolean CampoSexo(char sexo) {

		if (sexo == 'M' || sexo == 'm' || sexo == 'F' || sexo == 'f') {
			return true;
		}
		return false;
	}
}
