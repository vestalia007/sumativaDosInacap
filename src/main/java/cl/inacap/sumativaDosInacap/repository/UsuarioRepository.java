package cl.inacap.sumativaDosInacap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

	UsuarioEntity findByNombre(String nombre);
	void deleteByNombreAndPassword(String n, String p);
	
}
