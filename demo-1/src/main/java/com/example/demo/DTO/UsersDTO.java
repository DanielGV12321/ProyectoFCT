package com.example.demo.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.example.demo.entity.Pedidos;

public class UsersDTO {

	
	private long idUser;
	private String name;
	private String nick;
	private String password;
	private String dni;
	private String email;
	private String direccion;
	private boolean enable;
	
	public UsersDTO() {
		super();
	}
	public UsersDTO(long idUser, String name, String nick, String password, String dni, String email, String direccion,
			boolean enable) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.nick = nick;
		this.password = password;
		this.dni = dni;
		this.email = email;
		this.direccion = direccion;
		this.enable = enable;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
	
	
	
	
}
