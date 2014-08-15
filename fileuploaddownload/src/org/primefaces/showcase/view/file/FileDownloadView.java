package org.primefaces.showcase.view.file;

import java.io.File;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sun.org.glassfish.gmbal.ManagedData;

@ManagedBean
public class FileDownloadView {

	private String filename;
	private StreamedContent file;

	public FileDownloadView() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("C:/Users/Asad/git/datatable/fileuploaddownload/WebContent/resources/default/uploads/Abuzar_2332647618847178449.jpg");
		file = new DefaultStreamedContent(stream, "image/jpeg", "Abuzar_2332647618847178449.jpg");
		//System.out.println(file.getName());
		
		// System.out.println("Number of file : " + count);

	}

	public StreamedContent getFile() {
		System.out.println("getfile:"+file.getName());
		return file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void action() {
		//System.out.println("file download view: " + filename);
		
	}
}
