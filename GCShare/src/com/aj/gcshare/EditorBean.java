	
	
	package com.aj.gcshare;
	 
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
		
		private static String overview;
		private static String reports;
		private static String achievements;
		private static String training;
		private static String overviewGeneral;
		private static String reportsGeneral;
		private static String achievementsGeneral;
		private static String trainingGeneral;
		  

	    public EditorBean() {
	    	
	    	System.out.println("constructor");
	    }	
	    
	    

		public String getOverview() {
			return overview;
		}



		public void setOverview(String overview) {
			this.overview = overview;
		}



		public String getReports() {
			return reports;
		}



		public void setReports(String reports) {
			this.reports = reports;
		}



		public String getAchievements() {
			return achievements;
		}



		public void setAchievements(String achievements) {
			this.achievements = achievements;
		}



		public String getTraining() {
			return training;
		}



		public void setTraining(String training) {
			this.training = training;
		}



		public String getOverviewGeneral() {
			return overviewGeneral;
		}

		public String getReportsGeneral() {
			return reportsGeneral;
		}

		public String getAchievementsGeneral() {
			return achievementsGeneral;
		}
		
		public String getTrainingGeneral() {
			return trainingGeneral;
		}


		public void setPublish(){
			this.overviewGeneral=overview;
			this.reportsGeneral=reports;
			this.achievementsGeneral=achievements;
			this.trainingGeneral=training;
			
		}
		
	}  
