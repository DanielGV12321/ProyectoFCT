package com.project.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "rolusers", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class RolUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	@Column(name = "name", nullable = false)
	private String name;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
