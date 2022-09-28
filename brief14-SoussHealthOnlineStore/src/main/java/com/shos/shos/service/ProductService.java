package com.shos.shos.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shos.shos.dto.ProductDto;
import com.shos.shos.entity.Product;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.exception.ResourceNotFoundException;
import com.shos.shos.repository.ProductRepository;
import com.shos.shos.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private ModelMapper mapper;

	public ProductService(ProductRepository productRepository, ModelMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	public ProductResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Product> products;
//		if (role == null && isMale == null && enabled == null) {
			products = productRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			products = productRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			products = productRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Product> listOfProducts = products.getContent();
		List<ProductDto> productContent = listOfProducts.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(productContent);
		productResponse.setPageNo(products.getNumber());
		productResponse.setPageSize(products.getSize());
		productResponse.setTotalElements(products.getTotalElements());
		productResponse.setTotalPages(products.getTotalPages());
		productResponse.setLast(products.isLast());
		return productResponse;
	}

	public ProductDto getOne(long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		return mapToDTO(product);
	}

	public ProductDto create(ProductDto productDto) {
		Product product = mapToEntity(productDto);
		Product newProduct = productRepository.save(product);
		ProductDto productResponse = mapToDTO(newProduct);
		return productResponse;
	}

	public ProductDto update(ProductDto productDto, long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
//		product.setFullName(productDto.getFullName());
		Product updatedProduct = productRepository.save(product);
		return mapToDTO(updatedProduct);
	}

	public void delete(long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepository.delete(product);
	}

	private ProductDto mapToDTO(Product product) {
		ProductDto productDto = mapper.map(product, ProductDto.class);
		return productDto;
	}

	private Product mapToEntity(ProductDto productDto) {
		Product product = mapper.map(productDto, Product.class);
		return product;
	}

}
