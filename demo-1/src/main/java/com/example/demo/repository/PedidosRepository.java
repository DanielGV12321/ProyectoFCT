package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
