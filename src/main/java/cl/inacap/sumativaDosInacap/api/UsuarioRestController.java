package cl.inacap.sumativaDosInacap.api;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.inacap.sumativaDosInacap.dao.UsuarioDAO;
import cl.inacap.sumativaDosInacap.dto.UsuarioDTO;
import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuarioRestController {
	
	@Autowired
	private UsuarioDAO dao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@PostMapping("/login")
	public UsuarioDTO login(@RequestParam("nombre") String nombre, @RequestParam("password") String password) {
		String token =  getJWTToken(nombre);
		UsuarioDTO user = new UsuarioDTO();
		user.setNombre(nombre);
		user.setToken(token);
		return user;
	}
	
	@PostMapping("/create")
	public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO u) {
		
		UsuarioEntity actual = dao.buscar(u.getNombre());
		
		if( actual == null) {
			
			UsuarioEntity user = mapper.map(u, UsuarioEntity.class);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			user.setPassword(encoder.encode(user.getPassword()));
			
			dao.agregar(user);
			u.setPassword(null);
			
			return u;
		}else {
			return new UsuarioDTO();
		}		
	}
	
	
	
	private String getJWTToken(String username)
	{
		String secretKey = "sumativa2";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("admin");
		String token = Jwts
				.builder()
				.setId("InacapToken")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		
		return "Bearer " + token;
	}
	
}
