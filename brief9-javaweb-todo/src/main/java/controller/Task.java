package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TaskService;

import java.io.IOException;

/**
 * Servlet implementation class Task
 */
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

TaskService taskService = new TaskService();


String action = request.getParameter("ACTION");

if("Create".equals(action)){

	int categoryId = Integer.parseInt(request.getParameter("category"));

	taskService.createTaskService(request.getParameter("title"), request.getParameter("description"), request.getParameter("status"), request.getParameter("deadline"),request.getParameter("category"), null, categoryId);

}

if("Update".equals(action)){

	int taskId = Integer.parseInt(request.getParameter("task-id"));

	int categoryId = Integer.parseInt(request.getParameter("category"));

	taskService.updateTaskService(taskId, request.getParameter("title"), request.getParameter("description"), request.getParameter("status"), request.getParameter("deadline"),request.getParameter("category"), null, categoryId);

}
if("Delete".equals(action)){
	int taskId = Integer.parseInt(request.getParameter("task-id"));
	taskService.deleteTaskService(taskId);
} 

response.sendRedirect("tasks.jsp");


	}

}
