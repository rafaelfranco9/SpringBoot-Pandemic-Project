package com.franco.PandemicMetrics.service.app;

import java.util.List;

import com.franco.PandemicMetrics.model.Country;

public interface IWorldService {
	
	List<Country> topThreeCountries();
	List<Country> getAllCountries();
}
