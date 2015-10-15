import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/* Classe que que mostra a janela (JFrame) com duas opções para o  
 * usuário escolher se já possui ou deseja solicitar cadastro. Essa escolha
 * é feita por meio de botoes (JButton). Essa classe é chamada pela classe Main.
 */

public class Botao_Usuario extends JFrame{
	private JButton possui_cadastro; //botao que seleciona se a pessoa possui cadastro
	private JButton nao_possui_cadastro;
	private JLabel selecione;
	private JOptionPane frame;
	
	public Botao_Usuario(){
		super("Opcoes de usuario");
		this.setLayout(null);
		this.setLocation(450,200);  //Posicionar o layout no lugar desejado da tela
		
	
		selecione = new JLabel("Selecione uma das opcoes:");
		selecione.setBounds(170, 20, 300, 30);
		add(selecione);
		
		
		possui_cadastro = new JButton("Ja Possuo cadastro");
		possui_cadastro.setBounds(40, 70, 200, 70);
		add(possui_cadastro);
		
		nao_possui_cadastro = new JButton("Requisitar cadastro");
		nao_possui_cadastro.setBounds(250, 70, 200, 70);
		add(nao_possui_cadastro);
		
		//	Manipulador de evento de botao
		ButtonHandler handler = new ButtonHandler();
		nao_possui_cadastro.addActionListener(handler);
		possui_cadastro.addActionListener(handler);
		
		JOptionPane telaInicial = new JOptionPane("          Bem-vindo ao MIDAS!");
		JDialog dialogoTela = telaInicial.createDialog(null,"Tela Inicial");
		dialogoTela.setLocation(600,200);
		dialogoTela.setSize(200,200);
		dialogoTela.setVisible(true);
	}
	
/*	Classe interna para tratamento de evento de botao para caso a pessoa clique 
 *  em um dos botoes "Ja possuo cadastro" ou "Requisitar cadastro.
 */
	private class ButtonHandler implements ActionListener{
//		Metodo que trata evento de botao
		public void actionPerformed(ActionEvent event){
//			A pessoa clicou em "Ja possuo cadastro"
			if(event.getSource() == possui_cadastro ){
				
//				Fecha a janela com as opcoes de ja possuir ou requisitar cadastro
				Botao_Usuario.this.dispose();				
				
//				Cria um frame da classe Login_Usuario, classe que mostra a janela de login do usuario
				Login_Usuario textFieldFrame = new Login_Usuario();
				textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				textFieldFrame.setSize(500,200);
				textFieldFrame.setVisible(true);
			}	
//			A pessoa clicou em "Requisitar cadastro"
			if(event.getSource() == nao_possui_cadastro ){

//				Fecha a janela com as opcoes de ja possuir ou requisitar cadastro
				Botao_Usuario.this.dispose();
				
//				Cria um frame da classe Cadastro_Usuario, classe que mostra a janela de cadastro
				Cadastro_Usuario frame = new Cadastro_Usuario(); 
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setSize(400,500); 
				frame.setVisible(true); 
			}
		}
	}
}
