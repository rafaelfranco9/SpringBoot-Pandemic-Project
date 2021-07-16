package com.franco.PandemicMetrics.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = false)
//	@JoinColumn(name="continent_id",foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT),nullable = false)
	
	@ManyToOne
	@JoinColumn(name = "continent_id")
	@JsonBackReference	
	private Continent continent;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer population;
	
	@Column(nullable = false)
	private String flag_img = "default_flag.png";
	
	@Column(nullable = false)
	private Boolean hidden = false;
	
	@OneToMany(mappedBy = "country",cascade = {CascadeType.ALL},orphanRemoval = true)
	@JsonManagedReference
	private List<CovidData> pandemicData = new ArrayList<CovidData>();

	public Country() {}
	
	
	public Country(Continent continent, String name, Integer population, String flag_img, Boolean hidden) {
		this.continent = continent;
		this.name = name;
		this.population = population;
		this.flag_img = flag_img;
		this.hidden = hidden;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
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

	public String getFlag_img() {
		return flag_img;
	}

	public void setFlag_img(String flag_img) {
		this.flag_img = flag_img;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public List<CovidData> getPandemicData() {
		return pandemicData;
	}

	public void setPandemicData(List<CovidData> pandemicData) {
		this.pandemicData = pandemicData;
	}
	
	public void addPandemicData(CovidData data) {
		this.pandemicData.add(data);
	}
	
	public CovidData getLastCovidData() {
		
		if(this.pandemicData.size() > 0) {
			return this.pandemicData.get(this.pandemicData.size() - 1);
		}else {
			return null;
		}
	}
	
	public Double getCasesPorcentage() {
		
		return (getLastCovidData().getCases().doubleValue() / population.doubleValue()) * 100.0;
		
	}
	
	public Double getRecoveredPorcentage() {
		
		return (getLastCovidData().getRecovered().doubleValue() / population.doubleValue()) * 100.0;
		
	}

	public Double getDeathsPorcentage() {
		
		return (getLastCovidData().getDeaths().doubleValue() / population.doubleValue()) * 100.0;
		
	}
	
	
}
