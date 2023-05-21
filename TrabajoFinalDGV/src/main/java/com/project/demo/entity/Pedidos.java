package com.project.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedidos;
	@Column(name = "fechaRealizada", nullable = false)
	private Date fechaRealizada;
	@Column(name = "fechaEntrega", nullable = true)
	private Date fechaEntrega;
	@Column(name = "estado", nullable = false)
	private int estado;

	public Pedidos(int idPedidos, Date fechaRealizada, Date fechaEntrega, int estado) {
		super();
		this.idPedidos = idPedidos;
		this.fechaRealizada = fechaRealizada;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
	}

	public int getIdPedidos() {
		return idPedidos;
	}

	public void setIdPedidos(int idPedidos) {
		this.idPedidos = idPedidos;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
