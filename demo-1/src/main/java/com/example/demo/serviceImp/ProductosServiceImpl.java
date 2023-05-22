package com.example.demo.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductosDTO;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Productos;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProductosRepository;
import com.example.demo.service.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	private ProductosDTO mapearDTO(Productos producto) {
		ProductosDTO productoDTO=modelMapper.map(producto,ProductosDTO.class);
		return productoDTO;
	}
	
	private Productos mapear(ProductosDTO productosDTO) {
		Productos producto=modelMapper.map(productosDTO, Productos.class);
		return producto;
	}
	
	@Override
	public ProductosDTO crearProducto(long categoriaId,ProductosDTO productosDTO) {
		Productos producto=mapear(productosDTO);
		Categoria categoria=categoriaRepository.findById(categoriaId).orElseThrow(() -> new ResourceNotFoundException("Categoria", "Id", categoriaId));
		producto.setCategoria(categoria);
		Productos nuevoProducto=productosRepository.save(producto);
		return mapearDTO(nuevoProducto);
	}

	@Override
	public List<ProductosDTO> obtenerTodosLosProductos() {
		List<Productos> listaProductos=productosRepository.findAll();
		return listaProductos.stream().map(producto->mapearDTO(producto)).collect(Collectors.toList());
	}

	@Override
	public ProductosDTO obtenerProductoPorID(long id) {
		Productos producto=productosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto", "Id", id));
		return mapearDTO(producto);
	}

	@Override
	public ProductosDTO actualizarProducto(ProductosDTO productosDTO, long id) {
		Productos producto=productosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto", "Id", id));
		producto.setName(productosDTO.getName());
		producto.setCantidad(productosDTO.getCantidad());
		producto.setImagen(productosDTO.getImagen());
		producto.setPrecio(productosDTO.getPrecio());
		Productos productoActualizado=productosRepository.save(producto);
		return mapearDTO(productoActualizado);
	}

	@Override
	public void eliminarProducto(long id) {
		Productos producto=productosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto", "Id", id));
		productosRepository.delete(producto);
	}

	@Override
	public List<ProductosDTO> obtenerTodosPorId(long id) {
		List<Productos> productos=productosRepository.findByCategoriaId(id);
		return productos.stream().map(producto->mapearDTO(producto)).collect(Collectors.toList());
	}

}
