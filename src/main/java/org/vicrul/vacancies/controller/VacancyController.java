package org.vicrul.vacancies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vicrul.vacancies.model.Vacancy;
import org.vicrul.vacancies.service.VacancyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vacancies")
@AllArgsConstructor
public class VacancyController {

	private final VacancyService vacancyService;
	
	@GetMapping
	public List<Vacancy> findAllVacancies() {
		return vacancyService.getAllVacancies();
	}
	
	@PostMapping("/refresh")
	public void updateVacanciesList(long cityId, long categoryId) {
		vacancyService.updateVacancyList(cityId, categoryId);
	}
}
