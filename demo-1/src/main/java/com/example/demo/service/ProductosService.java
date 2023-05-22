package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.ProductosDTO;

public interface ProductosService {

	public ProductosDTO crearProducto(long id,ProductosDTO productosDTO);
	public List<ProductosDTO> obtenerTodosLosProductos();
	public ProductosDTO obtenerProductoPorID(long id);
	public List<ProductosDTO> obtenerTodosPorId(long id);
	public ProductosDTO actualizarProducto(ProductosDTO productoDTO,long id);
	public void eliminarProducto(long id);
}
