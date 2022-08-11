 package controller;

import service.AuthService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import dao.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//import entity.User;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static HttpSession httpSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public AuthServlet() {
		// super();
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
		if(httpSession != null && httpSession.getAttribute("signedinUser") != null) {   //if login session send to dashboard
			response.sendRedirect("dashboard/users?role=talent");
		}else {   //else send to sign-in
		   out.print(signInServe(false));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
//		   AuthService authService = new AuthService();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession httpSession = request.getSession();
		String action = request.getParameter("ACTION");
		if ("Sign_in".equals(action)) {
			    User admin = new User();
		        admin.setEmail(request.getParameter("email"));
		        admin.setPassword(request.getParameter("password"));
		    	AuthService authService = new AuthService();
				User adminSignedIn = authService.signIn(admin);
				if(adminSignedIn != null) {
					// Register Session;
					httpSession.setAttribute("signedinUser", adminSignedIn.getId());
					response.sendRedirect("dashboard/users?role=talent");
				}else {
					out.print(signInServe(true));	
				}
		}

		else if ("Sign_out".equals(action)) {
			// Clear Session
			httpSession.invalidate();
			response.sendRedirect("/brief12-school-manager/sign-in");
		}
	}

	public String signInServe(boolean error) {
		var resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		var context = new Context();
		var templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);
		context.setVariable("SigninError", error);
		context.setVariable("email", "leila@anmoon.ma");
		context.setVariable("password", "password");
		var result = templateEngine.process("signin", context);
		return result;
	}
	

}
