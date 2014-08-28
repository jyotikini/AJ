package com.dev;

import com.dev.UserDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginBean")
@SessionScoped
/**
 *
 * @author User
 */
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	private String message, uname;
	public HttpSession session;
	String item1;
	String item2;

	public void createItem1() {
		System.out.println("the value of session is :"+session.toString());
		System.out.println("no session");
		session.setAttribute("item1", "You had set item1");
		
	}

	public void createItem2() {
		//session = Util.getSession();
		session.setAttribute("item2", "You had set item2");
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String loginProject() {
		boolean result = UserDAO.login(uname, password);
		System.out
				.println("in login bean-loginProject- result_login:" + result);
		if (result) {
			// get Http Session and store username
			session = Util.getSession();
			session.setAttribute("username", uname);
			
			return "home?faces-redirect=true";
		} else {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Invalid Login!", "Please Try Again!"));

			// invalidate session, and redirect to other pages

			// message = "Invalid Login. Please Try Again!";
			return "home?faces-redirect=true";
		}
	}

	public String getSessionUser() {
		try {
			//System.out.println("getsessionuser:"+Util.getUserName());
			return Util.getUserName();
		} catch (NullPointerException npe) {
			System.out.println("while executing getSessionuser system got :" + npe.getMessage());
			return "Guest";
		}
	}

	public String retrieveItem2() {
		try {
			
			item2 = Util.getItem2();
			System.out.println("get item1: "+item2);
			return item2;
		} catch (NullPointerException npe) {
			System.out.println("got" + npe + " while executing retrieveItem2");
			return "home";
		}
	}

	public String retrieveItem1() {
		try {
			item1 = Util.getItem1();
			System.out.println("get item1: "+item1);
			return item1;
		} catch (NullPointerException npe) {
			System.out.println("got" + npe + " while executing retrieveItem1");
			return "home";
		}
		
	}

	public String logout() {
		HttpSession session = Util.getSession();

		//session.setAttribute("username", "Guest");
		 session.invalidate();
		return "home?faces-redirect=true";
	}
}
