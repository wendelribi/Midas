package InterfaceGrafica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import Controle.Controle;

import java.util.*;

public class TelaAdmin extends JFrame {

	private Controle controle;
	private JPanel PanelPrincipal, panelesq, paneldir, panelEsquerdo, panelDireito, panelFundo;
	private JButton voltar, sair, salvar, adicionarButton, removerButton;
	private ArrayList<JButton> adicionar, remover;
	private JLabel usuario, mensagem;
	private Font FonteUsual;
	private ArrayList<JPanel> panelsEsq, panelsDir;
	private ArrayList<String> usuariosAceitos,usuariosNegados;
//	private ArrayList<Usuario> Usuario;
	private Toolkit toolkit;
	private Dimension screensize;
	private int num_usuarios,UsuariosSalvos,indice_aceito,indice_negado;
	
	public TelaAdmin(Controle controle/*ArrayList <Usuario> usuario*/) {
		super("Tela do Administrador");
		
		this.controle = controle;
		// Pegando o tamanho da tela
		toolkit = Toolkit.getDefaultToolkit();
		screensize = toolkit.getScreenSize();
		
		FonteUsual = new Font("Serif", Font.PLAIN, 14);
		panelEsquerdo = new JPanel();
		panelDireito = new JPanel();
		panelFundo = new JPanel();
		
		usuariosAceitos = new ArrayList<>();
		usuariosNegados = new ArrayList<>();
		
		panelsEsq = new ArrayList<>();
		panelsDir = new ArrayList<>();
		adicionar = new ArrayList<>();
		remover = new ArrayList<>();
	}
	
	//Metodo que escreve os paineis esquerdo e direito
	public void AdicionarUsuarioNoPanel(int i) {
		
		String string = "<html>" + "Augusto" + "da Silva" + "<br/>" + "022323232" + "<br/>" + "augusto@gmail.com"
				+ "<br/>" + "</html>";
//		String string = "<html>" + usuario.get(i,nome) +...
		usuario = new JLabel(string);
		usuario.setFont(FonteUsual);

		panelesq = new JPanel();
		panelesq.setBorder(BorderFactory.createLineBorder(Color.white));
		panelesq.setBackground(SystemColor.activeCaption);
		panelesq.add(usuario);
		panelsEsq.add(i, panelesq);

		adicionarButton = new JButton("Adicionar");
		adicionarButton.setBackground(SystemColor.controlHighlight);
		adicionar.add(i, adicionarButton);
		
//		Classe interna anonima para se o usuario apertar o botao adicionar, 
//		mudar a cor do painel esquerdo para verde, no indice certo.
		(adicionar.get(i)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(panelsEsq.get(i)).setBackground(Color.GREEN);
			}
		});

		removerButton = new JButton("Remover");
		removerButton.setBackground(SystemColor.controlShadow);

//		Classe interna anonima para se o usuario apertar o botao remover, 
//		mudar a cor do painel esquerdo para vermelho, no indice certo.
		remover.add(i, removerButton);
		(remover.get(i)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(panelsEsq.get(i)).setBackground(Color.RED);
			}
		});

		paneldir = new JPanel();
		paneldir.setLayout(new BorderLayout());
		paneldir.add(remover.get(i), BorderLayout.WEST);
		paneldir.add(adicionar.get(i), BorderLayout.EAST);
		panelsDir.add(i, paneldir);
	}
	
	//Metodo que adiciona o painel esquerda, com os dados dos usuarios
	public void AdicionarPanelEsquerdo(ArrayList<JPanel> panel) {
		for (JPanel panel_aux : panel) {
			panelEsquerdo.add(panel_aux);
		}
	}
	
	//Metodo que adiciona o painel direito com os botoes confirma e recusa
	public void AdicionarPanelDireito(ArrayList<JPanel> panel) {
		for (JPanel panel_aux : panel) {
			panelDireito.add(panel_aux);
		}
	}
	
	//Metodo que ajusta o tamanho da tela de acordo com o numero de usuarios
	public void AjustaTela(int num_usuarios) {
		String espaco = "                                       ";
		mensagem = new JLabel(espaco + "Lista de Usuarios Pendentes:");
		mensagem.setFont(FonteUsual);
		mensagem.setForeground(SystemColor.RED);
		
		if (num_usuarios <= 5) {

			this.setLayout(new BorderLayout());
			this.add(mensagem, BorderLayout.NORTH);
			this.add(panelEsquerdo, BorderLayout.CENTER);
			this.add(panelDireito, BorderLayout.EAST);
			this.add(panelFundo, BorderLayout.SOUTH);
			this.setBounds(screensize.width / 3, screensize.height / 6, 500, 200 + (num_usuarios * 50));
		} else {

			PanelPrincipal = new JPanel();
			PanelPrincipal.setLayout(new BorderLayout());
			PanelPrincipal.add(mensagem, BorderLayout.NORTH);
			PanelPrincipal.add(panelEsquerdo, BorderLayout.CENTER);
			PanelPrincipal.add(panelDireito, BorderLayout.EAST);
			PanelPrincipal.add(panelFundo, BorderLayout.SOUTH);
			this.setLayout(new BorderLayout());
			JScrollPane p = new JScrollPane(PanelPrincipal);
			this.add(p, BorderLayout.CENTER);
			this.add(panelFundo, BorderLayout.SOUTH);
			this.setBounds(screensize.width / 3, screensize.height / 30, 500, 700);
		}
	}
	
	//Metodo princial que imprimi a tela do Cadastros Pendentes para o Administrador
	public void DesenhaListaDeUsuarios() {
		
		num_usuarios = 0;
		// Adicionando aos JPanels os usuarios

		for (; num_usuarios < 10/*usuario.length()*/; num_usuarios++)
			AdicionarUsuarioNoPanel(num_usuarios);

		AdicionarPanelEsquerdo(panelsEsq);
		AdicionarPanelDireito(panelsDir);

		panelEsquerdo.setLayout(new BoxLayout(panelEsquerdo, BoxLayout.PAGE_AXIS));
		panelDireito.setLayout(new BoxLayout(panelDireito, BoxLayout.PAGE_AXIS));

		voltar = new JButton("Voltar");
		sair = new JButton("Sair da conta");
		salvar = new JButton("Salvar");

		panelFundo.setLayout(new FlowLayout());
		panelFundo.add(voltar);
		panelFundo.add(sair);
		panelFundo.add(salvar);
		
		AjustaTela(num_usuarios);
		this.setVisible(true);

		// Manipulador de evento de botao
		ButtonHandler handler = new ButtonHandler();
		salvar.addActionListener(handler);
		sair.addActionListener(handler);
		voltar.addActionListener(handler);
	}
	
	//Metodo que remove painel usuario da tela
	public void apagaUsuario(int i){
		panelEsquerdo.remove(panelsEsq.get(i));
		panelDireito.remove(panelsDir.get(i));
	}
	
	//Metodo que adiciona usuario na lista de Aceitos	
	public void UsuarioAceito(int indice_aceito,int i){
//		Pegar o indice "i" com a lista de pessoa, o cpf e passar a string de nomesACeitos
//		usuariosAceitos.add(indice_aceito,/*pessoa.get(i,cpf)*/);
	}
	
	//Metodo que adiciona usuario na lista de negados
	public void UsuarioNegado(int indice_negado,int i){
		
//		usuariosNegados.add(indice_negado,panelsDir.get(i),/*pessoa.get(i,cpf)*/);
	}
	
	//Metodo que retorna lista de usuarios Aceitos	
	public ArrayList<String> retornaUsuariosAceitos(){
		
		return usuariosAceitos;
	}
	//Metodo que retorna lista de usuarios Negados
	public ArrayList<String> retornaUsuariosNegados(){
		
		return usuariosNegados;
	}
	//Metodo que retorna mensagem de aviso na tela
	public void MensagemNenhumUsuario(){
		JOptionPane.showMessageDialog(null, "Nao ha usuarios pendentes","Aviso",JOptionPane.WARNING_MESSAGE);
	}
	/*
	 * Classe interna para tratamento de evento de botao para caso a pessoa
	 * clique em um dos botoes "sair" ou "salvar".
	 */
	private class ButtonHandler implements ActionListener {
		// Metodo que trata evento de botao
		public void actionPerformed(ActionEvent event) {

			// A pessoa clicou em "sair"
			if (event.getSource() == sair) {
				//Confirmacao se usuario deseja sair ou nao
				int escolha = JOptionPane.showOptionDialog(null, "Deseja realmente sair?", "Logout",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (escolha == JOptionPane.YES_OPTION) {
					TelaAdmin.this.dispose();
				}
				else{ //Nada acontece
				}
			}

			// A pessoa clicou em "salvar"
			if (event.getSource() == salvar) {
				
				//Quantidade de usuarios salvos, aceitos e negados
				
				UsuariosSalvos=0;
				indice_aceito=0;
				indice_negado=0;
				
				//Recebe a escolha do Administrador em aceitar
				//ou recusar os cadastros pendentes
				//Se ele aceitar o usuario(BackGround Verde), remove usuario 
				//da tela e adiciona ele a lista de aceitos.
				//Se ele recusar o usuario(BackGournd Vermelho), remove usuario
				//da tela e adciona ele a lista de negaods.
				for( int i=0;i<num_usuarios;i++){
					if((panelsEsq.get(i)).getBackground() == Color.GREEN){
						
						apagaUsuario(i);
						UsuarioAceito(indice_aceito,i);

												
						retornaUsuariosAceitos();
						UsuariosSalvos++;
						indice_aceito++;
					}
					else if((panelsEsq.get(i)).getBackground() == Color.RED){
						apagaUsuario(i);
						UsuarioNegado(indice_negado,i);
						retornaUsuariosNegados();
						UsuariosSalvos++;
						indice_negado++;
					}
				}
				
				TelaAdmin.this.repaint();
				
				//Mensagem caso o Administrador tenha Alterado
				//o Status de pendencia de todos os usuarios
				if(UsuariosSalvos==num_usuarios){
					MensagemNenhumUsuario();
				}
				
			}
			
			// O usuario clicou na opcao voltar
			// Ele sera redirecionado a tela Anterior, LoginUsuario
			if (event.getSource() == voltar) {
				
				TelaAdmin.this.dispose();
				Login_Usuario paginaLogin = new Login_Usuario(controle);
			}
		}
	}
}
