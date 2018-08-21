package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.print("<a href='index.html'>Home </a>");
		out.println("<h1>Welcome to Server Side Scripting</h1>");
		if (request.getParameter("name") != null && request.getParameter("gender") != null) {
			if (request.getParameter("gender").equalsIgnoreCase("m")) {
				out.println("<h3> Welcome Mr." + request.getParameter("name") + " to Servlet Programming </h3>");
			} else if (request.getParameter("gender").equalsIgnoreCase("f")) {
				out.println("<h3> Welcome Ms/Mrs." + request.getParameter("name") + " to Servlet Programming </h3>");
			}
		} else {
			out.println("<h2>Required Parameter are missing/empty!!! </h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
