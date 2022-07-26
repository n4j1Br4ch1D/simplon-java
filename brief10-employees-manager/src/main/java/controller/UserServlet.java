package controller;

//import repository.UserRepository;

import java.io.IOException;
import java.io.PrintWriter;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.UserRepository;
import service.UserService;

//import entity.User;
//import repository.UserRepository;
//import service.AuthService;
//import service.UserService;
/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private UserRepository userRepository = new UserRepository();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("signedinUser") != null) { 
			String action = request.getParameter("ACTION");	
			if(action != null) {
			    if ("view".equals(action)) {
						int userId = Integer.parseInt(request.getParameter("id"));
						User user = userService.findById(userId);
						out.println(formServe("Read", user));
				} else if ("add".equals(action)) {
						out.println(formServe("Create", null));
					
				} else if ("edit".equals(action)) {
						int userId = Integer.parseInt(request.getParameter("id"));
						User user = userService.findById(userId);
						out.println(formServe("Update", user));
			    }
			}else {
				System.out.println(httpSession.getAttribute("signedinUser"));
				out.println(dashboardServe((int) httpSession.getAttribute("signedinUser")));																						// to
			}
		}
        else {	
			response.sendRedirect("/brief10-employees-manager/sign-in");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("ACTION");

		if ("Create".equals(action)) {
			int TasksN = Integer.parseInt(request.getParameter("tasks_number"));
			User newUser = new User(request.getParameter("firstname")+" "+request.getParameter("lastname"), request.getParameter("role"),
					(request.getParameter("approved") == "true"), request.getParameter("email"),
					request.getParameter("password"), TasksN);
			userService.persist(newUser);
		    response.sendRedirect("/brief10-employees-manager/dashboard/users");
		}

		else if ("Update".equals(action)) {
			int UserId = Integer.parseInt(request.getParameter("user_id"));
			int tasksN = Integer.parseInt(request.getParameter("tasks_number"));
			User editUser = new User(UserId, request.getParameter("firstname")+" "+request.getParameter("lastname"), request.getParameter("role"),
					(request.getParameter("approved") == "true"), request.getParameter("email"),
					request.getParameter("password"), tasksN);
			userService.update(editUser);
		    response.sendRedirect("/brief10-employees-manager/dashboard/users");
		}

		else if ("Delete".equals(action)) {
			int userId = Integer.parseInt(request.getParameter("user_id"));
			userService.delete(userId);
		    response.sendRedirect("/brief10-employees-manager/dashboard/users");
		}

	}

	public String dashboardServe(int signedinUser) {
		var resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		var context = new Context();
		var templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);
		context.setVariable("signedinUser", signedinUser);
		context.setVariable("employees", userRepository.listEmployees());
		context.setVariable("employeesN", userRepository.listEmployees().size());
		context.setVariable("tasksN", userService.tasksCount());
		var result = templateEngine.process("dashboard", context);
		return result;
	}

	public String formServe(String type, User user) {
		var resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		var context = new Context();
		var templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);
		context.setVariable("user", user);
		context.setVariable("type", type);
		var result = templateEngine.process("form", context);
		return result;
	}

}
