package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fechaRealizada", nullable = false)
	private Date fechaRealizada;
	@Column(name = "fechaEntrega", nullable = true)
	private Date fechaEntrega;
	@Column(name = "estado", nullable = false)
	private long estado;
	@Column(name = "cantidadesP",nullable=true)
	private long[] cantidadesP;
	@Column(name ="percioTotal",nullable=true)
	private long precioTotal;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "users_id",nullable=false,referencedColumnName="id")
	private Users users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "productos_id",nullable=false)
	private Productos productos;
	
	public Pedidos() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaRealizada() {
		return fechaRealizada;
	}

	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public long getEstado() {
		return estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	public long[] getCantidadesP() {
		return cantidadesP;
	}

	public void setCantidadesP(long[] cantidadesP) {
		this.cantidadesP = cantidadesP;
	}

	public long getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(long precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	
	
	
}
