package org.vicrul.vacancies.service;

import java.util.List;

import org.vicrul.vacancies.model.City;

public interface CityService {
	
	List<City> getAllCities();
	void updateCityList(long regionId);
}
