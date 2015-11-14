package Controle.ConfirmacaoCadastro;

public class ConfirmacaoCadastro {
	
	ValidacaoCpf cpfValido = new ValidacaoCpf();
	ValidacaoData dataValida = new ValidacaoData();
	ValidacaoEmail emailValido = new ValidacaoEmail();
	ValidacaoNome nomeValido = new ValidacaoNome();
	ValidacaoSenha senhaValida = new ValidacaoSenha();
	ValidacaoSexo sexoValido = new ValidacaoSexo();
	ValidacaoProfissao profissaoValida = new ValidacaoProfissao();
	
	public boolean[] confirmacao(String senha, String senha2, String nome, String data, String email, String cpf,
			char sexo, String profissao) {
		
		int i;

		boolean cadastrovalido[] = new boolean[7];

		// 0- SENHA 1- NOME 2- SOBRENOME 3- CPF 4- EMAIL 5- PROFISSAO 6- SEXO 7-
		// DATA

		// INCIALIZADO COMO TRUE
		for (i = 0; i < 7; i++) {
			cadastrovalido[i] = true;
		}

		cadastrovalido[0] = senhaValida.CampoSenha(senha, senha2);
		cadastrovalido[1] = nomeValido.CampoNome(nome);
		cadastrovalido[2] = cpfValido.CampoCpf(cpf);
		cadastrovalido[3] = emailValido.CampoEmail(email);
		cadastrovalido[4] = profissaoValida.CampoProfissao(profissao);
		cadastrovalido[5] = sexoValido.CampoSexo(sexo);
		cadastrovalido[6] = dataValida.CampoData(data);
		return cadastrovalido;
	}

	public boolean confirmaCadastro(boolean valida[]) {
		int contV = 0;
		for (int i = 0; i < 7; i++) {
			if (valida[i] == true) {
				contV++;
			}
			else{
				switch(i){
					case 0: System.err.println("Erro no campo senha"); break;
					case 1: System.err.println("Erro no campo nome"); break;
					case 2: System.err.println("Erro no campo cpf"); break;
					case 3: System.err.println("Erro no campo email"); break;
					case 4: System.err.println("Erro no campo profissao"); break;
					case 5: System.err.println("Erro no campo genero"); break;
					case 6: System.err.println("Erro no campo data de nascimento"); break;
				}
			}
		}
		if(contV == 7)
			return true;
		else
			return false;
	}
}
