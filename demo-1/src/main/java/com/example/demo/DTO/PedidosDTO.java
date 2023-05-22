package com.example.demo.DTO;

import java.util.Date;

import com.example.demo.entity.Users;

public class PedidosDTO {

	private long idPedidos;
	private Date fechaRealizada;
	private Date fechaEntrega;
	private long estado;
	private long[] cantidadesP;
	private long precioTotal;
	
	public PedidosDTO() {
		super();
	}
	
	

	public PedidosDTO(long idPedidos, Date fechaRealizada, Date fechaEntrega, long estado, long[] cantidadesP,
			long precioTotal) {
		super();
		this.idPedidos = idPedidos;
		this.fechaRealizada = fechaRealizada;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.cantidadesP = cantidadesP;
		this.precioTotal = precioTotal;
	}



	public long getIdPedidos() {
		return idPedidos;
	}
	public void setIdPedidos(long idPedidos) {
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
	
	
	
	
}
