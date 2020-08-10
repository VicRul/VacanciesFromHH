package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vicrul.vacancies.model.Category;
import org.vicrul.vacancies.model.City;
import org.vicrul.vacancies.model.Vacancy;
import org.vicrul.vacancies.repository.CategoryDAO;
import org.vicrul.vacancies.repository.CityDAO;
import org.vicrul.vacancies.repository.VacancyDAO;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.NoArgsConstructor;

@Transactional
@Service("VacancyService")
@NoArgsConstructor
public class VacancyServiceImpl implements VacancyService {

	@Autowired
	private VacancyDAO vacancyDao;

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private CityDAO cityDao;

	private ImportAPI importAPI;

	@Override
	public List<Vacancy> getAllVacancies() {
		return vacancyDao.getAllVacancies();
	}

	@Override
	public void updateVacancyList(long cityId, long categoryId) {

		if (!getAllVacancies().isEmpty()) {
			vacancyDao.removeAllVacancies();
		}
		
		City city = cityDao.findCity(cityId);
		Category category = categoryDao.findCategory(categoryId);

		importAPI = new ImportAPI();
		List<Vacancy> allVacancies = importAPI.getVacancies(cityId, categoryId);
		
		for (Vacancy vacancy : allVacancies) {
			vacancy.setCityId(city);
			vacancy.setCategoryId(category);
		}

		vacancyDao.saveVacancy(allVacancies);
	}

}
