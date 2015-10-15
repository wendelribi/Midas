package Controle;
import javax.swing.*;

import InterfaceGrafica.Botao_Usuario;

/* Classe que chama que cria um objeto da classe Botao_Usuario para mostrar
 * a janela de opçoes para o usuario.
 */
public class Main {
	public static void main(String[] args) {
		
		// Faz com que o Swing se comporte no Mac OS da mesma maneira que se comporta no Windows
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Erro ao definir modo de compatibilidade com a plataforma MAC OS");
		}
		
		new Controle();
	}
}
