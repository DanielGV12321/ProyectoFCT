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

import com.example.demo.DTO.ProductosDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductosService;

@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	private ProductosService productosService;
	
	
	@PostMapping("/categoria/{id}/productos")
	public ResponseEntity<ProductosDTO> guardarUsuario(@PathVariable(name = "id") long id,@RequestBody ProductosDTO productoDTO){
		return new ResponseEntity<>(productosService.crearProducto(id,productoDTO),HttpStatus.CREATED);
	}
	
	@GetMapping("/productos")
	public List<ProductosDTO> listarProductos(){
		return productosService.obtenerTodosLosProductos();
	}
	
	@GetMapping("/categoria/{id}/productos")
	public List<ProductosDTO> listarProductosPorCategoria(@PathVariable(name = "id") long id){
		return productosService.obtenerTodosPorId(id);
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductosDTO> verProducto(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(productosService.obtenerProductoPorID(id));
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<ProductosDTO> actualizarProducto(@RequestBody ProductosDTO productoDTO,@PathVariable(name = "id") long id){
		ProductosDTO productoRespuesta=productosService.actualizarProducto(productoDTO, id);
		return new ResponseEntity<>(productoRespuesta,HttpStatus.OK);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<String> elimiarProducto(@PathVariable(name = "id") long id){
		productosService.eliminarProducto(id);
		return new ResponseEntity<>("Eliminada con exito",HttpStatus.OK);
	}
}
