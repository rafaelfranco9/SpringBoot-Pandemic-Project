package com.franco.PandemicMetrics.model.dto;

public class UpdateCountryDTO {
	
	private Integer continentId;
	private Integer countryId;
	private Integer population;
	private Integer cases;
	private Integer recovered;
	private Integer deaths;
	private String image;
	
	
	public Integer getContinentId() {
		return continentId;
	}
	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getCases() {
		return cases;
	}
	public void setCases(Integer cases) {
		this.cases = cases;
	}
	public Integer getRecovered() {
		return recovered;
	}
	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
