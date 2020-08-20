package org.vicrul.vacancies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vicrul.vacancies.model.Region;
import org.vicrul.vacancies.service.RegionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionController {

	private final RegionService regionService;
	
	@GetMapping
	public List<Region> findAllRegions() {
		return regionService.getAllRegions();
	}
	
	@PostMapping("/refresh")
	public void updateRegionsList() {
		regionService.updateRegionList();
	}
}
