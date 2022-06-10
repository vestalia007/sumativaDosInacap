package cl.inacap.sumativaDosInacap.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.sumativaDosInacap.dao.ProductoDAO;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {
	@Autowired
	private ProductoDAO dao;
	
	private ModelMapper mapper = new ModelMapper();
	
	/*
	@GetMapping("/lista")
	public List<ProductosDTO> listar(){
		
	}
	 */
}
