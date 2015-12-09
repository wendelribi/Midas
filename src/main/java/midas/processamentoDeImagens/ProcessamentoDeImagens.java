package midas.processamentoDeImagens;

public interface ProcessamentoDeImagens<T> {
	public void detectarBordas(T imagem);
	public void prewitt(T imagem);
	public void roberts(T imagem);
	public void sobel(T imagem);

}
