package testpack;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
/*@ManagedBean
public class Bean {
     
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    }*/
import java.io.InputStream;  
import org.primefaces.model.DefaultStreamedContent;  
import org.primefaces.model.StreamedContent;  
@ManagedBean
@SessionScoped
public class FileDownloadController {  

    private StreamedContent file;  

    public FileDownloadController() {

        /*nputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("C:/Users/LENOVO/Desktop/Poonam/2413550_QA Test Plan.xlsx");  
        System.out.print("inside download111");
        file = new DefaultStreamedContent(stream); */
    	InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/default/images/Chrysanthemum.jpg");
        file = new DefaultStreamedContent(stream, "image/jpg", "Chrysanthemum.jpg");
    }

    public StreamedContent getFile() {
        return file;
    }
}