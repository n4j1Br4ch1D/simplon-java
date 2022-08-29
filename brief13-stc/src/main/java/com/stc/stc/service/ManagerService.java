package com.stc.stc.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.dto.ManagerDto;
import com.stc.stc.entity.Manager;
import com.stc.stc.exception.ResourceNotFoundException;
import com.stc.stc.repository.ManagerRepository;
import com.stc.stc.response.ManagerResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerService {

	private ManagerRepository managerRepository;

	private ModelMapper mapper;

	public ManagerService(ManagerRepository managerRepository, ModelMapper mapper) {
		this.managerRepository = managerRepository;
		this.mapper = mapper;
	}

	public ManagerResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Manager> managers;
		managers = managerRepository.findAll(pageable);
		List<Manager> listOfManagers = managers.getContent();
		List<ManagerDto> managerContent = listOfManagers.stream().map(manager -> mapToDTO(manager)).collect(Collectors.toList());
		ManagerResponse managerResponse = new ManagerResponse();
		managerResponse.setContent(managerContent);
		managerResponse.setPageNo(managers.getNumber());
		managerResponse.setPageSize(managers.getSize());
		managerResponse.setTotalElements(managers.getTotalElements());
		managerResponse.setTotalPages(managers.getTotalPages());
		managerResponse.setLast(managers.isLast());
		return managerResponse;
	}

	public ManagerDto getOne(long id) {
		Manager manager = managerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manager", "id", id));
		return mapToDTO(manager);
	}

	public ManagerDto create(ManagerDto managerDto) {
		Manager manager = mapToEntity(managerDto);
		Manager newManager = managerRepository.save(manager);
		ManagerDto managerResponse = mapToDTO(newManager);
		return managerResponse;
	}

	public ManagerDto update(ManagerDto managerDto, long id) {
		Manager manager = managerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manager", "id", id));
		manager.setDomain(managerDto.getDomain());
		Manager updatedManager = managerRepository.save(manager);
		return mapToDTO(updatedManager);
	}

	public void delete(long id) {
		Manager manager = managerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Manager", "id", id));
		managerRepository.delete(manager);
	}

	private ManagerDto mapToDTO(Manager manager) {
		ManagerDto managerDto = mapper.map(manager, ManagerDto.class);
		return managerDto;
	}

	private Manager mapToEntity(ManagerDto managerDto) {
		Manager manager = mapper.map(managerDto, Manager.class);
		return manager;
	}

}
