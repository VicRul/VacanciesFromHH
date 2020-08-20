package org.vicrul.vacancies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vicrul.vacancies.model.Category;
import org.vicrul.vacancies.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping
	public List<Category> findAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@PostMapping("/refresh")
	public void updateCategoriesList() {
		categoryService.updateCategoryList();
	}
}
