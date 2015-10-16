package InterfaceGrafica;

import java.awt.event.*;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AbreImagem extends JFrame {

	private BufferedImage imagemMamografia;
	private JLabel labelImagem;
	private ImageIcon icone;
	private Toolkit toolkit;
	private Dimension screensize;

	public AbreImagem() {

		// Pegando o tamanho da tela
		toolkit = Toolkit.getDefaultToolkit();
		screensize = toolkit.getScreenSize();
		
		try {
			this.setTitle("Imagem Requisitada");
			// Alterar o local da imagem.
			this.imagemMamografia = ImageIO.read(new File("C:/Users/Iure/Documents/GitHub/Midas/Midas/mamografia.jpg"));
			icone = new ImageIcon(imagemMamografia);
		} catch (IOException e) {
			System.err.println("Nao foi possivel abrir a imagem!");
		}
		
		this.setLayout(new FlowLayout());
		this.setBounds(1,1,screensize.width,screensize.height-40);

		labelImagem = new JLabel();
		labelImagem.setIcon(icone);
		this.add(labelImagem);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
