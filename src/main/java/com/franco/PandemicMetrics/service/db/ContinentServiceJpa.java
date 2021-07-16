package com.franco.PandemicMetrics.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franco.PandemicMetrics.model.Continent;
import com.franco.PandemicMetrics.repository.ContinentRepository;

@Service
public class ContinentServiceJpa implements IContinentServiceJpa {
	
	@Autowired
	ContinentRepository continentRepository;
	
	@Override
	public List<Continent> getAll() {
		return continentRepository.findAll();
	}

	@Override
	public void insert(Continent country) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Continent country) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
