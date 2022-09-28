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
import com.shos.shos.dto.ProductDto;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.response.ProductResponse;
import com.shos.shos.service.ProductService;
import com.shos.shos.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/products")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @Operation(summary = "Get Products", description = "Get All Products & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public ProductResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return productService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}

    @Operation(summary = "Get Product", description = "Get Product By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(productService.getOne(id));
	}

    @Operation(summary = "Create Product", description = "Create New Product REST API")
	@PostMapping
	public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto productDto) {
		return new ResponseEntity<>(productService.create(productDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Product", description = "Update Product By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@Valid @RequestBody ProductDto productDto, @PathVariable(name = "id") long id) {
		ProductDto productResponse = productService.update(productDto, id);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Product", description = "Delete Product By Id REST API")
//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		productService.delete(id);
		return new ResponseEntity<>("Product entity deleted successfully.", HttpStatus.OK);
	}
        
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Role.class, new EnumConverter(Role.class));
    }
    
}
