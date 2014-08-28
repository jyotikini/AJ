package com.dev;



import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



@ManagedBean
public class FileDownloadView {

	private String filename;
	private StreamedContent file;

	public FileDownloadView() {

		// System.out.println("Number of file : " + count);

	}

	public StreamedContent getFile() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/default/uploads/" + filename);
		file = new DefaultStreamedContent(stream, "image/jpg", filename);
		System.out.println(file.getName());
		System.out.println("getfile:" + file.getName());
		return file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		System.out.println("setFilename:" + filename);
		this.filename = filename;
	}

	public void action() {

		// System.out.println("file download view: " + filename);

	}
}
