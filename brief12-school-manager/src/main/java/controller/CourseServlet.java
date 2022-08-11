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

import entity.User;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
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
					int userId = Integer.parseInt(request.getParameter("id"));
					User user = userService.findById(userId);
					out.println(courseFormServe("Read", user));
				} else if ("add".equals(action)) {
					out.println(courseFormServe("Create", null));
				} else if ("edit".equals(action)) {
					int userId = Integer.parseInt(request.getParameter("id"));
					User user = userService.findById(userId);
					out.println(courseFormServe("Update", user));
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
		// TODO Auto-generated method stub
		doGet(request, response);
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
	
	try {
	    System.out.println(courseService.findAll());
	} catch (Exception e) {
		System.out.println("hnaya zmer!");
	}
	context.setVariable("courses", courseService.findAll());
	context.setVariable("trainersN", userRepository.listTrainers().size());
	context.setVariable("talentsN", userRepository.listTalents().size());
	context.setVariable("coursesN", 30);

	var result = templateEngine.process("courses", context);
	return result;
}

public String courseFormServe(String type, User user) {
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
	var result = templateEngine.process("user_form", context);
	return result;
}

}