package com.webdepartment.finaljavaeeproject.controllers;
import com.webdepartment.finaljavaeeproject.aice.SemesterEnum;
import com.webdepartment.finaljavaeeproject.entities.Book;
import com.webdepartment.finaljavaeeproject.entities.Subject;
import com.webdepartment.finaljavaeeproject.services.SubjectService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.transaction.Transactional;


public class SubjectsManagedBean implements Serializable {

    @Inject
    @EJB
    private SubjectService subjectsService;

 
    private List<Subject> subjectsList;
    
    private String subject_name;
    private String selectedSemester; // Updated to Long type to store semester ID

    public List<Subject> getSubjectsList() {

        if (subjectsList==null) {
            subjectsList = subjectsService.getAllSubjects();

            
        }else{
            subjectsList.clear();
            subjectsList = subjectsService.getAllSubjects();
        }
        return subjectsList;
    }



    // Updated addSubject method to set selectedSem
    @Transactional
    public void addSubject() {
        Subject subject = new Subject();
        subject.setSubId(5);
        subject.setSubName("vvvv");
        subject.setSemester("sem1");
        subjectsService.addSubject(subject);
    }
    public void deleteSubject(int subject_id) {

        subjectsService.deleteSubject(subject_id);

    }

    // Getters and setters for selectedSem
    public String getSelectedSem() {
        return selectedSemester;
    }

    public void setSelectedSem(String selectedSem) {
        this.selectedSemester = selectedSem;
    }

    // Getters and setters for subject_name
    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    // Existing code...
    

    
    
    
    
    
    
    
    
}
