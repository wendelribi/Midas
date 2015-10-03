import java.awt.event.*;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;

// O codigo estÃ¡ bem seco, mas jÃ¡ podemos iniciar o modelo de como o usuario irÃ¡ se cadastrar para o MIDAS //

public class Usuario extends JFrame{

	private JTextField nome, sobrenome, email, cpf;
	private JLabel campoSenha,campoNascimento,campoProfissao;
	private JPasswordField senha, confirmacaoSenha;
	private JButton enviar;
	private JRadioButton sexo_masc,sexo_fem;
	private ButtonGroup radioGroup;
	private JComboBox box_data,box_mes,box_ano,box_profissao;
	private boolean valida = true,opcaoMasc = false,opcaoFem = false;
	private String nomeUsuario, sobrenomeUsuario,cpfUsuario,emailUsuario,profissaoUsuario;
	private String senhaUsuario, senhaValidacao;
	private final String[] profissao = {"Engenheiro","Medico","Professor" };   
	private int dataUsuario,mesUsuario,anoUsuario;
	final int tamData= 31,tamMes=12,tamAno=115;
	int i;
	private Font FonteUsual,FonteItalico;

	Confirmacao_Cadastro validaCadastro = new Confirmacao_Cadastro();

	public Usuario() {

		super("Cadastro de Usuario"); // utiliza construtor da super classe
										// JFrame
		this.setLayout(null);
		this.setLocation(530, 140); // Posicionar o layout no lugar desejado
									// da// tela
		
		FonteUsual = new Font("Serif",Font.PLAIN,14);
		FonteItalico = new Font("Serif",Font.ITALIC,14);
		
		String [] data = new String[tamData];
		String [] mes = new String[tamMes];
		String [] ano = new String[tamAno];
		
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
		nome.setBounds(10,20,170,40);
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
		cpf.setToolTipText("Insira aqui seu CPF"); // Dicas que aparecem ao
													// passar o mouse pelo campo
		cpf.setBounds(200,80,170,40);
		add(cpf);
		
		sexo_masc = new JRadioButton("Masculino", false); // cria botoes para
															// ambos os sexos
		sexo_fem = new JRadioButton("Feminino", false); // devemos adicionar
														// mais sexos?
		sexo_masc.setBounds(60,130,140,40);
		sexo_fem.setBounds(240,130,170,40);
		add(sexo_masc);
		add(sexo_fem);

		radioGroup = new ButtonGroup(); // cria relacionamento entre botoes, ou
										// seja, quando um esta clicado
		radioGroup.add(sexo_masc); // o outro estara desclicado
		radioGroup.add(sexo_fem);
		
		campoProfissao = new JLabel(" Profissão: ");
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
		box_data.addItemListener(new ItemListener(){
//			Trata evento de JComboBox
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					dataUsuario = Integer.parseInt(event.getItem().toString());
				}
			}
		});
		box_data.setBounds(210,240,43,40);
		add(box_data);

		box_mes = new JComboBox(mes); 
		box_mes.setMaximumRowCount(5);
//		Classe interna anônima
		box_mes.addItemListener(new ItemListener(){
//			Trata evento de JComboBox
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					mesUsuario = Integer.parseInt(event.getItem().toString());
				}
			}
		});
		box_mes.setBounds(255,240,43,40);
		add(box_mes);

		box_ano = new JComboBox(ano); 
		box_ano.setMaximumRowCount(5); 
		
		box_ano.addItemListener(new ItemListener(){
//			Trata evento de JComboBox
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					anoUsuario = Integer.parseInt(event.getItem().toString());
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
		senha.setToolTipText("A senha deve ter tamanho 6 e conter characteres e numeros"); // refazer com o pessoal de segurança
		add(senha);

		campoSenha = new JLabel("Confirmação Senha:");
		campoSenha.setBounds(55,350,150,40);
		add(campoSenha);
		confirmacaoSenha = new JPasswordField("****", 10);
		confirmacaoSenha.setBounds(210,350,160,35);
		confirmacaoSenha.setToolTipText("Repita a sua senha");
		add(confirmacaoSenha);
		
		enviar = new JButton("Enviar");
		enviar.setBounds(155,410,80,30);
		add(enviar);

		ButtonHandler handler = new ButtonHandler(); // cria o manipulador de
														// eventos
		enviar.addActionListener(handler); // cria uma escuta para o botao
		sexo_masc.addActionListener(handler); // enviar
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

		nome.addMouseListener(handler_mouse);
		sobrenome.addMouseListener(handler_mouse);
		email.addMouseListener(handler_mouse);
		cpf.addMouseListener(handler_mouse);
		senha.addMouseListener(handler_mouse);
		confirmacaoSenha.addMouseListener(handler_mouse);
	}
	
//	Classe interna que trata evento de teclado
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
	
	public class ButtonHandler implements ActionListener { // classe interna que
															// indica a aÃ§Ã£o
															// de manipulaÃ§Ã£o

		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sexo_masc || event.getSource() == sexo_fem){
				nome.setBackground(Color.WHITE);
				sobrenome.setBackground(Color.WHITE);
				email.setBackground(Color.WHITE);
				cpf.setBackground(Color.WHITE);
				senha.setBackground(Color.WHITE);
				confirmacaoSenha.setBackground(Color.WHITE);
			}
			if (event.getSource() == enviar) {
				
				nomeUsuario = nome.getText();
				sobrenomeUsuario = sobrenome.getText();
				emailUsuario = email.getText();
				cpfUsuario = cpf.getText();
				senhaUsuario = senha.getText();
				senhaValidacao = confirmacaoSenha.getText();
				opcaoMasc = sexo_masc.isSelected();
				opcaoFem = sexo_fem.isSelected();
				
				valida = validaCadastro.confirmacao(senhaUsuario, senhaValidacao, nomeUsuario, sobrenomeUsuario, emailUsuario,
						cpfUsuario,opcaoMasc,opcaoFem);
				
				if (valida) {
					Usuario.this.dispose();
					JOptionPane.showMessageDialog(null, "Cadastro enviado com sucesso");

				} else{
					JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro. Tente novamente", "Cadastro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	// Classe interna para tratamento de mouse
	private class ManipuladorMouse implements MouseListener {
		public void mousePressed(MouseEvent event) {
			
			nome.setBackground(Color.WHITE);
			sobrenome.setBackground(Color.WHITE);
			email.setBackground(Color.WHITE);
			cpf.setBackground(Color.WHITE);
			senha.setBackground(Color.WHITE);
			confirmacaoSenha.setBackground(Color.WHITE);
			
			// Apagar o que tem escrito nos campos
			if (event.getSource() == nome){
				nome.setText("");
				nome.setBackground(Color.LIGHT_GRAY);
				nome.setFont(FonteUsual);
			}
			else if (event.getSource() == sobrenome){
				sobrenome.setText("");
				sobrenome.setBackground(Color.LIGHT_GRAY);
				sobrenome.setFont(FonteUsual);
			}
			
			else if (event.getSource() == email){
				email.setText("");
				email.setBackground(Color.LIGHT_GRAY);
				email.setFont(FonteUsual);
			}
			else if (event.getSource() == cpf){
				cpf.setText("");
				cpf.setBackground(Color.LIGHT_GRAY);
				cpf.setFont(FonteUsual);
			}
			else if (event.getSource() == senha){
				senha.setText("");
				senha.setBackground(Color.LIGHT_GRAY);
				senha.setFont(FonteUsual);
			}
			else if (event.getSource() == confirmacaoSenha){
				confirmacaoSenha.setText("");
				confirmacaoSenha.setBackground(Color.LIGHT_GRAY);
				confirmacaoSenha.setFont(FonteUsual);
			}
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
			
		}

		public void mouseClicked(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}
	}
}
