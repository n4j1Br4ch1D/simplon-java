package com.stc.stc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stc.stc.exception.RecordNotFoundException;


public interface ServiceInterface <T> {
	List<T> getAll(Integer pageNo, Integer pageSize, String sortBy); //Array
	T getOne(Long id) throws RecordNotFoundException;
	T save(T obj) throws RecordNotFoundException;
	void delete(Long id) throws RecordNotFoundException;
}




