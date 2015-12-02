package midas.dao;

import java.util.List;

public interface GenericDAO<T, V> {
	public boolean inserir(T entidade);
	public boolean remover(V atributo);
	public T recuperar(V atributo);
	public List<T> recuperarTodos();
	public boolean atualizar(V atributo);
}
