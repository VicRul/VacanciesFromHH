package org.vicrul.vacancies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vicrul.vacancies.model.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

}
