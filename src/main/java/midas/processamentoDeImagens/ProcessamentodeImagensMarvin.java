package midas.processamentoDeImagens;

import marvin.image.MarvinImage;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class ProcessamentodeImagensMarvin implements ProcessamentoDeImagens<MarvinImage>{
	private MarvinImagePlugin imagePlugin;
	
	public void gradiente(MarvinImage imagem) {
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.grayGradient.jar");
        imagePlugin.process(imagem, imagem);
	}
	
}
