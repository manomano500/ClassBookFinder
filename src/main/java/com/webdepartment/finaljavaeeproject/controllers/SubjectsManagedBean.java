package com.webdepartment.finaljavaeeproject.controllers;
import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import java.io.IOException;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;


public class SubjectsManagedBean implements Serializable{

    @Inject
    @EJB
    private SubjectService subjectsService;

 
   
 
    private List<Subject> subjectsList;
    
    private String subject_name;  
    private Subject selectedSubject;



    // Updated addSubject method to set selectedSem
    @Transactional
    public void addSubject() {
        Subject subject = new Subject();
        subject.setSubjectName(subject_name);
//        subject.setSemesterID(selectedSemester);
        subjectsService.addSubject(subject);
    }
    public void deleteSubject(int subject_id) {

        subjectsService.deleteSubject(subject_id);

    }

   

   

    
    public String navigateToSubjeectdetails() {

        // Construct the URL of the department page with the selected department name
        // Return the URL of the department page
        return "toSubjeectdetailsPage";
    }

    
    public void redirectToMainWhenLoadNestedPage() throws IOException {
        if (selectedSubject ==null) {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath() + "/main.xhtml");
        }
    }
    
    
    
    public List<Book> feachBooksForSelectedSubject() {
        if (selectedSubject != null) {
            return selectedSubject.getBookList();
        }
        return null;
    }
/////////////////Getters And Setters//////////////////
    public void setSelectedSubject(Subject subject) {
        this.selectedSubject = subject;
    }

    public Subject getSelectedSubject() {
        return selectedSubject;
    }

    public List<Subject> getSubjectsList() {

        if (subjectsList == null) {
            subjectsList = subjectsService.getAllSubjects();

        } else {
            subjectsList.clear();
            subjectsList = subjectsService.getAllSubjects();
        }
        return subjectsList;
    }
    
    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }



}
