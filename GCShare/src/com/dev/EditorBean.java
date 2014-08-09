	
	
	package com.dev;
	 
	import java.io.IOException;
	import java.io.Serializable;
	import javax.faces.FacesException;
	import javax.faces.bean.ManagedBean;
	import javax.faces.application.FacesMessage;
	import javax.faces.context.ExternalContext;
	import javax.faces.context.FacesContext;

	//import org.primefaces.event.CloseEvent;
	 
	
	@ManagedBean(name = "editorBean")
	//@SessionScoped
	public class EditorBean implements Serializable
	{  
		private static final long serialVersionUID = 9202476277272066502L;
		
		private static String output;
		private static String value="";
		  

	    public EditorBean() {
	    	
	    	System.out.println("constructor");
	    }
	     
	    
	    public String redirect() {

	        FacesContext ctx = FacesContext.getCurrentInstance();

	        ExternalContext extContext = ctx.getExternalContext();
	        String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, "editor.xhtml"));
	        System.out.println(url);
	        try {

	            extContext.redirect(url);
	        } catch (IOException ioe) {
	            throw new FacesException(ioe);

	        }
	        return null;
	 
	    }
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }		
	    	    
		public String getOutput() {
			System.out.println("getOutput()"+output);
			return output;
		}

		public void setPublish(){
			System.out.println("setPublish()"+this.value);
			this.value=output;
			System.out.println("setPublish()"+this.value);
		}
		public void setOutput(String output) {
			System.out.println("setOutput()"+output);
			this.output = output;
		}

		public String getValue() {  
	    	System.out.println("getValue()"+value);
	        return value;  
	    }  
		
	    public void setValue(String value) { 
	    	System.out.println("setValue()"+value);
	    	addMessage("System Error", value+"! Please try again later.");
	        this.value = value;  
	        //getOutValue();
	    }
	    
	}  
