package com.example.demo.entity;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "categoria", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "imagen")
	private Blob imagenCategoria;
	
	@OneToMany(mappedBy = "categoria",cascade= CascadeType.ALL,orphanRemoval = true)
	private Set<Productos> productos=new HashSet<>();
	
	public Categoria() {
		super();
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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

	public Set<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}
	

}
