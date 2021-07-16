package com.franco.PandemicMetrics.service.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.franco.PandemicMetrics.helpers.GeneralFunctions;
import com.franco.PandemicMetrics.model.Continent;
import com.franco.PandemicMetrics.model.Country;
import com.franco.PandemicMetrics.model.CovidData;
import com.franco.PandemicMetrics.model.dto.CountriesDataDTO;
import com.franco.PandemicMetrics.model.dto.DeleteCountryDTO;
import com.franco.PandemicMetrics.model.dto.NewCountryDTO;
import com.franco.PandemicMetrics.model.dto.UpdateCountryDTO;
import com.franco.PandemicMetrics.repository.ContinentRepository;
import com.franco.PandemicMetrics.repository.CountryRepository;

@Service
public class CountryServiceJpa implements ICountryServiceJpa {
	
	@Autowired
	ContinentRepository continentRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	Environment env;
	
	@Override
	public List<Country> getAll() {
		
		return countryRepository.findAll();
	}

	@Override
	public void insert(NewCountryDTO country){
		
		Optional<Continent> continent = continentRepository.findById(country.getContinentId());
		if(continent.isPresent()) {
			Country newCountry = new Country(continent.get(),country.getCountryName(),country.getPopulation(),country.getImage(),false);
			CovidData newCovidData = new CovidData(country.getCases(),country.getRecovered(),country.getDeaths(),new Date()); 
			newCovidData.setCountry(newCountry);
			newCountry.addPandemicData(newCovidData);
			countryRepository.save(newCountry);
		}
	
	}

	@Override
	public void update(UpdateCountryDTO country){
		
		Optional<Country> countryOptional = countryRepository.findById(country.getCountryId());
		Optional<Continent> continentOptional = continentRepository.findById(country.getContinentId());
		
		if(countryOptional.isPresent() && continentOptional.isPresent()) {
			Continent contientUpd = continentOptional.get();
			Country countryUpd = countryOptional.get();
			
			if(country.getImage() != null) { //cambiar a != null
				if(countryUpd.getFlag_img() != "default_image.png") {
					GeneralFunctions.deleteImage(env.getProperty("pandemicMetrics.routes.images"), countryUpd.getFlag_img());							
				}
				countryUpd.setFlag_img(country.getImage());
			}
			
			countryUpd.setContinent(contientUpd);
			countryUpd.setPopulation(country.getPopulation());
			
			CovidData lastPandemicData = countryUpd.getPandemicData().get(countryUpd.getPandemicData().size() - 1);
			if(!lastPandemicData.getCases().equals(country.getCases()) || !lastPandemicData.getRecovered().equals(country.getRecovered()) || !lastPandemicData.getDeaths().equals(country.getDeaths())) {
				CovidData newCovidData = new CovidData(country.getCases(),country.getRecovered(),country.getDeaths(),new Date());
				newCovidData.setCountry(countryUpd);
				countryUpd.addPandemicData(newCovidData);				
			}
			
			countryRepository.save(countryUpd);
			
		}
		
		
	}

	@Override
	public void delete(DeleteCountryDTO countryDTO){
		
		Optional<Country> countryOptional = countryRepository.findById(countryDTO.getCountryId());
		if(countryOptional.isPresent()) {
			Country country = countryOptional.get(); 
			
			if(!country.getFlag_img().equals("default_image.png")) {
				GeneralFunctions.deleteImage(env.getProperty("pandemicMetrics.routes.images"), country.getFlag_img());							
			}
			countryRepository.delete(country);
		}
		
	}
	
	public Country getById(Integer id) {
		Optional<Country> country = countryRepository.findById(id); 
		
		if(country.isPresent()) {
			return country.get();
		}
		
		return null;
	}
	
	public List<CountriesDataDTO> listCountriesData(){
		
		ArrayList<CountriesDataDTO> list = new ArrayList<CountriesDataDTO>();
		this.getAll().stream().forEach((country) -> {
			
			CountriesDataDTO dto = new CountriesDataDTO();
			dto.setId(country.getId());
			dto.setContinentId(country.getContinent().getId());
			dto.setName(country.getName());
			dto.setPopulation(country.getPopulation());
			dto.setPandemicData(country.getPandemicData().get(country.getPandemicData().size() - 1));
			list.add(dto);
			
		});
		
		return list;
	}
	
	public List<CovidData> getCountryData(Integer id){
		Optional<Country> country = countryRepository.findById(id); 
		
		if(country.isPresent()) {
			return country.get().getPandemicData();
		}else {
			return null;
		}
		
	}

}
