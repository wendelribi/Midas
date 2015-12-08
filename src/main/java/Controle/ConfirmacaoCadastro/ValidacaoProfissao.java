package Controle.ConfirmacaoCadastro;

public class ValidacaoProfissao extends ValidacaoNome {
	
	boolean validacaoProfissao;
	
	public boolean CampoProfissao(String profissao) {
		validacaoProfissao = true;

		validacaoProfissao= CampoNome(profissao);
				
		return validacaoProfissao;
	}

}
