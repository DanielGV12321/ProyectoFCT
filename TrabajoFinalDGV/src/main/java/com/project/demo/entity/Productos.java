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
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name = "precio", nullable = false)
	private double precio;
	@Column(name = "imagen", nullable = true)
	private Blob imagen;

	public Productos(int idProducto, String name, int cantidad, double precio, Blob imagen) {
		super();
		this.idProducto = idProducto;
		this.name = name;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
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

}
