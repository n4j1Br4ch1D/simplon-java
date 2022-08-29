package com.stc.stc.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.dto.AdminDto;
import com.stc.stc.entity.Admin;
import com.stc.stc.exception.ResourceNotFoundException;
import com.stc.stc.repository.AdminRepository;
import com.stc.stc.response.AdminResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

	private AdminRepository adminRepository;

	private ModelMapper mapper;

	public AdminService(AdminRepository adminRepository, ModelMapper mapper) {
		this.adminRepository = adminRepository;
		this.mapper = mapper;
	}

	public AdminResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Admin> admins;
		admins = adminRepository.findAll(pageable);
		List<Admin> listOfAdmins = admins.getContent();
		List<AdminDto> adminContent = listOfAdmins.stream().map(admin -> mapToDTO(admin)).collect(Collectors.toList());
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setContent(adminContent);
		adminResponse.setPageNo(admins.getNumber());
		adminResponse.setPageSize(admins.getSize());
		adminResponse.setTotalElements(admins.getTotalElements());
		adminResponse.setTotalPages(admins.getTotalPages());
		adminResponse.setLast(admins.isLast());
		return adminResponse;
	}

	public AdminDto getOne(long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
		return mapToDTO(admin);
	}

	public AdminDto create(AdminDto adminDto) {
		Admin admin = mapToEntity(adminDto);
		Admin newAdmin = adminRepository.save(admin);
		AdminDto adminResponse = mapToDTO(newAdmin);
		return adminResponse;
	}

	public AdminDto update(AdminDto adminDto, long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
		admin.setLevel(adminDto.getLevel());
		Admin updatedAdmin = adminRepository.save(admin);
		return mapToDTO(updatedAdmin);
	}

	public void delete(long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin", "id", id));
		adminRepository.delete(admin);
	}

	private AdminDto mapToDTO(Admin admin) {
		AdminDto adminDto = mapper.map(admin, AdminDto.class);
		return adminDto;
	}

	private Admin mapToEntity(AdminDto adminDto) {
		Admin admin = mapper.map(adminDto, Admin.class);
		return admin;
	}

}
