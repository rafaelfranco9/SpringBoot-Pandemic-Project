package com.franco.PandemicMetrics.helpers;
import java.util.Comparator;
import java.util.List;

import com.franco.PandemicMetrics.model.*;

public class MuertesComparator implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		return o1.getLastCovidData().getDeaths().compareTo(o2.getLastCovidData().getDeaths()) * -1;
	}
	
}
