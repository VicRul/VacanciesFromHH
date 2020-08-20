package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vicrul.vacancies.model.Region;
import org.vicrul.vacancies.repository.RegionRepository;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {

	private final RegionRepository regionRepo;
	private ImportAPI importAPI;
	
	@Override
	public List<Region> getAllRegions() {
		
		return regionRepo.findAll();
	}

	@Override
	public void updateRegionList() {

		importAPI = new ImportAPI();
		List<Region> allRegions = importAPI.getRegions();

		regionRepo.saveAll(allRegions);
	}
}
