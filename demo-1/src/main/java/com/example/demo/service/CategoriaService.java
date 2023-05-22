package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.entity.Categoria;

public interface CategoriaService {

	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);
	public List<CategoriaDTO> obtenerTodasLasCategorias();
	public CategoriaDTO obtenerCategoriasPorId(long id);
	public CategoriaDTO actualizarCategoria(CategoriaDTO categoriaDTO,long id);
	public CategoriaDTO obtenerCategoriaPorProducto(long idProducto);
	public void eliminaCategoria(long id);
}
