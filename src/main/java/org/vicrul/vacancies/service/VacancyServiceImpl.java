package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vicrul.vacancies.model.Category;
import org.vicrul.vacancies.model.City;
import org.vicrul.vacancies.model.Vacancy;
import org.vicrul.vacancies.repository.CategoryRepository;
import org.vicrul.vacancies.repository.CityRepository;
import org.vicrul.vacancies.repository.VacancyRepository;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService {

	private final VacancyRepository vacancyRepo;
	private final CategoryRepository categoryRepo;
	private final CityRepository cityRepo;
	private ImportAPI importAPI;

	@Override
	public List<Vacancy> getAllVacancies() {
		return vacancyRepo.findAll();
	}

	@Override
	public void updateVacancyList(long cityId, long categoryId) {
		
		City city = cityRepo.findById(cityId);
		Category category = categoryRepo.findById(categoryId);

		importAPI = new ImportAPI();
		List<Vacancy> allVacancies = importAPI.getVacancies(cityId, categoryId);
		
		for (Vacancy vacancy : allVacancies) {
			vacancy.setCityId(city);
			vacancy.setCategoryId(category);
		}

		vacancyRepo.saveAll(allVacancies);
	}

}
