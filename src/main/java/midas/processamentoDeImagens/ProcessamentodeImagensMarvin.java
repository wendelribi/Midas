package midas.processamentoDeImagens;

import java.awt.image.BufferedImage;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class ProcessamentodeImagensMarvin implements ProcessamentoDeImagens{
	private MarvinImagePlugin imagePlugin;
	private MarvinImage imgIn;
	private MarvinImage imgOut;
	
	public ProcessamentodeImagensMarvin() {	}

	public BufferedImage processa(BufferedImage imagem, Processamento processamento) {
		imgIn = new MarvinImage(imagem);
		imgOut = new MarvinImage(imagem);
		switch (processamento) {
		case BORDASCOMUM:
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.edgeDetector.jar");
			imagePlugin.process(imgIn, imgOut);
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
	        imagePlugin.process(imgOut, imgOut);
	        break;
			
		case PREWITT:
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.prewitt.jar");
	        imagePlugin.process(imgIn, imgOut);
	        break;

		case ROBERTS:
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.roberts.jar");
	        imagePlugin.process(imgIn, imgOut);
	        break;

		case SOBEL:
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.sobel.jar");
	        imagePlugin.process(imgIn, imgOut);
	        break;

		case NEGATIVO:
			imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
	        imagePlugin.process(imgIn, imgOut);
	        break;

		default:
			throw new RuntimeException("Metodo nao reconhecido!");

		}
		

        return imgOut.getBufferedImage();
	}

}
