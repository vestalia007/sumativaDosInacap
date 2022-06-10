package cl.inacap.sumativaDosInacap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inacap.sumativaDosInacap.dao.UsuarioDAO;
import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;
import cl.inacap.sumativaDosInacap.repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioDAO{
	
	@Autowired
	private UsuarioRepository repo;
	
	
	@Override
	public void agregar(UsuarioEntity u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void eliminar(String n, String p) {
		// TODO Auto-generated method stub
		repo.deleteByNombreAndPassword(n, p);
	}

	@Override
	public void modificar(UsuarioEntity u) {
		// TODO Auto-generated method stub
		repo.save(u);
	}

	@Override
	public List<UsuarioEntity> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UsuarioEntity buscar(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new UsuarioEntity());
	}

	@Override
	public UsuarioEntity buscar(String n) {
		// TODO Auto-generated method stub
		return repo.findByNombre(n);
	}
 
}
