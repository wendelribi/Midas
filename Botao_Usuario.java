import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Botao_Usuario extends JFrame{
	private JButton possui_cadastro; //botao que seleciona se a pessoa possui cadastro
	private JButton nao_possui_cadastro;
	private JLabel selecione;
	private JOptionPane frame;
	
	public Botao_Usuario(){
		super("Opções de usuario");
		this.setLayout(null);
		this.setLocation(450,200); //Posicionar o layout no lugar desejado da tela
		
		selecione = new JLabel("Selecione uma das opções:");
		selecione.setBounds(170, 20, 300, 30);
		add(selecione);
		
		
		possui_cadastro = new JButton("Já Possuo cadastro");
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
	
//	Classe interna para tratamento de evento de botao
	private class ButtonHandler implements ActionListener{
//		trata evento de botao
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == possui_cadastro ){
				Botao_Usuario.this.dispose();				
				Login_Usuario textFieldFrame = new Login_Usuario();
				textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				textFieldFrame.setSize(500,180);
				textFieldFrame.setVisible(true);
			}	
			if(event.getSource() == nao_possui_cadastro ){
				Botao_Usuario.this.dispose();

				Usuario frame = new Usuario(); // cria um frame para Usuario
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fechar o programa ao fechar a janela
				frame.setSize(300,300); // tamanho da janela
				frame.setVisible(true); // ÃƒÂ© visivel
			}
		}
	}
}
