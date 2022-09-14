package com.jtcindia.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="myLogin", urlPatterns={"/login.jtc"})
public class LoginServlet extends HttpServlet {
	String phone;
	String email;
	String state;
	String country;
	public void init(ServletConfig sc) {
	System.out.println("TestServlet -init()");
	// 1.config parameter
	phone = sc.getInitParameter("phone");
	email = sc.getInitParameter("Email");
	// 2.context parameter
	ServletContext ctx = sc.getServletContext();
	state = ctx.getInitParameter("State");
	country = ctx.getInitParameter("Country");
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
	System.out.println(("TestServlet-service()"));
	// 3.Request parameter
	String un = req.getParameter("uname");
	String pn = req.getParameter("phone");
	String eml = req.getParameter("Email");
	String state = req.getParameter("State");
	String cty = req.getParameter("Country");
	// 4.display parameters
	PrintWriter out = res.getWriter();
	out.println("<h1>Username: " + un + "</h1>");
	out.println("<h1>Phone: " + pn + "</h1>");
	out.println("<h1>Email: " + eml + "</h1>");
	out.println("<h1>state: " + state + "</h1>");
	out.println("<h1>Country: " + cty+ "</h1>");
	}
	public void destroy() {
	System.out.println("TestServlet-destroy()");
	}
}
