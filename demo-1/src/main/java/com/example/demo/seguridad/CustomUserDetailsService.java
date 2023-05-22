package com.example.demo.seguridad;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RolUser;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		
		Users user=userRepository.findByNameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese email o usuario: " +usernameOrEmail));
		User nuevoUsuario=new User(user.getEmail(),user.getPassword(),mapearRoles(user.getRolUser()));
		System.out.println(nuevoUsuario.getUsername());
		return new User(user.getEmail(),user.getPassword(),mapearRoles(user.getRolUser()));
	}
	private Collection<? extends GrantedAuthority> mapearRoles(Set<RolUser>roles){
		return roles.stream().map(rol->new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
		
	}

	
}
