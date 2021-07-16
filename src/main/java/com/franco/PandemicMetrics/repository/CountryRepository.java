package com.franco.PandemicMetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franco.PandemicMetrics.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
