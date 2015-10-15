package InterfaceGrafica;
import java.awt.event.*;
import java.util.Collections;
import java.awt.*;

import javax.swing.*;

import Controle.Controle;


public class TelaUsuario extends JFrame{
	
	private Controle controle;
	private JButton logOut;
	private JLabel opcoes;
	private JComboBox tamanhosCisto;
	private ButtonGroup radioGroup;
	private String[] tamCisto;
	private int tamanhoEscolhido;
	final int quantTamanhos = 20; //Apenas para demonstrar
	private Login_Usuario paginaLogin;
	
	public TelaUsuario(Controle controle){
		super("Tela usuario");
		this.controle = controle;
		this.setLayout(null);
		this.setLocation(500,200);
		this.setSize(300, 500);
		
		String espaco = "                ";
		JOptionPane.showMessageDialog(null, espaco+"          Login realizado! \n"+espaco+"    Tipo de Conta: Usuario","Usuario",JOptionPane.DEFAULT_OPTION);
		
		String[] tamCisto = new String[quantTamanhos];
		for (int i = 1; i <= quantTamanhos; i++) {
			tamCisto[i - 1] = String.format("%d mm", i);
		}
		
		JLabel opcoes = new JLabel("Tamanhos de cisto: ");
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
		tamanhosCisto.setBounds(10,60,100,40);
		add(tamanhosCisto);
		
		JButton logOut = new JButton("Sair");
		logOut.setBounds(110, 400, 80, 30);
		add(logOut);
		
		ButtonHandler handler = new ButtonHandler();
		
		logOut.addActionListener(handler);
	
		setVisible(true);
	}
	
	public class ButtonHandler implements ActionListener{ //classe interna que indica a ação de manipulação
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == logOut){	
				TelaUsuario.this.dispose();
				Login_Usuario paginaLogin = new Login_Usuario(controle); //Se o usuario solicitar para dar log out, o programa deve voltar para a tela de login					
			}
		}
	}
}

