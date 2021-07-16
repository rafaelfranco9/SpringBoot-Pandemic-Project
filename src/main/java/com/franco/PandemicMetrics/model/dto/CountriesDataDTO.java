package com.franco.PandemicMetrics.model.dto;

import com.franco.PandemicMetrics.model.CovidData;

public class CountriesDataDTO {
	
	private Integer id;
	private Integer continentId;
	private String name;
	private Integer population;
	private CovidData pandemicData;
	
	
	public Integer getContinentId() {
		return continentId;
	}
	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public CovidData getPandemicData() {
		return pandemicData;
	}
	public void setPandemicData(CovidData pandemicData) {
		this.pandemicData = pandemicData;
	}
	
	
}
