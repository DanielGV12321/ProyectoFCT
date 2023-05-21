package com.project.demo.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "imagen", nullable = false)
	private Blob imagenCategoria;

	public Categoria(int idCategoria, String name, Blob imagenCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.name = name;
		this.imagenCategoria = imagenCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getImagenCategoria() {
		return imagenCategoria;
	}

	public void setImagenCategoria(Blob imagenCategoria) {
		this.imagenCategoria = imagenCategoria;
	}

}
