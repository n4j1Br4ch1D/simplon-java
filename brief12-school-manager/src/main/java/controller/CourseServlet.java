package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.UserRepository;
import service.CourseService;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import entity.Course;
import entity.User;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository = new UserRepository();
	private CourseService courseService = new CourseService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("signedinUser") != null) {
			String action = request.getParameter("ACTION");
			if (action != null) {
				if ("view".equals(action)) {
					int courseId = Integer.parseInt(request.getParameter("id"));
					Course course = courseService.findById(courseId);
					out.println(courseFormServe("Read", course));
				} else if ("add".equals(action)) {
					out.println(courseFormServe("Create", null));
				} else if ("edit".equals(action)) {
					int courseId = Integer.parseInt(request.getParameter("id"));
					Course course = courseService.findById(courseId);
					out.println(courseFormServe("Update", course));
				}
			} else {
			    System.out.println(httpSession.getAttribute("signedinUser"));
			    out.println(coursesServe((int) httpSession.getAttribute("signedinUser"))); // to	
			}
		} else {
			response.sendRedirect("/brief12-school-manager/sign-in");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("ACTION");
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("signedinUser") != null) {
			if ("Create".equals(action)) {
				int TasksN = Integer.parseInt(request.getParameter("tasks_number"));
//				User newUser = new Course(request.getParameter("firstname") + " " + request.getParameter("lastname"),
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
//				userService.delete(userId);
				response.sendRedirect("/brief12-school-manager/dashboard/users?role=talent");
			}
		} else {
			response.sendRedirect("/brief12-school-manager/sign-in");
		}
	}

public String coursesServe(int signedinUser) {
	var resolver = new ClassLoaderTemplateResolver();
	resolver.setTemplateMode(TemplateMode.HTML);
	resolver.setCharacterEncoding("UTF-8");
	resolver.setPrefix("/templates/");
	resolver.setSuffix(".html");
	var context = new Context();
	var templateEngine = new TemplateEngine();
	templateEngine.setTemplateResolver(resolver);
	context.setVariable("signedinUser", signedinUser);
	System.out.println("heheo");
	context.setVariable("courses", courseService.findAll());
	context.setVariable("trainersN", userRepository.listTrainers().size());
	context.setVariable("talentsN", userRepository.listTalents().size());
	context.setVariable("coursesN", 30);

	var result = templateEngine.process("courses", context);
	return result;
}

public String courseFormServe(String type, Course course) {
	var resolver = new ClassLoaderTemplateResolver();
	resolver.setTemplateMode(TemplateMode.HTML);
	resolver.setCharacterEncoding("UTF-8");
	resolver.setPrefix("/templates/");
	resolver.setSuffix(".html");
	var context = new Context();
	var templateEngine = new TemplateEngine();
	templateEngine.setTemplateResolver(resolver);
	context.setVariable("course", course);
	context.setVariable("type", type);
	context.setVariable("trainers", userRepository.listTrainers());
	var result = templateEngine.process("course_form", context);
	return result;
}

}