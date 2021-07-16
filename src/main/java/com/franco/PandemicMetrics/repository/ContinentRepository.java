package com.franco.PandemicMetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franco.PandemicMetrics.model.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {
	Continent findByName(String name);
}
