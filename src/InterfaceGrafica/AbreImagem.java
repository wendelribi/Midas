package InterfaceGrafica;
import java.awt.event.*;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AbreImagem extends JFrame{
	
	private BufferedImage imagemMamografia;
	private JLabel labelImagem;
	private JFrame frameImagem;
	private ImageIcon icone;
	
	public AbreImagem(){
		
		try{
			this.setTitle("Imagem Requisitada");
			//	Alterar o local da imagem.	
			this.imagemMamografia = ImageIO.read(new File("/Users/victordantas/Documents/UNB/quarto-sem/POO/workspace-teste/Exemplo.jpg"));
			Image emEscala = this.imagemMamografia.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	        icone = new ImageIcon(emEscala);
		}catch(IOException e){
			System.err.println("Nao foi possivel abrir a imagem!");
		}
		
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocation(500,200);
		
		labelImagem = new JLabel();
		labelImagem.setIcon(icone);
        this.add(labelImagem);
    	this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
