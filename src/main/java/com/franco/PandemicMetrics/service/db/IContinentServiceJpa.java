package com.franco.PandemicMetrics.service.db;

import java.util.List;

import com.franco.PandemicMetrics.model.Continent;

public interface IContinentServiceJpa {
	
	List<Continent> getAll();
	void insert(Continent country);
	void update(Continent country);
	void delete(Integer id);
	
}
