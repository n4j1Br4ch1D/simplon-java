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
import com.shos.shos.dto.OrderDto;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.response.OrderResponse;
import com.shos.shos.service.OrderService;
import com.shos.shos.utils.EnumConverter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order Resources, CRUD Rest APIs")
//@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/orders")
@Validated
//@SecurityRequirement(name = "bearerAuth")
public class OrderController {

	@Autowired
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
    @Operation(summary = "Get Orders", description = "Get All Orders & Filter Them REST API") // security = @SecurityRequirement(name = "bearerAuth")

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public OrderResponse getAll(@RequestParam(required = false) FilterCond filterCond,
			@RequestParam(required = false) String role, @RequestParam(required = false) Boolean isMale,
			@RequestParam(required = false) Boolean enabled,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return orderService.getAll(pageNo, pageSize, sortBy, sortDir, filterCond, role, isMale, enabled);
	}

    @Operation(summary = "Get Order", description = "Get Order By Id REST API")
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDto> getOne(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(orderService.getOne(id));
	}

    @Operation(summary = "Create Order", description = "Create New Order REST API")
	@PostMapping
	public ResponseEntity<OrderDto> create(@Valid @RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(orderService.create(orderDto), HttpStatus.CREATED);
	}

    @Operation(summary = "Update Order", description = "Update Order By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<OrderDto> update(@Valid @RequestBody OrderDto orderDto, @PathVariable(name = "id") long id) {
		OrderDto orderResponse = orderService.update(orderDto, id);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

    @Operation(summary = "Delete Order", description = "Delete Order By Id REST API")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
		orderService.delete(id);
		return new ResponseEntity<>("Order entity deleted successfully.", HttpStatus.OK);
	}
        
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Role.class, new EnumConverter(Role.class));
    }
    
}
