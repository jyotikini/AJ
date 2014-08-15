package org.primefaces.showcase.view.file;

import java.io.File;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileDownloadView {

	private StreamedContent file;

	public FileDownloadView() {

		int count = new File(
				"C:/Users/Asad/git/datatable/fileuploaddownload/WebContent/resources/default/uploads")
				.list().length;
		System.out.println("Number of file : " + count);

		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream("/resources/default/images/expand.jpg");
		file = new DefaultStreamedContent(stream, "images/jpg",
				"dwn_expand.jpg");
	}

	public StreamedContent getFile() {
		return file;
	}
}
