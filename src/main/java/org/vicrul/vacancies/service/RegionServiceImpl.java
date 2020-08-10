package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vicrul.vacancies.model.Region;
import org.vicrul.vacancies.repository.RegionDAO;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.NoArgsConstructor;

@Transactional
@Service("RegionService")
@NoArgsConstructor
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionDAO regionDao;
	
	private ImportAPI importAPI;
	
	@Override
	public List<Region> getAllRegions() {
		
		return regionDao.getAllRegions();
	}

	@Override
	public void updateRegionList() {

		if (!getAllRegions().isEmpty()) {
			regionDao.removeAllRegions();
		}

		importAPI = new ImportAPI();
		List<Region> allRegions = importAPI.getRegions();

		regionDao.saveRegions(allRegions);
	}
}
