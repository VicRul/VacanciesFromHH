package org.vicrul.vacancies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vicrul.vacancies.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	City findById(long cityId);
}
