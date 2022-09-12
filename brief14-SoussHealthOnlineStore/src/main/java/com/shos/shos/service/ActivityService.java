package com.shos.shos.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shos.shos.dto.ActivityDto;
import com.shos.shos.entity.Activity;
import com.shos.shos.exception.ResourceNotFoundException;
import com.shos.shos.repository.ActivityRepository;
import com.shos.shos.response.ActivityResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

	private ActivityRepository activityRepository;

	private ModelMapper mapper;

	public ActivityService(ActivityRepository activityRepository, ModelMapper mapper) {
		this.activityRepository = activityRepository;
		this.mapper = mapper;
	}

	public ActivityResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Activity> activitys;
		activitys = activityRepository.findAll(pageable);
		List<Activity> listOfActivitys = activitys.getContent();
		List<ActivityDto> activityContent = listOfActivitys.stream().map(activity -> mapToDTO(activity)).collect(Collectors.toList());
		ActivityResponse activityResponse = new ActivityResponse();
		activityResponse.setContent(activityContent);
		activityResponse.setPageNo(activitys.getNumber());
		activityResponse.setPageSize(activitys.getSize());
		activityResponse.setTotalElements(activitys.getTotalElements());
		activityResponse.setTotalPages(activitys.getTotalPages());
		activityResponse.setLast(activitys.isLast());
		return activityResponse;
	}

	public ActivityDto getOne(long id) {
		Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", id));
		return mapToDTO(activity);
	}

	public ActivityDto create(ActivityDto activityDto) {
		Activity activity = mapToEntity(activityDto);
		Activity newActivity = activityRepository.save(activity);
		ActivityDto activityResponse = mapToDTO(newActivity);
		return activityResponse;
	}

	public ActivityDto update(ActivityDto activityDto, long id) {
		Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", id));
		activity.setName(activityDto.getName());
		Activity updatedActivity = activityRepository.save(activity);
		return mapToDTO(updatedActivity);
	}

	public void delete(long id) {
		Activity activity = activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", id));
		activityRepository.delete(activity);
	}

	private ActivityDto mapToDTO(Activity activity) {
		ActivityDto activityDto = mapper.map(activity, ActivityDto.class);
		return activityDto;
	}

	private Activity mapToEntity(ActivityDto activityDto) {
		Activity activity = mapper.map(activityDto, Activity.class);
		return activity;
	}

}
