package com.covalense.mywebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String movieName = ctx.getInitParameter("movie");
		ServletConfig config = getServletConfig();
		String actorName = config.getInitParameter("actor");

		String currentDateTime = new Date().toString();

		String httpMethod = req.getMethod();
		String protocol = req.getProtocol();
		String requestUrl = req.getRequestURI().toString();
		System.out.println("HTTP Method : " + httpMethod);
		System.out.println("Protocol : " + protocol);
		System.out.println("URL : " + requestUrl);

		// Get Query String information
		String fnameValue = req.getParameter("fname");
		String lnameValue = req.getParameter("lname");

		String htmlResponse = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"ISO-8859-1\">"
				+ "<title>My First HTML</title>" + "</head>" + "<body>" + "<h1>  Current date & time is :" + "<br>"
				+ currentDateTime + "<br><br>" + "First Name : " + fnameValue + "<br>" + "Last Name : " + lnameValue
				+ " " + "movieName " + movieName + "actorName " + actorName + "<span style =\"color : red\"> </span> "
				+ "</h1>" + "</body>" + "</html>";
		// Send the above HTML Response to browser
		resp.setContentType("text/html");
		// resp.setHeader("Refresh", "1");// Auto Refresh
		PrintWriter out = resp.getWriter();
		out.print(htmlResponse);
	}

}
