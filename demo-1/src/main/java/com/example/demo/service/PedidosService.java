package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.PedidosDTO;

public interface PedidosService {

	public PedidosDTO crearPedidos(long id,long idProducto,PedidosDTO pedidosDTO);
	public List<PedidosDTO> obtenerTodosLosPedidos();
	public PedidosDTO obtenerPedidosPorId(long id);
	public PedidosDTO actualizarPedido(PedidosDTO pedidosDTO,long id);
	public void eliminarServicio(long id);
}
