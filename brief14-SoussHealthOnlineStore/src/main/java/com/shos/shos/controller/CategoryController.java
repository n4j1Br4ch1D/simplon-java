package com.shos.shos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.shos.shos.config.AppConstants;
import com.shos.shos.dto.CategoryDto;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.response.CategoryResponse;
import com.shos.shos.service.CategoryService;
import com.shos.shos.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/categories")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
    @Operation(summary = "Get Categorys", description = "Get All Categorys & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public CategoryResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return categoryService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}

    @Operation(summary = "Get Category", description = "Get Category By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(categoryService.getOne(id));
	}

    @Operation(summary = "Create Category", description = "Create New Category REST API")
	@PostMapping
	public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<>(categoryService.create(categoryDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Category", description = "Update Category By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto, @PathVariable(name = "id") long id) {
		CategoryDto categoryResponse = categoryService.update(categoryDto, id);
		return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Category", description = "Delete Category By Id REST API")
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		categoryService.delete(id);
		return new ResponseEntity<>("Category entity deleted successfully.", HttpStatus.OK);
	}
        
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Role.class, new EnumConverter(Role.class));
    }
    
}
