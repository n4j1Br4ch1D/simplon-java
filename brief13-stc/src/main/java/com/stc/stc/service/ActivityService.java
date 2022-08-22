package com.stc.stc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.entity.Activity;
import com.stc.stc.repository.ActivityRepository;



@Service
public class ActivityService implements ServiceInterface <Activity>{

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> getAll() {
		return activityRepository.findAll();
	}
	
	@Override
	public Activity getOne(long id) {
		Optional<Activity> optional = activityRepository.findById(id);
		Activity activity = null;
		if (optional.isPresent()) {
			activity = optional.get();
		} else {
			throw new RuntimeException(" Activity not found for id :: " + id);
		}
		return activity;
	}
	
	
	@Override
	public void save(Activity activity) {
		this.activityRepository.save(activity);
	}


	@Override
	public void delete(long id) {
		this.activityRepository.deleteById(id);
	}
	
	

}
