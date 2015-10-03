import java.awt.*;
import java.awt.event.*;
import java.util.Collections;

import javax.swing.*;

public class Login_Usuario extends JFrame {
	
	private JLabel campoLogin,campoSenha;
	private JTextField Login;
	private JPasswordField Senha;
	private JButton fazerLogin; 
	private String senhaUsuario, loginUsuario;
	
	public Login_Usuario(){
		
		super("Login");
		this.setLayout(null);
		this.setLocation(500,200); //Posicionar o layout no lugar desejado da tela
		
		campoLogin = new JLabel("Login: ");
		campoLogin.setBounds(120,1,70,70);
		
		add(campoLogin);
		//Constroi o Login com 10 colunas
		Login = new JTextField("",13);
		Login.setBorder(BorderFactory.createLineBorder(Color.red));
		Login.setBounds(250,20,200,30);
		
		add(Login); //Adiciona Login1 ao JFrame
		Login.setToolTipText("Insira o seu login");
		
		campoSenha = new JLabel("Senha: ");
		campoSenha.setBounds(120,42,70,70);
		add(campoSenha);
		Senha = new JPasswordField("",10);
		Senha.setBorder(BorderFactory.createLineBorder(Color.gray));
		Senha.setBounds(250,60,200,30);
		add(Senha);
		Senha.setToolTipText("Insira a sua senha");
		
		fazerLogin = new JButton("Fazer Login");
		fazerLogin.setBounds(140,110,200,30);
		add(fazerLogin);
		
		//	Manipulador de evento de mouse
		ManipuladorMouse handler_mouse = new ManipuladorMouse(); 
		Senha.addMouseListener(handler_mouse);
		Login.addMouseListener(handler_mouse);
		
		// Manipulador de evento de botao
		ButtonHandler handler_botao = new ButtonHandler();
		fazerLogin.addActionListener(handler_botao);
		
//		Manipulador de teclado
		Login.addKeyListener( new myKeyListener() );
		Login.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		Senha.addKeyListener( new myKeyListener() );
		Senha.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,Collections.EMPTY_SET);
		   
	}	
	
//	Classe interna para tratamento de mouse
	private class ManipuladorMouse implements MouseListener{  
        public void mousePressed(MouseEvent event){  
//        	Apagar o que tem escrito nos campos
        	
            if(event.getSource() == Login){    
            	Login.setText("");
            	Login.setBorder(BorderFactory.createLineBorder(Color.red));
            	Senha.setBorder(BorderFactory.createLineBorder(Color.gray));
            }
            else if(event.getSource() == Senha){
            	Senha.setText("");
            	Login.setBorder(BorderFactory.createLineBorder(Color.gray));
            	Senha.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }   
         public void mouseEntered(MouseEvent event){
         }
         public void mouseExited(MouseEvent event){  
         }  
         public void mouseClicked(MouseEvent event){  
         }  
         public void mouseReleased(MouseEvent event){  
         }  
    }  
	
//	Classe interna que trata evento de teclado
	private class myKeyListener implements KeyListener { 
	      public void keyPressed( KeyEvent event ) {
	    	  if ( event.getKeyCode() == KeyEvent.VK_TAB ) {
	    		  if(event.getSource() == Login){
	    			  Login.setBorder(BorderFactory.createLineBorder(Color.gray));
	              	  Senha.setBorder(BorderFactory.createLineBorder(Color.red));
	              	  Senha.requestFocus();
	    		  }
	    	  }
	      }
	      public void keyTyped(KeyEvent event){}
	      public void keyReleased(KeyEvent event){}
	}
	
//	Classe interna para tratamento de evento de botao
	private class ButtonHandler implements ActionListener{
//		trata evento de botao
		public void actionPerformed(ActionEvent event){
			
			if(event.getSource() == fazerLogin ){
				Login_Usuario.this.dispose();
				loginUsuario = Login.getText();
				senhaUsuario = Senha.getText();
			}
		}
	}
}

