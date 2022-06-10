package cl.inacap.sumativaDosInacap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.inacap.sumativaDosInacap.dao.ProductoDAO;
import cl.inacap.sumativaDosInacap.entity.ProductoEntity;
import cl.inacap.sumativaDosInacap.repository.ProductoRepository;

public class ProductoService implements ProductoDAO{

	@Autowired
	private ProductoRepository repo;
	@Override
	public void agregar(ProductoEntity u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void modificar(ProductoEntity u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public List<ProductoEntity> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ProductoEntity buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new ProductoEntity());
	}

	@Override
	public List<ProductoEntity> buscarNombre(String n) {
		// TODO Auto-generated method stub
		return repo.findByNombreContains(n);
	}

	@Override
	public List<ProductoEntity> buscarCategoria(String c) {
		// TODO Auto-generated method stub
		return repo.findByCategoria(c);
	}

}
