package org.vicrul.vacancies.service;

import java.util.List;

import org.vicrul.vacancies.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();
	void updateCategoryList();
	Category getCategory(long categoryId);
}
