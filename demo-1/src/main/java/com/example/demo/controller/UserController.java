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

import com.example.demo.DTO.UsersDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UsersDTO> guardarUsuario(@RequestBody UsersDTO userDTO){
		return new ResponseEntity<>(userService.crearUsuario(userDTO),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<UsersDTO> listarUsuarios(){
		return userService.obtenerTodosLosUsuarios();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> verUsuario(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(userService.obtenerUsuarioPorId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsersDTO> actualizarUsuario(@RequestBody UsersDTO userDTO,@PathVariable(name = "id") long id){
		UsersDTO userRespuesta = userService.actualizarUser(userDTO, id);
		return new ResponseEntity<>(userRespuesta,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id") long id){
		userService.eliminarUsuario(id);
		return new ResponseEntity<>("Eliminada con exito",HttpStatus.OK);
	}
	
}
