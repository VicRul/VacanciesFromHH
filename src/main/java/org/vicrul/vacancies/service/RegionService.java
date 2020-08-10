package org.vicrul.vacancies.service;

import java.util.List;

import org.vicrul.vacancies.model.Region;

public interface RegionService {

	List<Region> getAllRegions();
	void updateRegionList();
}
