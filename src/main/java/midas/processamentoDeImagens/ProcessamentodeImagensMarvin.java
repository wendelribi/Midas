package midas.processamentoDeImagens;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class ProcessamentodeImagensMarvin implements ProcessamentoDeImagens<MarvinImage>{
	private MarvinImagePlugin imagePlugin;
	private MarvinImage imgOut;
	
	public void detectarBordas(MarvinImage imagem) {
		imgOut = new MarvinImage(imagem.getWidth(), imagem.getHeight());
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.edgeDetector.jar");
        imagePlugin.process(imagem, imgOut);
        imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
        imagePlugin.process(imgOut, imgOut);
        MarvinImageIO.saveImage(imgOut, "src/main/resources/images/imagem_out.jpg" );
	}

	@Override
	public void prewitt(MarvinImage imagem) {
		imgOut = new MarvinImage(imagem.getWidth(), imagem.getHeight());
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.prewitt.jar");
        imagePlugin.process(imagem, imgOut);
        MarvinImageIO.saveImage(imgOut, "src/main/resources/images/imagem_out.jpg" );
	}

	@Override
	public void roberts(MarvinImage imagem) {
		imgOut = new MarvinImage(imagem.getWidth(), imagem.getHeight());
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.roberts.jar");
        imagePlugin.process(imagem, imgOut);
        MarvinImageIO.saveImage(imgOut, "src/main/resources/images/imagem_out.jpg" );		
	}

	@Override
	public void sobel(MarvinImage imagem) {
		imgOut = new MarvinImage(imagem.getWidth(), imagem.getHeight());
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.sobel.jar");
        imagePlugin.process(imagem, imgOut);
        MarvinImageIO.saveImage(imgOut, "src/main/resources/images/imagem_out.jpg" );		
	}

}
