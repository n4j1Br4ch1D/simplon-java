package com.stc.stc.service;

import java.util.List;

import org.springframework.data.domain.Page;


public interface ServiceInterface <T>{
	List<T> getAll();
	T getOne(long id);
	void save(T obj);
	void delete(long id);
}
