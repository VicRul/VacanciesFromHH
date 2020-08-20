package org.vicrul.vacancies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vicrul.vacancies.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findById(long categoryId);
}
