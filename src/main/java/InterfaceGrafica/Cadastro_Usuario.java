package InterfaceGrafica;

import java.awt.event.*;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;

import Controle.Controle;
import Controle.ConfirmacaoCadastro.ConfirmacaoCadastro;
import entidades.*;
/* 
 * Classe que mostra a janela com todos os campos para o usuário preencher e fazer
 * o seu cadastro. Verifica por meio de outras classes se todos os campos estão corretos
 * e informa ao usuario se foi possivel ou nao fazer o cadastro.
 */
public class Cadastro_Usuario extends JFrame{

	private JTextField nome, sobrenome, email, cpf;
	private JLabel campoSenha,campoNascimento,campoProfissao;
	private JPasswordField senha, confirmacaoSenha;
	private JButton enviar;
	private JRadioButton sexo_masc,sexo_fem;
	private ButtonGroup radioGroup;
	private JComboBox box_data,box_mes,box_ano,box_profissao;
	private boolean valida = true;
	private final String[] profissao = {"Estudante","Engenheiro","Medico","Professor" };   
	private String dataUsuario="01",mesUsuario="01",anoUsuario="1900";
	private String profissaoUsuario = "Estudante",dataNascimento;
	final int tamData= 31,tamMes=12,tamAno=115;
	int i;
	private Font FonteUsual,FonteItalico;
	private Controle controle; // Referencia para enviar as informações do novo usuário ao controle
	private Usuario usuario; // Armazena as informações do novo usuário

	ConfirmacaoCadastro validaCadastro = new ConfirmacaoCadastro();

	public Cadastro_Usuario(Controle controle) {

		super("Cadastro de Usuario"); // utiliza construtor da super classe
										// JFrame
		this.controle = controle;
		this.setLayout(null);
		this.setLocation(530, 140); // Posicionar o layout no lugar desejado
									// da tela
		
		
		FonteUsual = new Font("Serif",Font.PLAIN,14); //Definir uma fonte e tamanho das letras
		FonteItalico = new Font("Serif",Font.ITALIC,14);
		
		String [] data = new String[tamData];
		String [] mes = new String[tamMes];
		String [] ano = new String[tamAno];
		
		usuario = new Usuario();
		
//		Criando os campos data, mes e ano
		for(i=1;i<=31;i++){
			data[i-1] = String.format("%d",i);
		}
		for(i=1;i<=12;i++){
			mes[i-1] = String.format("%d", i);
		}
		for(i=1900;i<=2014;i++){
			ano[i-1900] = String.format("%d",i);
		}
		
		nome = new JTextField("Primeiro Nome", 12);
		nome.setFont(FonteItalico);
		nome.setToolTipText("Insira aqui seu primeiro nome"); // Dicas que aparecem quando o passar o mouse por cima
		nome.setBounds(10,20,170,40); // Definindo o tamanho do campo e o lugar que ficará no frame
		add(nome);

		sobrenome = new JTextField("Ultimo Nome", 12);
		sobrenome.setFont(FonteItalico);
		sobrenome.setToolTipText("Insira aqui seu ultimo nome");
		sobrenome.setBounds(200,20,170,40);
		add(sobrenome);
		
		email = new JTextField("Email", 12);
		email.setFont(FonteItalico);
		email.setToolTipText("Insira aqui seu email");
		email.setBounds(10,80,170,40);
		add(email);

		cpf = new JTextField("CPF", 12);
		cpf.setFont(FonteItalico);
		cpf.setToolTipText("Insira aqui seu CPF"); 
		cpf.setBounds(200,80,170,40);
		add(cpf);
		
		sexo_masc = new JRadioButton("Masculino", false); // cria botoes para															
		sexo_fem = new JRadioButton("Feminino", false); // ambos os sexos
		sexo_masc.setBounds(60,130,140,40);
		sexo_fem.setBounds(240,130,170,40);
		add(sexo_masc);
		add(sexo_fem);

		radioGroup = new ButtonGroup(); // cria relacionamento entre botoes, ou										
		radioGroup.add(sexo_masc); // seja, quando um esta clicado  
		radioGroup.add(sexo_fem); // o outro estara desclicado
		
		campoProfissao = new JLabel(" Profissao: ");
		campoProfissao.setBounds(80,180,170,40);
		add(campoProfissao);
		
		box_profissao = new JComboBox(profissao);
		box_profissao.setMaximumRowCount(3);
		box_profissao.addItemListener(new ItemListener(){
//			Trata evento de JComboBox 
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					profissaoUsuario = event.getItem().toString();
				}
			}
		});
		box_profissao.setBounds(210,180,150,40);
		add(box_profissao);
		
		
		campoNascimento = new JLabel(" Data de nascimento: ");
		campoNascimento.setBounds(50,240,170,40);
		add(campoNascimento);
		
		box_data = new JComboBox(data); 
		box_data.setMaximumRowCount(5);
//		Classe interna anonima
		box_data.addItemListener(new ItemListener(){
//			Trata evento de JComboBox para caso o usuario clique em uma das datas
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					dataUsuario = event.getItem().toString();
				}
			}
		});
		box_data.setBounds(210,240,43,40);
		add(box_data);

		box_mes = new JComboBox(mes); 
		box_mes.setMaximumRowCount(5);
//		Classe interna anonima
		box_mes.addItemListener(new ItemListener(){
//			Trata evento de JComboBox para caso o usuario clique em um dos meses
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					mesUsuario = event.getItem().toString();
				}
			}
		});
		box_mes.setBounds(255,240,43,40);
		add(box_mes);

		box_ano = new JComboBox(ano); 
		box_ano.setMaximumRowCount(5); 
//		Classe interna anonima
		box_ano.addItemListener(new ItemListener(){
//			Trata evento de JComboBox para caso o usuario clique em um dos anos
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					anoUsuario = event.getItem().toString();
				}
			}
		});
		box_ano.setBounds(300,240,60,40);
		add(box_ano);
		
		campoSenha = new JLabel("Senha:");
		campoSenha.setBounds(95,297,40,40);
		add(campoSenha);
		senha = new JPasswordField("****", 10);
		senha.setBounds(210,300,160,35);
		senha.setToolTipText("A senha deve ter tamanho 6 e conter characteres e numeros"); // refazer com o pessoal de seguranÃ§a
		add(senha);

		campoSenha = new JLabel("Confirmacao Senha:");
		campoSenha.setBounds(55,350,150,40);
		add(campoSenha);
		confirmacaoSenha = new JPasswordField("****", 10);
		confirmacaoSenha.setBounds(210,350,160,35);
		confirmacaoSenha.setToolTipText("Repita a sua senha");
		add(confirmacaoSenha);
		
		enviar = new JButton("Enviar");
		enviar.setBounds(155,410,80,30);
		add(enviar);

		// cria o manipulador de eventos de botao
		ButtonHandler handler = new ButtonHandler();
		// cria escutas para os botoes
		enviar.addActionListener(handler); 
		sexo_masc.addActionListener(handler); 
		sexo_fem.addActionListener(handler);	
		
//		Manipulador de evento de teclado (TAB)
		   nome.addKeyListener( new myKeyListener() );
		   nome.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		   sobrenome.addKeyListener( new myKeyListener() );
		   sobrenome.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		   email.addKeyListener( new myKeyListener() );
		   email.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		   cpf.addKeyListener( new myKeyListener() );
		   cpf.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		   senha.addKeyListener( new myKeyListener() );
		   senha.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);

		
		// Manipulador de evento de mouse
		ManipuladorMouse handler_mouse = new ManipuladorMouse();

//		Cria escutas para evento de mouse
		nome.addMouseListener(handler_mouse);
		sobrenome.addMouseListener(handler_mouse);
		email.addMouseListener(handler_mouse);
		cpf.addMouseListener(handler_mouse);
		senha.addMouseListener(handler_mouse);
		confirmacaoSenha.addMouseListener(handler_mouse);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400,500); 
		this.setVisible(true); 
	}
	
//	Classe interna que trata evento de teclado para caso o usuário apertar a tecla
//	TAB,vá para o próximo campo, limpe ele e deixe ele com a cor cinza.
	private class myKeyListener implements KeyListener { 
	      public void keyPressed( KeyEvent event ) {
	    
	    	  if ( event.getKeyCode() == KeyEvent.VK_TAB ) {
	    		  if(event.getSource() == nome){
	    			  nome.setBackground(Color.WHITE);
		    		  sobrenome.setText("");
		    		  sobrenome.setBackground(Color.LIGHT_GRAY);
		    		  sobrenome.setFont(FonteUsual);
		    		  sobrenome.requestFocus();
	    		  }
	    		  else if(event.getSource() == sobrenome){
	    			  sobrenome.setBackground(Color.WHITE);
		    		  email.setText("");
		    		  email.setBackground(Color.LIGHT_GRAY);
		    		  email.setFont(FonteUsual);
		    		  email.requestFocus();
	    		  }
	    		  else if(event.getSource() == email){
	    			  email.setBackground(Color.WHITE);
		    		  cpf.setText("");
		    		  cpf.setBackground(Color.LIGHT_GRAY);
		    		  cpf.setFont(FonteUsual);
		    		  cpf.requestFocus();
	    		  }
	    		  else if(event.getSource() == cpf){
	    			  cpf.setBackground(Color.WHITE);
		    		  senha.setText("");
		    		  senha.setBackground(Color.LIGHT_GRAY);
		    		  senha.setFont(FonteUsual);
		    		  senha.requestFocus();
	    		  }
	    		  else if(event.getSource() == senha){
	    			  senha.setBackground(Color.WHITE);
		    		  confirmacaoSenha.setText("");
		    		  confirmacaoSenha.setBackground(Color.LIGHT_GRAY);
		    		  confirmacaoSenha.setFont(FonteUsual);
		    		  confirmacaoSenha.requestFocus();
	    		  }
		      }

	      }
	      public void keyTyped(KeyEvent event){}
	      public void keyReleased(KeyEvent event){}
	}
	
//	Classe de tratamento de botao para caso o usuario selecione um dos generos,
//	pegar qual dos dois generos foi selecionado. E para caso o usuario aperte
//	em enviar pegar todos os campos e verificar por meio de outras classes se 
//	todos os campos são validos
	
	public class ButtonHandler implements ActionListener { 
		public void actionPerformed(ActionEvent event) {
//			O usuario selecionou Masculino ou Feminino
			if(event.getSource() == sexo_masc || event.getSource() == sexo_fem){
				nome.setBackground(Color.WHITE);
				sobrenome.setBackground(Color.WHITE);
				email.setBackground(Color.WHITE);
				cpf.setBackground(Color.WHITE);
				senha.setBackground(Color.WHITE);
				confirmacaoSenha.setBackground(Color.WHITE);
			}
			
//			O usuario apertou em enviar
			if (event.getSource() == enviar) {

				dataNascimento = dataUsuario+mesUsuario+anoUsuario;
				String Nome = nome.getText();
				String Sobrenome = sobrenome.getText();
				usuario.setNome(Nome + "" + Sobrenome);
				usuario.setEmail(email.getText());
				usuario.setCpf(cpf.getText());
				usuario.setSenha(senha.getText());
				usuario.setDataNascimento(dataNascimento);
				usuario.setEndereco("");//Corrigir
				usuario.setNivelDeAcesso(0);
				usuario.setProfissao(profissaoUsuario); 
				String senhaConfirmacao = confirmacaoSenha.getText();
				
				if(sexo_masc.isSelected()){
					usuario.setSexo('M');
				}
				else {
					usuario.setSexo('F');
				}
				
				valida = validaCadastro.confirmacao(usuario.getSenha(), senhaConfirmacao, Nome, Sobrenome, usuario.getEmail(),
						usuario.getCpf(), sexo_masc.isSelected(), sexo_fem.isSelected());	
				
//				Se a variavel booleana "valida", for true, entao o cadastro pode ser realizado
				if (valida) {
					Cadastro_Usuario.this.dispose();
					// Envia a novo cadastro e notifica se foi enviado com sucesso
					if(controle.enviarCadastro(usuario))
						JOptionPane.showMessageDialog(null, "Cadastro enviado com sucesso");
					else
						JOptionPane.showMessageDialog(null, "Falha ao enviar o cadastro");
				}

//				Se a variavel booleana "valida", for false, entao o cadastro nao pode ser realizado
			else{
					JOptionPane.showMessageDialog(null, "Nao foi possivel realizar o cadastro. Tente novamente", "Cadastro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	//	Classe interna para tratamento de mouse, para caso o usuario clicar em um
	//	dos campos, apagar o que tem no campo e ficar cinza no campo que ele está digitando. 
	private class ManipuladorMouse implements MouseListener {
		public void mousePressed(MouseEvent event) {
			
			nome.setBackground(Color.WHITE);
			sobrenome.setBackground(Color.WHITE);
			email.setBackground(Color.WHITE);
			cpf.setBackground(Color.WHITE);
			senha.setBackground(Color.WHITE);
			confirmacaoSenha.setBackground(Color.WHITE);
			
			// Apagar o que tem escrito no campo nome e deixar cinza
			if (event.getSource() == nome){
				nome.setText("");
				nome.setBackground(Color.LIGHT_GRAY);
				nome.setFont(FonteUsual);
			}
			// Apagar o que tem escrito no campo sobrenome e deixar cinza
			else if (event.getSource() == sobrenome){
				sobrenome.setText("");
				sobrenome.setBackground(Color.LIGHT_GRAY);
				sobrenome.setFont(FonteUsual);
			}
			// Apagar o que tem escrito no campo email e deixar cinza
			else if (event.getSource() == email){
				email.setText("");
				email.setBackground(Color.LIGHT_GRAY);
				email.setFont(FonteUsual);
			}
			// Apagar o que tem escrito no campo cpf e deixar cinza
			else if (event.getSource() == cpf){
				cpf.setText("");
				cpf.setBackground(Color.LIGHT_GRAY);
				cpf.setFont(FonteUsual);
			}
			// Apagar o que tem escrito no campo senha e deixar cinza
			else if (event.getSource() == senha){
				senha.setText("");
				senha.setBackground(Color.LIGHT_GRAY);
				senha.setFont(FonteUsual);
			}
			// Apagar o que tem escrito no campo confirmacaoSenha e deixar cinza
			else if (event.getSource() == confirmacaoSenha){
				confirmacaoSenha.setText("");
				confirmacaoSenha.setBackground(Color.LIGHT_GRAY);
				confirmacaoSenha.setFont(FonteUsual);
			}
		}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseClicked(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
	}
}