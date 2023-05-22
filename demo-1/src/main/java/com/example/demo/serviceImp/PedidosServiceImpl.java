package com.example.demo.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PedidosDTO;
import com.example.demo.entity.Pedidos;
import com.example.demo.entity.Productos;
import com.example.demo.entity.Users;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PedidosRepository;
import com.example.demo.repository.ProductosRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PedidosService;

@Service
public class PedidosServiceImpl implements PedidosService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	@Autowired
	private PedidosRepository pedidosRepositorio;
	
	@Autowired
	private UserRepository userRepositorio;
	
	private PedidosDTO mapearDTO(Pedidos pedidos) {
		PedidosDTO pedidosDTO=modelMapper.map(pedidos, PedidosDTO.class);
		return pedidosDTO;
	}
	private Pedidos mapear(PedidosDTO pedidosDTO) {
		Pedidos pedidos=modelMapper.map(pedidosDTO, Pedidos.class);
		return pedidos;
	}
	
	@Override
	public PedidosDTO crearPedidos(long usuarioId,long productoId,PedidosDTO pedidosDTO) {
		Pedidos pedidos=mapear(pedidosDTO);
		Users user=userRepositorio.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "Id", usuarioId));
		Productos producto=productosRepository.findById(productoId).orElseThrow(() -> new ResourceNotFoundException("Producto", "Id", productoId));
		pedidos.setUsers(user);
		pedidos.setProductos(producto);
		Pedidos nuevoPedido=pedidosRepositorio.save(pedidos);
		return mapearDTO(nuevoPedido);
	}

	@Override
	public List<PedidosDTO> obtenerTodosLosPedidos() {
		List<Pedidos> listaPedidos=pedidosRepositorio.findAll();
		return listaPedidos.stream().map(pedidos -> mapearDTO(pedidos)).collect(Collectors.toList());
	}
	@Override
	public PedidosDTO obtenerPedidosPorId(long id) {
		Pedidos pedido=pedidosRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", "Id", id));
		return mapearDTO(pedido);
	}
	@Override
	public PedidosDTO actualizarPedido(PedidosDTO pedidosDTO, long id) {
		Pedidos pedido=pedidosRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", "Id", id));
		pedido.setFechaEntrega(pedidosDTO.getFechaEntrega());
		pedido.setEstado(pedidosDTO.getEstado());
		Pedidos pedidoActualizado=pedidosRepositorio.save(pedido);
		return mapearDTO(pedidoActualizado);
	}
	@Override
	public void eliminarServicio(long id) {
		Pedidos pedido=pedidosRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido", "Id", id));
		pedidosRepositorio.delete(pedido);
		
	}

}
