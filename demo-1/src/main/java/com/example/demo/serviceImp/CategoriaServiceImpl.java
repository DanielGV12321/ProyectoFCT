package com.example.demo.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.entity.Categoria;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	private CategoriaDTO mapearDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO=modelMapper.map(categoria,CategoriaDTO.class);
		return categoriaDTO;
	}
	private Categoria mapear(CategoriaDTO categoriaDTO) {
		Categoria categoria=modelMapper.map(categoriaDTO,Categoria.class);
		return categoria;
	}
	
	@Override
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoria=mapear(categoriaDTO);
		Categoria nuevaCategoria=categoriaRepository.save(categoria);
		CategoriaDTO categoriaRespuesta=mapearDTO(nuevaCategoria);
		return categoriaRespuesta;
	}

	@Override
	public List<CategoriaDTO> obtenerTodasLasCategorias() {
		List<Categoria> listaCategorias=categoriaRepository.findAll();
		return listaCategorias.stream().map(categoria -> mapearDTO(categoria)).collect(Collectors.toList());
	}
	@Override
	public CategoriaDTO obtenerCategoriasPorId(long id) {
		Categoria categoria=categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria", "Id", id));
		return mapearDTO(categoria);
	}
	@Override
	public CategoriaDTO actualizarCategoria(CategoriaDTO categoriaDTO, long id) {
		Categoria categoria=categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria", "Id", id));
		categoria.setName(categoriaDTO.getName());
		categoria.setImagenCategoria(categoriaDTO.getImagen());
		Categoria categoriaActualizada=categoriaRepository.save(categoria);
		return mapearDTO(categoriaActualizada);
	}
	@Override
	public void eliminaCategoria(long id) {
		Categoria categoria=categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria", "Id", id));
		categoriaRepository.delete(categoria);
		
	}
	@Override
	public CategoriaDTO obtenerCategoriaPorProducto(long idProducto) {
		Categoria categoria=categoriaRepository.findByProductosId(idProducto);
		return mapearDTO(categoria);
	}

}
