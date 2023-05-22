package com.example.demo.DTO;

import java.sql.Blob;

import com.example.demo.entity.Categoria;

public class ProductosDTO {

	private long idProducto;
	private String name;
	private long cantidad;
	private double precio;
	private Blob imagen;
	
	public ProductosDTO() {
		super();
	}
	public ProductosDTO(long idProducto, String name, long cantidad, double precio, Blob imagen) {
		super();
		this.idProducto = idProducto;
		this.name = name;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
	}
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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
	
	
	
	
}
