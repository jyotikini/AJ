package org.primefaces.showcase.view.file;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


public class FileDownload {

	private StreamedContent file;

	public FileDownload() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("C:/Users/Asad/git/datatable/fileuploaddownload/WebContent/resources/default/uploads/Abuzar_2332647618847178449.jpg");
		file = new DefaultStreamedContent(stream, "image/jpg",
				"Abuzar_2332647618847178449.jpg");
	}

	public StreamedContent getFile() {
		System.out.println("getFile:"+file.getContentType());
		return file;
	}
}
