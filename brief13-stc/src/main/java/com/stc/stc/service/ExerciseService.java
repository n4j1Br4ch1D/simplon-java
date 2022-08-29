package com.stc.stc.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stc.stc.dto.ExerciseDto;
import com.stc.stc.entity.Exercise;
import com.stc.stc.exception.ResourceNotFoundException;
import com.stc.stc.repository.ExerciseRepository;
import com.stc.stc.response.ExerciseResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

	private ExerciseRepository exerciseRepository;

	private ModelMapper mapper;

	public ExerciseService(ExerciseRepository exerciseRepository, ModelMapper mapper) {
		this.exerciseRepository = exerciseRepository;
		this.mapper = mapper;
	}

	public ExerciseResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Exercise> exercises;
		exercises = exerciseRepository.findAll(pageable);
		List<Exercise> listOfExercises = exercises.getContent();
		List<ExerciseDto> exerciseContent = listOfExercises.stream().map(exercise -> mapToDTO(exercise)).collect(Collectors.toList());
		ExerciseResponse exerciseResponse = new ExerciseResponse();
		exerciseResponse.setContent(exerciseContent);
		exerciseResponse.setPageNo(exercises.getNumber());
		exerciseResponse.setPageSize(exercises.getSize());
		exerciseResponse.setTotalElements(exercises.getTotalElements());
		exerciseResponse.setTotalPages(exercises.getTotalPages());
		exerciseResponse.setLast(exercises.isLast());
		return exerciseResponse;
	}

	public ExerciseDto getOne(long id) {
		Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", id));
		return mapToDTO(exercise);
	}

	public ExerciseDto create(ExerciseDto exerciseDto) {
		Exercise exercise = mapToEntity(exerciseDto);
		Exercise newExercise = exerciseRepository.save(exercise);
		ExerciseDto exerciseResponse = mapToDTO(newExercise);
		return exerciseResponse;
	}

	public ExerciseDto update(ExerciseDto exerciseDto, long id) {
		Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", id));
		exercise.setName(exerciseDto.getName());
		Exercise updatedExercise = exerciseRepository.save(exercise);
		return mapToDTO(updatedExercise);
	}

	public void delete(long id) {
		Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", id));
		exerciseRepository.delete(exercise);
	}

	private ExerciseDto mapToDTO(Exercise exercise) {
		ExerciseDto exerciseDto = mapper.map(exercise, ExerciseDto.class);
		return exerciseDto;
	}

	private Exercise mapToEntity(ExerciseDto exerciseDto) {
		Exercise exercise = mapper.map(exerciseDto, Exercise.class);
		return exercise;
	}

}
