package services;

import dao.TaskDao;
import model.Task;

public class TaskService {
	private TaskDao taskDao = new TaskDao();

	private Task task;
	
	
	
	public Boolean createTaskService(String name, String desc, String status, String tobeFinishedAtDate, String finishedAtDate, String category, int categoryId) {
	    Task task = new Task(name, desc, status, tobeFinishedAtDate, finishedAtDate, category, categoryId);

		if(taskDao.insert(task) != null) {
			return true;
		}
		return false;
	}
	
	
	public Boolean updateTaskService(int id, String name, String desc, String status, String tobeFinishedAtDate, String finishedAtDate, String category, int categoryId ) {

	    Task task = new Task(name, desc, status, tobeFinishedAtDate, finishedAtDate, category, categoryId);
		if(taskDao.update(id, task)) {
			return true;
		}
		return false;
	}
	
	
	public Boolean deleteTaskService(int id) {
		if(taskDao.delete(id)) {
			return true;
		}
		return false;
	}
	
	
}
