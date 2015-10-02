import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

// O codigo est√° bem seco, mas j√° podemos iniciar o modelo de como o usuario ir√° se cadastrar para o MIDAS //

public class Usuario extends JFrame {

	private JTextField nome, sobrenome, email, cpf,profissao;
	private JLabel campoSenha,campoNascimento;
	private JPasswordField senha, confirmacaoSenha;
	private JButton enviar;
	private JRadioButton sexo_masc,sexo_fem;
	private ButtonGroup radioGroup;
	private JComboBox box_data,box_mes,box_ano;
	private boolean valida = true,opcaoMasc = false,opcaoFem = false;
	private String nomeUsuario, sobrenomeUsuario, cpfUsuario,emailUsuario;
	private String senhaUsuario, senhaValidacao;
	private int dataUsuario,mesUsuario,anoUsuario;
	final int tamData= 31,tamMes=12,tamAno=115;
	int i;
	private Font FonteUsual,FonteItalico;

	Confirmacao_Cadastro validaCadastro = new Confirmacao_Cadastro();

	public Usuario() {

		super("Cadastro de Usuario"); // utiliza construtor da super classe
										// JFrame
		setLayout(new FlowLayout()); // Configura o layout do frame (ainda n√£o
										// descobri como melhorar)
		this.setLocation(530, 240); // Posicionar o layout no lugar desejado
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
		add(nome);
		

		sobrenome = new JTextField("Ultimo Nome", 12);
		sobrenome.setFont(FonteItalico);
		sobrenome.setToolTipText("Insira aqui seu ultimo nome");
		add(sobrenome);
		

		email = new JTextField("Email", 12);
		email.setFont(FonteItalico);
		email.setToolTipText("Insira aqui seu email");
		add(email);
		

		cpf = new JTextField("CPF", 12);
		cpf.setFont(FonteItalico);
		cpf.setToolTipText("Insira aqui seu CPF"); // Dicas que aparecem ao
													// passar o mouse pelo campo
		add(cpf);
		
		profissao = new JTextField("\tProfiss„o", 20);
		profissao.setFont(FonteItalico);
		profissao.setToolTipText("Insira aqui sua profiss„o");
		add(profissao);
		
		sexo_masc = new JRadioButton("Masculino", false); // cria botoes para
															// ambos os sexos
		sexo_fem = new JRadioButton("Feminino", false); // devemos adicionar
														// mais sexos?
		add(sexo_masc);
		add(sexo_fem);

		radioGroup = new ButtonGroup(); // cria relacionamento entre botoes, ou
										// seja, quando um esta clicado
		radioGroup.add(sexo_masc); // o outro estara desclicado
		radioGroup.add(sexo_fem);
		
		
		
		campoNascimento = new JLabel(" Data de nascimento: ");
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

		add(box_data);

		box_mes = new JComboBox(mes); 
		box_mes.setMaximumRowCount(5);
//		Classe interna anÙnima
		box_mes.addItemListener(new ItemListener(){
//			Trata evento de JComboBox
			public void itemStateChanged (ItemEvent event){
//				determina o item selecionado
				if(event.getStateChange() == ItemEvent.SELECTED){
					mesUsuario = Integer.parseInt(event.getItem().toString());
				}
			}
		});
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
		add(box_ano);
		

		campoSenha = new JLabel("                 Senha:               ");
		add(campoSenha);
		senha = new JPasswordField("****", 10);
		senha.setToolTipText("A senha deve ter tamanho 6 e conter characteres e numeros"); // refazer com o pessoal de seguranÁa
		add(senha);

		campoSenha = new JLabel("    ConfirmaÁao Senha:   ");
		add(campoSenha);
		confirmacaoSenha = new JPasswordField("****", 10);
		confirmacaoSenha.setToolTipText("Repita a sua senha");
		add(confirmacaoSenha);
		
		enviar = new JButton("Enviar");
		add(enviar);

		ButtonHandler handler = new ButtonHandler(); // cria o manipulador de
														// eventos
		enviar.addActionListener(handler); // cria uma escuta para o botao
											// enviar

		// Manipulador de evento de mouse
		ManipuladorMouse handler_mouse = new ManipuladorMouse();

		nome.addMouseListener(handler_mouse);
		sobrenome.addMouseListener(handler_mouse);
		email.addMouseListener(handler_mouse);
		profissao.addMouseListener(handler_mouse);
		cpf.addMouseListener(handler_mouse);
		senha.addMouseListener(handler_mouse);
		confirmacaoSenha.addMouseListener(handler_mouse);
	}

	public class ButtonHandler implements ActionListener { // classe interna que
															// indica a a√ß√£o
															// de manipula√ß√£o

		public void actionPerformed(ActionEvent event) {

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
					JOptionPane.showMessageDialog(null, "N„o foi possÌvel realizar o cadastro. Tente novamente", "Cadastro",
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
			profissao.setBackground(Color.WHITE);
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
			else if(event.getSource() == profissao){
				profissao.setText("");
				profissao.setBackground(Color.LIGHT_GRAY);
				profissao.setFont(FonteUsual);
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
