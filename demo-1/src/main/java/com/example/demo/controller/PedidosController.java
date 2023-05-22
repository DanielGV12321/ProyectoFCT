package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PedidosDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.service.PedidosService;

@RestController
@RequestMapping("/api")
public class PedidosController {

	@Autowired
	private PedidosService pedidosService;
	
	@PostMapping("/users/{id}/productos/{idProducto}/pedidos")
	public ResponseEntity<PedidosDTO> guardarUsuario(@PathVariable(name = "id") long id,@PathVariable(name = "id") long idProducto,@RequestBody PedidosDTO pedidosDTO){
		return new ResponseEntity<>(pedidosService.crearPedidos(id,idProducto, pedidosDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("/pedidos")
	public List<PedidosDTO> listarPedidos(){
		return pedidosService.obtenerTodosLosPedidos();
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<PedidosDTO> verPedido(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(pedidosService.obtenerPedidosPorId(id));
	}
	
	@PutMapping("/pedidos/{id}")
	public ResponseEntity<PedidosDTO> actualizarPedido(@RequestBody PedidosDTO pedidosDTO,@PathVariable(name = "id") long id){
		PedidosDTO pedidosRespuesta=pedidosService.actualizarPedido(pedidosDTO, id);
		return new ResponseEntity<>(pedidosRespuesta,HttpStatus.OK);
	}
	
	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<String> eliminarPedido(@PathVariable(name = "id") long id){
		pedidosService.eliminarServicio(id);
		return new ResponseEntity<>("Eliminada con exito",HttpStatus.OK);
	}
}
