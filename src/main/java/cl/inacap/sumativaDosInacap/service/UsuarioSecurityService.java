package cl.inacap.sumativaDosInacap.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.inacap.sumativaDosInacap.dao.UsuarioDAO;
import cl.inacap.sumativaDosInacap.entity.UsuarioEntity;

@Service
public class UsuarioSecurityService  implements UserDetailsService{

	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioEntity u = dao.buscar(username);
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("admin"));
		UserDetails userDT = new User(u.getNombre(), u.getPassword(), roles);
		return userDT;
	}
}
