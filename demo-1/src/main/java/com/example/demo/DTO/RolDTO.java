package com.example.demo.DTO;

import java.sql.Blob;

public class RolDTO {

	
	private long rolId;
	private String name;
	private Blob imagen;
	public RolDTO() {
		super();
	}
	public RolDTO(long rolId, String name, Blob imagen) {
		super();
		this.rolId = rolId;
		this.name = name;
		this.imagen = imagen;
	}
	public long getRolId() {
		return rolId;
	}
	public void setRolId(long rolId) {
		this.rolId = rolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getImagen() {
		return imagen;
	}
	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}
	
	
	
}
