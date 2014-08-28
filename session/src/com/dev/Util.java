package com.dev;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@ManagedBean
public class Util {

	public static HttpSession getSession() {
		System.out.println("in util class: getSession()");
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		System.out.println("in util class: getRequest()");
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() {
		System.out.println("in util class: getUserName()");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("username").toString();
	}

	public static String getItem1() {
		System.out.println("in util class: getItem1()");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null)
			return session.getAttribute("item1").toString();
		else
			return null;
	}
	public static String getItem2() {
		System.out.println("in util class: getItem2()");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null)
			return session.getAttribute("item2").toString();
		else
			return null;
	}
}
