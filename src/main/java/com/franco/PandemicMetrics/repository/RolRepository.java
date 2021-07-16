package com.franco.PandemicMetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franco.PandemicMetrics.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	Rol findByName(String name);
}
