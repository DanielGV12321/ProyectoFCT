package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private String nombreRecurso;
	private String nombreCampo;
	private long valorResurso;
	
	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, long valorResurso) {
		super(String.format("%s no encontrado con : %s : %s", nombreRecurso,nombreCampo,valorResurso));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorResurso = valorResurso;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public long getValorResurso() {
		return valorResurso;
	}

	public void setValorResurso(long valorResurso) {
		this.valorResurso = valorResurso;
	}
	
	
}
