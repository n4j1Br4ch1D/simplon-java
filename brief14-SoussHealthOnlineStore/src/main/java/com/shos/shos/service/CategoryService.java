package com.shos.shos.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shos.shos.dto.CategoryDto;
import com.shos.shos.entity.Category;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.exception.ResourceNotFoundException;
import com.shos.shos.repository.CategoryRepository;
import com.shos.shos.response.CategoryResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	private ModelMapper mapper;

	public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
		this.categoryRepository = categoryRepository;
		this.mapper = mapper;
	}

	public CategoryResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Category> categories;
//		if (role == null && isMale == null && enabled == null) {
			categories = categoryRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			categories = categoryRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			categories = categoryRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Category> listOfCategorys = categories.getContent();
		List<CategoryDto> categoryContent = listOfCategorys.stream().map(category -> mapToDTO(category)).collect(Collectors.toList());
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setContent(categoryContent);
		categoryResponse.setPageNo(categories.getNumber());
		categoryResponse.setPageSize(categories.getSize());
		categoryResponse.setTotalElements(categories.getTotalElements());
		categoryResponse.setTotalPages(categories.getTotalPages());
		categoryResponse.setLast(categories.isLast());
		return categoryResponse;
	}

	public CategoryDto getOne(long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		return mapToDTO(category);
	}

	public CategoryDto create(CategoryDto categoryDto) {
		Category category = mapToEntity(categoryDto);
		Category newCategory = categoryRepository.save(category);
		CategoryDto categoryResponse = mapToDTO(newCategory);
		return categoryResponse;
	}

	public CategoryDto update(CategoryDto categoryDto, long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
//		category.setFullName(categoryDto.getFullName());
		Category updatedCategory = categoryRepository.save(category);
		return mapToDTO(updatedCategory);
	}

	public void delete(long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		categoryRepository.delete(category);
	}

	private CategoryDto mapToDTO(Category category) {
		CategoryDto categoryDto = mapper.map(category, CategoryDto.class);
		return categoryDto;
	}

	private Category mapToEntity(CategoryDto categoryDto) {
		Category category = mapper.map(categoryDto, Category.class);
		return category;
	}

}
