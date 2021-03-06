package com.aj.gcshare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
public class FileUploadView {

	private UploadedFile uploadedFile;
	private String fileName;

	// Actions
	// ------------------------------------------------------------------------------------

	public void save() {

		// Just to demonstrate what information you can get from the uploaded
		// file.
		//System.out.println("File type: " + uploadedFile.getContentType());
		//System.out.println("File name: " + uploadedFile.getFileName());
		//System.out.println("File size: " + uploadedFile.getSize() + " bytes");

		// Prepare filename prefix and suffix for an unique filename in upload
		// folder.
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		String prefix =dateFormat.format(date)+" "+FilenameUtils.getBaseName(uploadedFile.getFileName())+" _";
		String suffix = FilenameUtils.getExtension(uploadedFile.getFileName());

		// Prepare file and outputstream.
		File file = null;
		OutputStream output = null;

		try {
			// Create file with unique name in upload folder and write to it.
			file = File
					.createTempFile(
							prefix + "_",
							"." + suffix,
							new File(
									"C:/Users/Kini-PC/git/AJ 1.1/AJ/GCShare/WebContent/resources/default/uploads"));
			output = new FileOutputStream(file);
			IOUtils.copy(uploadedFile.getInputstream(), output);
			fileName = file.getName();
			
			// Show succes message.
			FacesContext.getCurrentInstance().addMessage(
					"uploadForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"File upload succeed!", null));
		} catch (IOException e) {
			// Cleanup.
			if (file != null)
				file.delete();

			// Show error message.
			FacesContext.getCurrentInstance().addMessage(
					"uploadForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"File upload failed with I/O error.", null));

			// Always log stacktraces (with a real logger).
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(output);
		}
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public String getFileName() {
		return fileName;
	}

	// Setters
	// ------------------------------------------------------------------------------------

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
