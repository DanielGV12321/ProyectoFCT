package com.example.demo.entity;

import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "productos", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "cantidad", nullable = false)
	private long cantidad;
	@Column(name = "precio", nullable = false)
	private double precio;
	@Column(name = "imagen", nullable = true)
	private Blob imagen;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "categoria_id",nullable=false,referencedColumnName="id")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "productos",cascade= CascadeType.ALL,orphanRemoval = true)
	private Set<Pedidos> pedidos=new HashSet<>();
	
	public Productos() {
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

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	

	
	

	
	
}
