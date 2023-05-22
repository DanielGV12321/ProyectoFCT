package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long>{

	public List<Productos> findByCategoriaId(long id);
}
