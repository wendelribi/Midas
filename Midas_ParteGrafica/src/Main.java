import javax.swing.*;

/* Classe que chama que cria um objeto da classe Botao_Usuario para mostrar
 * a janela de opçoes para o usuario.
 */
public class Main {
	public static void main(String[] args) {
		Botao_Usuario buttonFrame = new Botao_Usuario();
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(500,200);
		buttonFrame.setVisible(true);	
	}
}
