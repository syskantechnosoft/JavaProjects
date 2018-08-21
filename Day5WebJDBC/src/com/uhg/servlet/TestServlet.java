package com.uhg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (request.getParameter("username").equalsIgnoreCase("admin")
				&& request.getParameter("password").equals("admin123")) {
			out.print("<h1>Welcome Admin </h1>");
			out.print("<table align='center' border='1'>");
			out.print("<tr><th>Sl No</th><th>Header Name</th><th>Header Value</th></tr>");

			Enumeration<String> headers = request.getHeaderNames();
			int i = 1;
			while (headers.hasMoreElements()) {
				String header = headers.nextElement();
				out.println("<tr><td>" + i + "</td> <td>" + header + "</td> <td>" 
				+ request.getHeader(header)+ "</td></tr>");
				i++;
			}
			out.print("</table>");
		} else {
			out.println("<h2>Invalid Username and/or password !!! Pls Try Again </h2>");
			out.println("<a href='index.html'>click here </a> to try again.");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
