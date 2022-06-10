package cl.inacap.sumativaDosInacap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inacap.sumativaDosInacap.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {

	List<ProductoEntity> findByNombreContains(String nombre);
	List<ProductoEntity> findByCategoria(String categoria);
	//
}
