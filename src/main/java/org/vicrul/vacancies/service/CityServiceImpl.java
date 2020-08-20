package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vicrul.vacancies.model.City;
import org.vicrul.vacancies.model.Region;
import org.vicrul.vacancies.repository.CityRepository;
import org.vicrul.vacancies.repository.RegionRepository;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepo;
	private final RegionRepository regionRepo;
	private ImportAPI importAPI;
	
	@Override
	public List<City> getAllCities() {
		return cityRepo.findAll();
	}

	@Override
	public void updateCityList(long regionId) {
		
		importAPI = new ImportAPI();
		List<City> allCities = importAPI.getCities(regionId);
		Region region = regionRepo.findById(regionId);
		
		for (City city : allCities) {
			city.setRegionId(region);
		}
		cityRepo.saveAll(allCities);
	}
}
