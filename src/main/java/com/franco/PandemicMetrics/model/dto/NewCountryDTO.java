package com.franco.PandemicMetrics.model.dto;

public class NewCountryDTO {
	
	private Integer continentId;
	private String countryName;
	private Integer population;
	private Integer cases;
	private Integer recovered;
	private Integer deaths;
	private String image = "default_image.png";
	

	public NewCountryDTO() {}
	
	public Integer getContinentId() {
		return continentId;
	}
	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
