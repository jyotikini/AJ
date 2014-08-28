package com.dev;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthFilter implements Filter {

	public AuthFilter() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				System.out.println("in AuthFilter class: init()");
	}

	@Override
	public void doFilter(ServletRequest reques, ServletResponse respons,
			FilterChain chain) throws IOException, ServletException {
		try {
			System.out.println("in AuthFilter class: doFilter()");
			
			// check whether session variable is set
			HttpServletRequest reqe = (HttpServletRequest) reques;
			HttpServletResponse resp = (HttpServletResponse) respons;
			
			HttpSession sesn = reqe.getSession(true);
			System.out.println("ses.getAttribute('username')"+sesn.getAttribute("username"));
			// allow user to proccede if url is home.xhtml or user logged in or
			// user is accessing any page in //public folder
			String reqURI = reqe.getRequestURI();
			//System.out.println(reqURI + "\nreqURI.indexOf('/faces/home.xhtml')="
			//		+ reqURI.indexOf("/faces/home.xhtml"));
			//
			/*if(sesn.getAttribute("username")==null){
				
				sesn.setAttribute("username", "Guest");
			}*/
			if (reqURI.indexOf("/home.xhtml") >= 0 ||(sesn != null && sesn.getAttribute("username") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource")) {
				chain.doFilter(reques, respons);
				
				System.out.println("new session");
			} else{
				// user didn't log in but asking for a page that is not allowed
				// so take user to login page
				resp.sendRedirect(reqe.getContextPath() + "/faces/home.xhtml"); // Anonymous
																			// user.
																			// Redirect
																			// to
																			// login
																			// page
	            System.out.println(reqe.getContextPath() + "/faces/home.xhtml"+"--redirect to home page");
			}
		} catch (Throwable t) {
			System.out.println(t.getMessage());
		}
	} // doFilter

	@Override
	public void destroy() {

	}
}
