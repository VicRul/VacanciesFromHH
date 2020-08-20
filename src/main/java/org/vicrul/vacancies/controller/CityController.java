package org.vicrul.vacancies.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vicrul.vacancies.model.City;
import org.vicrul.vacancies.service.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

	private final CityService cityService;
	
	@GetMapping
	public List<City> getAllCities() {
		return cityService.getAllCities();
	}
	
	@PostMapping("/{regionId}")
	public ResponseEntity<Void> upfateCitiesList(@PathVariable("regionId") long regionId) {
		cityService.updateCityList(regionId);
		return ResponseEntity.ok().build();
	}
}
