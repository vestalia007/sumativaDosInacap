package cl.inacap.sumativaDosInacap.dao;

import java.util.List;

import cl.inacap.sumativaDosInacap.entity.ProductoEntity;

public interface ProductoDAO {
	public void agregar(ProductoEntity u);
	public void eliminar(int id);
	public void modificar(ProductoEntity u);
	public List<ProductoEntity> listar();
	public ProductoEntity buscar(int id);
	public ProductoEntity buscarNombre(String n);
	public ProductoEntity buscarCategoria(String c);
}
