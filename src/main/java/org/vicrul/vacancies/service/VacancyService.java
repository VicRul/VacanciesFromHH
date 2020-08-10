package org.vicrul.vacancies.service;

import java.util.List;

import org.vicrul.vacancies.model.Vacancy;

public interface VacancyService {

	public List<Vacancy> getAllVacancies();
	public void updateVacancyList(long cityId, long categoryId);
}
