package com.franco.PandemicMetrics.service.db;

import java.util.List;

import com.franco.PandemicMetrics.model.Country;
import com.franco.PandemicMetrics.model.dto.CountriesDataDTO;
import com.franco.PandemicMetrics.model.dto.DeleteCountryDTO;
import com.franco.PandemicMetrics.model.dto.NewCountryDTO;
import com.franco.PandemicMetrics.model.dto.UpdateCountryDTO;

public interface ICountryServiceJpa {
	
	List<Country> getAll();
	void insert(NewCountryDTO country);
	void update(UpdateCountryDTO country);
	void delete(DeleteCountryDTO id);
	Country getById(Integer id);
	List<CountriesDataDTO> listCountriesData();
}
