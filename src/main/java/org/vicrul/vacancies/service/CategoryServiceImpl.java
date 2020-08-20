package org.vicrul.vacancies.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vicrul.vacancies.model.Category;
import org.vicrul.vacancies.repository.CategoryRepository;
import org.vicrul.vacancies.util.ImportAPI;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepo;
	private ImportAPI importAPI;

	@Override
	public List<Category> getAllCategories() {

		return categoryRepo.findAll();
	}

	@Override
	public void updateCategoryList() {
		
		importAPI = new ImportAPI();
		List<Category> allCategories = importAPI.getCategories();
		categoryRepo.saveAll(allCategories);
	}

	@Override
	public Category getCategory(long categoryId) {
		return categoryRepo.findById(categoryId);
	}

}
