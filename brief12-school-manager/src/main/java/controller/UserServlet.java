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
import service.CourseService;
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
	private CourseService courseService = new CourseService();

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
			if (action != null) {
				if ("view".equals(action)) {
					int userId = Integer.parseInt(request.getParameter("id"));
					User user = userService.findById(userId);
					out.println(userFormServe("Read", user));
				} else if ("add".equals(action)) {
					out.println(userFormServe("Create", null));

				} else if ("edit".equals(action)) {
					int userId = Integer.parseInt(request.getParameter("id"));
					User user = userService.findById(userId);
					out.println(userFormServe("Update", user));
				}
			} else {
				String role = request.getParameter("role");
			    System.out.println(httpSession.getAttribute("signedinUser"));
			    out.println(usersServe(role, (int) httpSession.getAttribute("signedinUser"))); // to	
			}
		} else {
			response.sendRedirect("/brief12-school-manager/sign-in");
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
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("signedinUser") != null) {
			if ("Create".equals(action)) {
				int TasksN = Integer.parseInt(request.getParameter("tasks_number"));
//				User newUser = new User(request.getParameter("firstname") + " " + request.getParameter("lastname"),
//						request.getParameter("role"), request.getParameter("approved").equals("true"),
//						request.getParameter("email"), request.getParameter("password"), TasksN);
//				userService.persist(newUser);
				response.sendRedirect("/brief12-school-manager/dashboard/users?role=talent");
			}

			else if ("Update".equals(action)) {
				System.out.println("====#>" + (request.getParameter("approved").equals("true") + "<#===="));
				int UserId = Integer.parseInt(request.getParameter("user_id"));
				int tasksN = Integer.parseInt(request.getParameter("tasks_number"));
//				User editUser = new User(UserId,
//						request.getParameter("firstname") + " " + request.getParameter("lastname"),
//						request.getParameter("role"), request.getParameter("approved").equals("true"),
//						request.getParameter("email"), request.getParameter("password"), tasksN);
//				userService.update(editUser);
//				response.sendRedirect("/brief12-school-manager/dashboard/users?role=talent");
			}

			else if ("Delete".equals(action)) {
				int userId = Integer.parseInt(request.getParameter("user_id"));
				userService.delete(userId);
				response.sendRedirect("/brief12-school-manager/dashboard/users?role=talent");
			}
		} else {
			response.sendRedirect("/brief12-school-manager/sign-in");
		}
	}

	public String usersServe(String role, int signedinUser) {
		var resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		var context = new Context();
		var templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);
		context.setVariable("signedinUser", signedinUser);
		System.out.println("jjjjj"+role);
		context.setVariable("role", role);
		System.out.println(role.equals("talent"));

		context.setVariable("users", role.equals("talent") ? userRepository.listTalents() : userRepository.listTrainers());
		System.out.println(role.equals("talent") ? userRepository.listTalents() : userRepository.listTrainers());
		
		context.setVariable("trainersN", userRepository.listTrainers().size());
		context.setVariable("talentsN", userRepository.listTalents().size());
		context.setVariable("coursesN", courseService.findAll().size());

		var result = templateEngine.process("users", context);
		return result;
	}

	public String userFormServe(String type, User user) {
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
		context.setVariable("courses", courseService.findAll());
		var result = templateEngine.process("user_form", context);
		return result;
	}

}
