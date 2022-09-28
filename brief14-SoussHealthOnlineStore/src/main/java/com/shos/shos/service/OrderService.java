package com.shos.shos.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shos.shos.dto.OrderDto;
import com.shos.shos.entity.Order;
import com.shos.shos.enums.FilterCond;
import com.shos.shos.enums.Role;
import com.shos.shos.exception.ResourceNotFoundException;
import com.shos.shos.repository.OrderRepository;
import com.shos.shos.response.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private ModelMapper mapper;

	public OrderService(OrderRepository orderRepository, ModelMapper mapper) {
		this.orderRepository = orderRepository;
		this.mapper = mapper;
	}

	public OrderResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, FilterCond filterCond, String role,
			Boolean isMale, Boolean enabled) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Order> orders;
//		if (role == null && isMale == null && enabled == null) {
			orders = orderRepository.findAll(pageable);
//		} else if (filterCond != null && filterCond.equals("and")) {
//			orders = orderRepository.findByRoleContainingIgnoreCaseAndIsMaleAndEnabled(role, isMale, enabled, pageable);
//		} else {
//			orders = orderRepository.findByRoleContainingIgnoreCaseOrIsMaleOrEnabled(role, isMale, enabled, pageable);
//		}
		List<Order> listOfOrders = orders.getContent();
		List<OrderDto> orderContent = listOfOrders.stream().map(order -> mapToDTO(order)).collect(Collectors.toList());
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setContent(orderContent);
		orderResponse.setPageNo(orders.getNumber());
		orderResponse.setPageSize(orders.getSize());
		orderResponse.setTotalElements(orders.getTotalElements());
		orderResponse.setTotalPages(orders.getTotalPages());
		orderResponse.setLast(orders.isLast());
		return orderResponse;
	}

	public OrderDto getOne(long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
		return mapToDTO(order);
	}

	public OrderDto create(OrderDto orderDto) {
		Order order = mapToEntity(orderDto);
		Order newOrder = orderRepository.save(order);
		OrderDto orderResponse = mapToDTO(newOrder);
		return orderResponse;
	}

	public OrderDto update(OrderDto orderDto, long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
//		order.setFullName(orderDto.getFullName());
		Order updatedOrder = orderRepository.save(order);
		return mapToDTO(updatedOrder);
	}

	public void delete(long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
		orderRepository.delete(order);
	}

	private OrderDto mapToDTO(Order order) {
		OrderDto orderDto = mapper.map(order, OrderDto.class);
		return orderDto;
	}

	private Order mapToEntity(OrderDto orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		return order;
	}

}
