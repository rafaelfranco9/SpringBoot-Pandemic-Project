package com.franco.PandemicMetrics.service.app;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franco.PandemicMetrics.helpers.MuertesComparator;
import com.franco.PandemicMetrics.model.Country;
import com.franco.PandemicMetrics.service.db.ICountryServiceJpa;

@Service
public class WorldServiceImpl implements IWorldService {

	@Autowired
	ICountryServiceJpa countryServiceJpa;
	
	@Override
	public List<Country> topThreeCountries() {
		
		List<Country> list = countryServiceJpa.getAll();
		Collections.sort(list,new MuertesComparator());
		
		if(list.size() > 3) {
			List<Country> topThree = list.subList(0, 3);
			return topThree;
		}else {
			return list;
		}
	
	}

	@Override
	public List<Country> getAllCountries() {
		
		List<Country> list = countryServiceJpa.getAll();
		Collections.sort(list,new MuertesComparator());
		return list;
		
	}

}
