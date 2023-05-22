package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RolUser;

public interface RolRespository extends JpaRepository<RolUser, Long>{

	public Optional<RolUser> findByName(String name);
}
