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

import com.example.demo.DTO.CategoriaDTO;

import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> guardarUsuario(@RequestBody CategoriaDTO categoriaDTO){
		return new ResponseEntity<>(categoriaService.crearCategoria(categoriaDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<CategoriaDTO> listarCategorias(){
		return categoriaService.obtenerTodasLasCategorias();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> verCategoria(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(categoriaService.obtenerCategoriasPorId(id));
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<CategoriaDTO> verCategoriaPorProducto(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(categoriaService.obtenerCategoriaPorProducto(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> actualizarCategoria(@RequestBody CategoriaDTO categoriaDTO,@PathVariable(name = "id") long id){
		CategoriaDTO categoriaRespuesta=categoriaService.actualizarCategoria(categoriaDTO, id);
		return  new ResponseEntity<>(categoriaRespuesta,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable(name = "id") long id){
		categoriaService.eliminaCategoria(id);
		return new ResponseEntity<>("Eliminada con exito",HttpStatus.OK);
	}
}
