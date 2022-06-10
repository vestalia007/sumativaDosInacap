package cl.inacap.sumativaDosInacap.dao;

import java.util.List;

import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;

public interface UsuarioDAO {

	public void agregar(UsuarioEntity u);
	public void eliminar(int id);
	public void eliminar(String n, String p);
	public void modificar(UsuarioEntity u);
	public List<UsuarioEntity> listar();
	public UsuarioEntity buscar(int id);
	public UsuarioEntity buscar(String n);
}
