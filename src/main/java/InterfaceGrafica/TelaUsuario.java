package InterfaceGrafica;
import java.awt.event.*;
import java.util.Collections;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import Controle.Controle;

public class TelaUsuario extends JFrame{
	
	private Controle controle;
	private JButton logOut,sair,abrirImagem;
	private JLabel opcoes;
	private JComboBox tamanhosCisto;
	private ButtonGroup radioGroup;
	private String[] tamCisto;
	private int tamanhoEscolhido;
	final int quantTamanhos = 20; //Apenas para demonstrar
	private Login_Usuario paginaLogin;
	private AbreImagem imagemMamografia;
	
	public TelaUsuario(Controle controle){
		super("Tela usuario");
		this.controle = controle;
		this.setLayout(null);
		this.setLocation(500,200);
		this.setSize(300, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		String espaco = "                ";
		JOptionPane.showMessageDialog(null, espaco+"          Login realizado! \n"+espaco+"    Tipo de Conta: Usuario","Usuario",JOptionPane.DEFAULT_OPTION);
		
		String[] tamCisto = new String[quantTamanhos];
		for (int i = 1; i <= quantTamanhos; i++) {
			tamCisto[i - 1] = String.format("%d", i);
		}
		
		JLabel opcoes = new JLabel("Tamanhos de cisto (mm): ");
		opcoes.setBounds(10, 10, 200, 60);
		add(opcoes);

		tamanhosCisto = new JComboBox(tamCisto);
		tamanhosCisto.setMaximumRowCount(5);
		tamanhosCisto.addItemListener(new ItemListener(){
			public void itemStateChanged (ItemEvent event){
				if(event.getStateChange() == ItemEvent.SELECTED){
					tamanhoEscolhido = Integer.parseInt(event.getItem().toString());
				
				}
			}
		});
		tamanhosCisto.setBounds(60,60,70,40);
		add(tamanhosCisto);
		
		logOut = new JButton("Deslogar");
		logOut.setBounds(30, 400, 100, 30);
		add(logOut);
		
		sair = new JButton("Sair");
		sair.setBounds(180, 400, 80, 30);
		add(sair);
		
		abrirImagem = new JButton("Abrir a imagem");
		abrirImagem.setBounds(80, 330, 150, 30);
		add(abrirImagem);
		
		ButtonHandler handler = new ButtonHandler();
		
		logOut.addActionListener(handler);
		sair.addActionListener(handler);
		abrirImagem.addActionListener(handler);
	
		setVisible(true);
	}
	
	public class ButtonHandler implements ActionListener{ //classe interna que indica a ação de manipulação
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == logOut){	
				TelaUsuario.this.dispose();
				paginaLogin = new Login_Usuario(controle); //Se o usuario solicitar para dar log out, o programa deve voltar para a tela de login					
			}
			if(event.getSource() == sair){
				TelaUsuario.this.dispose();
				System.exit(0);
			}
			if(event.getSource() == abrirImagem){
				//abre a imagem
				imagemMamografia = new AbreImagem();
			}
		}
	}
}

