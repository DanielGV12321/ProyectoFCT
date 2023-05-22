package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.UsersDTO;


public interface UserService {

	public UsersDTO crearUsuario(UsersDTO user);
	public List<UsersDTO> obtenerTodosLosUsuarios();
	public UsersDTO obtenerUsuarioPorId(long id);
	public UsersDTO actualizarUser(UsersDTO usersDTO,long id);
	public void eliminarUsuario(long id);
}
