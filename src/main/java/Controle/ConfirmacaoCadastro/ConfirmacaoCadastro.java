package Controle.ConfirmacaoCadastro;

import javax.servlet.http.HttpServletRequest;

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

	public boolean confirmaCadastro(boolean valida[],HttpServletRequest request) {
		int contV = 0;
		for (int i = 0; i < 7; i++) {
			if (valida[i] == true) {
				contV++;
				switch(i){
					case 0: request.setAttribute("erroSenha","true"); break;
					case 1: request.setAttribute("erroNome","true"); break;
					case 2: request.setAttribute("erroCpf","true"); break;
					case 3: request.setAttribute("erroEmail","true"); break;
					case 4: request.setAttribute("erroProfissao","true"); break;
					case 5: request.setAttribute("erroGenero","true"); break;
					case 6: request.setAttribute("erroData","true"); break;
				}
			}
			else{
				switch(i){
					case 0: request.setAttribute("erroSenha","false"); break;
					case 1: request.setAttribute("erroNome","false"); break;
					case 2: request.setAttribute("erroCpf","false"); break;
					case 3: request.setAttribute("erroEmail","false"); break;
					case 4: request.setAttribute("erroProfissao","false"); break;
					case 5: request.setAttribute("erroGenero","false"); break;
					case 6: request.setAttribute("erroData","false"); break;
				}
			}
		}
		
		if(contV == 7)
			return true;
		else
			return false;
	}
}
