package midas.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import junit.framework.TestCase;
import midas.entidades.ImagemProcessada;
import midas.processamentoDeImagens.Processamento;
import midas.util.JPAUtil;

public class testeImagemProcessada extends TestCase {
	ImagemProcessada imagemProc;
	@Before
	public void setUp() {
		JPAUtil.comecarOperacoes();
		imagemProc  = new ImagemProcessada(Processamento.BORDASCOMUM, null, new MammogramDAO().recuperar((long) 13));
	}
	public void testInsereERecupera() {
		
		new ImagemProcessadaDAO().inserir(imagemProc);
		ImagemProcessada imagemProcRecuperada = new ImagemProcessadaDAO().recuperar(imagemProc.getId());
		assertTrue(imagemProc.equals(imagemProcRecuperada));
		
	}
	public void testListaPorIdMammogram() {
		
		List<ImagemProcessada> listaRecuperada = new ImagemProcessadaDAO().recuperarIdOriginal((long) 13);
		assertTrue(listaRecuperada != null);
		assertTrue(listaRecuperada.get(0) != null);
		
	}
	public void testListaTodos() {
		
		List<ImagemProcessada> listaRecuperada = new ImagemProcessadaDAO().recuperarTodos();
		assertTrue(listaRecuperada != null);
		assertTrue(listaRecuperada.get(0) != null);
	}
	public void testDeleta() {
		assertTrue(new ImagemProcessadaDAO().remover(new ImagemProcessadaDAO().recuperar(imagemProc.getId())));
	}
	@After
	public void finalizar() {
		JPAUtil.comecarOperacoes();
	}
}
