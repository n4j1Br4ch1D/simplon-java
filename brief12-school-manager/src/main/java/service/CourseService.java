package service;

import java.util.List;


import dao.CourseDao;
import entity.Course;

public class CourseService {

	private static CourseDao courseDao;

	public CourseService() {
		courseDao = new CourseDao();
	}

	public void persist(Course entity) {
		courseDao.persist(entity);
	}

	public void update(Course entity) {
		courseDao.update(entity);
	}

	public Course findById(int id) {
		Course course = courseDao.findById(id);
		return course;
	}

	public void delete(int id) {
			courseDao.delete(id);
	}

	public List<Course> findAll() {
		List<Course> courses = courseDao.findAll();
		return courses;
	}

}
