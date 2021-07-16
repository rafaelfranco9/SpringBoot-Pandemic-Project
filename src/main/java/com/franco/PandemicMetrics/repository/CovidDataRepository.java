package com.franco.PandemicMetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franco.PandemicMetrics.model.CovidData;

public interface CovidDataRepository extends JpaRepository<CovidData, Integer> {

}
