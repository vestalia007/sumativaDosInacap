package cl.inacap.sumativaDosInacap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inacap.sumativaDosInacap.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {

	ProductoEntity findByNombre(String nombre);
	ProductoEntity findByCategoria(String categoria);
}
