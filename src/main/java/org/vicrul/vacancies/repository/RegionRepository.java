package org.vicrul.vacancies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vicrul.vacancies.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	Region findById(long regionId);
}
