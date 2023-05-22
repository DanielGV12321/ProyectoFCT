package com.example.demo.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.entity.Users;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepositorio;
	
	@Override
	public UsersDTO crearUsuario(UsersDTO userDTO) {	
		Users user=mapear(userDTO);
		Users nuevoUser= userRepositorio.save(user);
		UsersDTO userRespuesta=mapearDTO(nuevoUser);
		return userRespuesta;
	}
	
	private UsersDTO mapearDTO(Users user) {
		UsersDTO userDTO=modelMapper.map(user,UsersDTO.class);
		return userDTO;
	}
	private Users mapear(UsersDTO userDTO) {
		Users user=modelMapper.map(userDTO, Users.class);
		return user;
	}

	@Override
	public List<UsersDTO> obtenerTodosLosUsuarios() {
		List<Users> listaUsers=userRepositorio.findAll();
		return listaUsers.stream().map(user -> mapearDTO(user)).collect(Collectors.toList());
		
	}

	@Override
	public UsersDTO obtenerUsuarioPorId(long id) {
		Users user=userRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", id));
		return mapearDTO(user);
	}

	@Override
	public UsersDTO actualizarUser(UsersDTO usersDTO, long id) {
		Users user=userRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", id));
		user.setName(usersDTO.getName());
		user.setNick(usersDTO.getNick());
		user.setPassword(usersDTO.getPassword());
		user.setDireccion(usersDTO.getDireccion());
		user.setEmail(usersDTO.getEmail());
		user.setEnable(usersDTO.isEnable());
		Users userActualizado=userRepositorio.save(user);
		return mapearDTO(userActualizado);
	}

	@Override
	public void eliminarUsuario(long id) {
		Users user=userRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", id));
		userRepositorio.delete(user);
	}

}
