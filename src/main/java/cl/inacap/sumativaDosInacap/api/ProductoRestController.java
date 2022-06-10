package cl.inacap.sumativaDosInacap.api;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.sumativaDosInacap.dao.ProductoDAO;
import cl.inacap.sumativaDosInacap.dto.ProductoDTO;
import cl.inacap.sumativaDosInacap.entity.ProductoEntity;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	@Autowired
	private ProductoDAO dao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@PostMapping("/agregar")
	public ProductoDTO agregar(@RequestBody ProductoDTO p) {
		
		ProductoEntity pe = mapper.map(p, ProductoEntity.class);
		dao.agregar(pe);
		return p;
	}
	
	@GetMapping("/lista")
	public List<ProductoDTO> listar(){
		List<ProductoDTO> lista = new ArrayList<>();
		dao.listar().stream().forEach( p -> lista.add( mapper.map( p , ProductoDTO.class ) ) );
		return lista;
	}
	
	@GetMapping("/id/{id}")
	public ProductoDTO buscarId(@PathVariable("id") int id) {
		return mapper.map(dao.buscar(id), ProductoDTO.class);
	}
	
	@GetMapping("/nombre/{nombre}")
	public List<ProductoDTO> buscarNombre(@PathVariable("nombre") String nombre) {
		List<ProductoDTO> lista = new ArrayList<>();
		dao.buscarNombre(nombre).stream().forEach( p -> lista.add( mapper.map( p , ProductoDTO.class ) ) );
		return lista;
	}
	
	@GetMapping("/categoria/{categoria}")
	public List<ProductoDTO> buscarCategoria(@PathVariable("categoria") String categoria) {
		List<ProductoDTO> lista = new ArrayList<>();
		dao.buscarCategoria(categoria).stream().forEach( p -> lista.add( mapper.map( p , ProductoDTO.class ) ) );
		return lista;
	}
	
	@PutMapping("/actualizar")
	public ProductoDTO modificar(@RequestBody ProductoDTO p) {
		
		ProductoEntity pe = mapper.map(p, ProductoEntity.class);
		dao.modificar(pe);
		return p;
	}
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@PathVariable("id") int id) {
		dao.eliminar(id);
		if(dao.buscar(id)==null) {
			return true;
		}else {
			return false;
		}	
	}
}
