package com.franco.PandemicMetrics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "covid_data")
public class CovidData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer cases;
	
	@Column(nullable = false)
	private Integer recovered;
	
	@Column(nullable = false)
	private Integer deaths;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	@JsonBackReference
	private Country country;
	
	public CovidData() {
		cases = 0;
		recovered = 0;
		deaths = 0;
		date = new Date();
	}
	
	public CovidData(Integer cases, Integer recovered, Integer deaths, Date date) {
		this.cases = cases;
		this.recovered = recovered;
		this.deaths = deaths;
		this.date = date;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
