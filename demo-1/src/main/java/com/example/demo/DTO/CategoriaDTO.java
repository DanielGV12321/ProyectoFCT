package com.example.demo.DTO;

import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.Productos;

public class CategoriaDTO {

	private long idCategoria;
	private String name;
	private Blob imagen;
	
	public CategoriaDTO() {
		super();
	}
	
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
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
